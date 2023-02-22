package screens;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import entity.Bird;
import main.BackGround;

public class StartScreen implements Screen{
	

	Bird bird;
	BackGround backGround;
	BufferedImage title, startButton;
	
	public StartScreen(Bird bird, BackGround backGround) {
		bird = bird;
		backGround = backGround;
		getTileImage();
	}
	
	// loads title and start button images
	public void getTileImage() {
		try {
			title = ImageIO.read(getClass().getResourceAsStream("/Tiles/Title.png"));
			startButton = ImageIO.read(getClass().getResourceAsStream("/Tiles/Start Button.png"));
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
	public void draw(Graphics2D g2) {	// draws all objects
		backGround.draw(g2);
		g2.drawImage(title, 85, 300, title.getWidth() * 2, title.getHeight() * 2, null);	
		g2.drawImage(startButton, 161, 510, startButton.getWidth() * 2, startButton.getHeight() * 2, null);
		bird.drawStartScreen(g2);
	}
}
