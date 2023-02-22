package screens;

import java.awt.Graphics2D;
import entity.Bird;
import main.BackGround;
import pipes.PipeGenerator;
import score.ScoreBoard;

public class RunningScreen implements Screen {
	
	BackGround backGround;
	Bird bird;
	PipeGenerator pipeGen;
	ScoreBoard scoreBoard;

	
	
	public RunningScreen(Bird bird, BackGround backGround, PipeGenerator pipeGen, ScoreBoard scoreBoard) {
		this.bird = bird;
		this.backGround = backGround;
		this.pipeGen = pipeGen;
		this.scoreBoard = scoreBoard;
	}

	@Override
	public void update() {
		backGround.update();	// updates background and moving stripe
		bird.update();	// Updates pipe and player positions
		bird.updateRunningScreen();
		pipeGen.updateRunningScreen();
	}

	@Override
	public void draw(Graphics2D g2) {
		backGround.draw(g2);	// draws backGround and moving Stripe
		pipeGen.draw(g2);		// draws Pipes for every screen except the start Screen
		scoreBoard.drawCurrentScore(g2);	// draws the score
		bird.drawRunningScreen(g2);
	}
}
