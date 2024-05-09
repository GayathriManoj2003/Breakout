// BrickController.java
package Breakout;

import java.awt.*;

public class BrickController {
    private Brick[][] bricks;

    private BrickFlyweight brickFlyweight;
 
    public BrickController() {
    	
    }
    public BrickController( int screenWidth, int screenHeight, Color brickColor, int brickDurability) {
        int rows = screenHeight/20;
        int cols = screenWidth/80;
        bricks = new Brick[rows][cols];

        brickFlyweight = new BrickFlyweight(brickColor, 80, 20);

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * 80 + 10;
                int y = row * 20 + 10;
                bricks[row][col] = new Brick(x, y, brickDurability);
            }
        }
    }

    public int getWidth() {
    	return this.brickFlyweight.getWidth();
    }
 
    public int getHeight() {
    	return this.brickFlyweight.getHeight();
    }
    
    public Brick[][] getBricks() {
        return bricks;
    }

    public void drawBricks(Graphics2D g) {
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                bricks[row][col].draw(g, getWidth(), getHeight());
            }
        }
    }
}
