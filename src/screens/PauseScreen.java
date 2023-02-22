package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Bird;
import main.BackGround;
import pipes.PipeGenerator;
import score.ScoreBoard;

public class PauseScreen implements Screen{
	
	BackGround backGround;
	PipeGenerator pipeGen;
	Bird bird;
	ScoreBoard scoreBoard;
	BufferedImage pauseButton;
	
	public PauseScreen(Bird bird, BackGround backGround, PipeGenerator pipeGen, ScoreBoard scoreBoard) {
		this.bird = bird;
		this.backGround = backGround;
		this.pipeGen = pipeGen;
		this.scoreBoard = scoreBoard;
		getTileImage();		// gets the image of the pause button
	}
	
	private void getTileImage() {
		
		try {
			pauseButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/pause button.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {}

	@Override
	public void draw(Graphics2D g2) {
		backGround.draw(g2);		// draws the background and moving stripe
		pipeGen.draw(g2);		// draws Pipes for every screen except the start Screen
		bird.drawRunningScreen(g2);
		g2.drawImage(pauseButton, 204, 377, pauseButton.getWidth() * 2, pauseButton.getHeight() * 2, null);		// draws the pause button
		scoreBoard.drawCurrentScore(g2);
	}
}
