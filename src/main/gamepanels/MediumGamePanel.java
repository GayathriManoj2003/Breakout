package main.gamepanels;

import java.awt.Color;

public class MediumGamePanel extends GamePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numberOfBrickRows = 8;
	private static int ballVelocityX = 10;
	private static int ballVelocityY = 10;

	public MediumGamePanel() {
		super( ballVelocityX, ballVelocityY, numberOfBrickRows, 2, Color.BLUE, Color.ORANGE);
    }
}
