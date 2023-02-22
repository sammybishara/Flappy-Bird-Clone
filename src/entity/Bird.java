package entity;


import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import controls.KeyHandler;


public class Bird {

	public int x, y, speed, imageIndex, jumpCount, fallCount, spriteCounter;
	KeyHandler keyH;
	BufferedImage[] sprites;
	public boolean isDead;

	
	
	public Bird(KeyHandler keyH) {
		this.keyH = keyH;
		sprites = new BufferedImage[3];
		setDefaultValues();
		getPlayerImage();	
	}
	
	// default starting position 
	public void setDefaultValues() {
		jumpCount = 4;
		fallCount = 40;
		x = 200;					
		y = 400;
		speed = 6;
		imageIndex = 0;
		isDead = false;
		spriteCounter = 0;
	}
	
	
	// adds different sprite images into array
	void getPlayerImage() {
		try {
			
			sprites[0] = ImageIO.read(getClass().getResourceAsStream("/Bird/forward_1.png"));
			sprites[1] = ImageIO.read(getClass().getResourceAsStream("/Bird/forward_2.png"));
			sprites[2] = ImageIO.read(getClass().getResourceAsStream("/Bird/forward_3.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	// updates the player sprite animations every 10 frames
	public void update() {		
		spriteCounter++;
		
		if (spriteCounter == 10) {
			imageIndex++;
			spriteCounter = 0;
		}
		if (imageIndex > 2) imageIndex = 0;
	}
	
	// moves the player 
	public void updateRunningScreen() {
			updateMovements();
	}
	
	private void updateMovements() {
		if (keyH.upPressed == true) {
			if (!(y <= 0)) {
				y -= speed;
				jumpCount = 0;
				fallCount = 0;
			}

		} else y += 2;
	}

	// draws the current player sprite onto the screen
	public void drawRunningScreen(Graphics2D g2) { 
		BufferedImage image = sprites[imageIndex];
		// draws bird flying up
		if (jumpCount < 31) {
			double angle = Math.toRadians(340);
			g2.rotate(angle, x, y);
			g2.drawImage(image, x - 12, y + 12, image.getWidth() * 2 , image.getHeight() * 2 , null);
			g2.rotate(-1 * angle, x, y);
			jumpCount++;
		// draws bird stationary
		} else if (jumpCount == 31 && fallCount < 8) {
			g2.drawImage(image, x, y, image.getWidth() * 2 , image.getHeight() * 2 , null);
			fallCount++;
		// draws bird falling
		} else {
			double angle = Math.toRadians(20);
			g2.rotate(angle, x, y);
			g2.drawImage(image, x + 12, y - 12, image.getWidth() * 2 , image.getHeight() * 2 , null);
			g2.rotate(-1 * angle, x, y);
		}
	}
	
	public void drawStartScreen(Graphics2D g2) {
		BufferedImage image = sprites[imageIndex];
		g2.drawImage(image, x, y, image.getWidth() * 2 , image.getHeight() * 2 , null);
	}

	public void drawEndScreen(Graphics2D g2) {
		BufferedImage image = sprites[imageIndex];
		g2.drawImage(image, x, y, image.getWidth() * 2 , image.getHeight() * 2 , null);
	}
}