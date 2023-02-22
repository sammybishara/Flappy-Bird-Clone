package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Bird;
import main.BackGround;
import pipes.PipeGenerator;
import score.ScoreBoard;


public class EndScreen implements Screen{
	
	
	Bird bird;
	BackGround backGround;
	PipeGenerator pipeGen;
	ScoreBoard scoreBoard;
	BufferedImage gameOverPanel, okButton;

	public EndScreen(Bird bird, BackGround backGround, PipeGenerator pipeGen, ScoreBoard scoreBoard) {
		this.bird = bird;
		this.backGround = backGround;
		this.pipeGen = pipeGen;
		this.scoreBoard = scoreBoard;
		getTileImages();		// gets the score board and game over panel images
	}

	private void getTileImages() {
		try {
			gameOverPanel = ImageIO.read(getClass().getResourceAsStream("/Tiles/Game Over.png"));
			okButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/Ok Button.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update() {}

	@Override
	public void draw(Graphics2D g2) {
		backGround.draw(g2);
		pipeGen.draw(g2);
		bird.drawEndScreen(g2);
		g2.drawImage(gameOverPanel, 78, 230, gameOverPanel.getWidth() * 2, gameOverPanel.getHeight() * 2, null);
		scoreBoard.drawMedals(g2);
		scoreBoard.drawFinalScore(g2);
		g2.drawImage(okButton, 161, 510, okButton.getWidth() * 2, okButton.getHeight() * 2, null);
		
	}

}
