package main.gamepanels;

import java.awt.Color;

public class EasyGamePanel extends GamePanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static int numberOfBrickRows = 4;
	private static int ballVelocityX = 5;
	private static int ballVelocityY = 10;

	public EasyGamePanel() {
		super( ballVelocityX, ballVelocityY, numberOfBrickRows, 1, Color.BLUE, Color.YELLOW);
        setBackground(Color.WHITE);
    }
}
