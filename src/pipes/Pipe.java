package pipes;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Pipe {
	
	BufferedImage bottomRim, topRim, bottomPipe, topPipe;
	public int bottomRimY, topRimY, rimX, pipeX, bottomPipeY;
	public int rimHeight, rimWidth, pipeWidth, bottomPipeHeight, topPipeHeight;
	public final int groundY = 626;			// where the ground is located for bottom of pipe	
	public int distanceInBetween = 130;		// distance in between top rim and bottom rim
	
	
	public Pipe(int x, int y) {
		this.rimHeight = topRim.getHeight() * 2;
		this.rimWidth = topRim.getWidth() * 2;
		this.pipeWidth = bottomPipe.getWidth() * 2;
		this.rimX = x;
		this.bottomRimY = y;
		this.topRimY = (bottomRimY - distanceInBetween) - rimHeight;
		this.pipeX = rimX + 4;
		this.bottomPipeY = bottomRimY + rimHeight;  
		this.bottomPipeHeight = groundY - bottomPipeY;
		this.topPipeHeight = topRimY;
		getPipeImage();
	}
	
	private void getPipeImage() {
		
		try {
			// pipe and rim images
			bottomRim = ImageIO.read(getClass().getResourceAsStream("/Tiles/Bottom Rim.png"));
			bottomPipe = ImageIO.read(getClass().getResourceAsStream("/Tiles/Bottom Pipe.png"));
			topRim = ImageIO.read(getClass().getResourceAsStream("/Tiles/Top Rim.png"));
			topPipe = ImageIO.read(getClass().getResourceAsStream("/Tiles/Top Pipe.png"));
			
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public int getEndOfPipe() {
		return rimX + rimWidth;
	}
	
	public int getBottomOfTopRim() {
		return topRimY + rimHeight;
	}
	
	// continues to move pipe if there is no collision
	public void updateRunningScreen() {
		rimX--;
		pipeX--;
	}
	
	// draws top rim, bottomRim, top Pipe, and bottom Pipe
	public void draw(Graphics2D g2) {
		g2.drawImage(bottomRim, rimX, bottomRimY, rimWidth, rimHeight , null);    
		g2.drawImage(topRim, rimX, topRimY, rimWidth, rimHeight, null);
		g2.drawImage(bottomPipe, pipeX, bottomPipeY, pipeWidth, bottomPipeHeight, null);
		g2.drawImage(topPipe, pipeX, 0, pipeWidth, topRimY, null);
		
	}

}
