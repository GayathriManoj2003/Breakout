package main.gamepanels;

import java.awt.Color;

public class HardGamePanel extends GamePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numberOfBrickRows = 12;
	private static int ballVelocityX = 10;
	private static int ballVelocityY = 10;

	public HardGamePanel() {
		super( ballVelocityX, ballVelocityY, numberOfBrickRows, 3, Color.BLUE, Color.RED);
    }
}
