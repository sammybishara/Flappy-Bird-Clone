package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import main.BackGround;
import entity.Bird;

public class GetReadyScreen implements Screen{

	Bird bird;
	BackGround backGround;
	BufferedImage getReady, tapInstruction;
	
	public GetReadyScreen(Bird bird, BackGround backGround) {
		this.bird = bird;
		this.backGround = backGround;
		getTileImage();
	}
	
	private void getTileImage() {
		try {
			
			getReady = ImageIO.read(getClass().getResourceAsStream("/Tiles/Get Ready.png"));
			tapInstruction = ImageIO.read(getClass().getResourceAsStream("/Tiles/Tap Instruction.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void update() {
		backGround.update();
		bird.update();
	}

	@Override
	public void draw(Graphics2D g2) {
		backGround.draw(g2);
		g2.drawImage(getReady, 88, 250, getReady.getWidth() * 2, getReady.getHeight() * 2, null);
		g2.drawImage(tapInstruction, 255, 350, tapInstruction.getWidth() * 2, tapInstruction.getHeight() * 2, null);
		bird.drawStartScreen(g2);
		
		
	}
	
}

