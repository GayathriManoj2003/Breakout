// BrickController.java
package main.controllers;

import java.awt.*;

import main.models.Brick;
import main.models.BrickFlyweight;
import main.views.BrickView;

public class BrickController {
    private Brick[][] bricks;

    private BrickFlyweight brickFlyweight;
    
    private BrickView brickView;
 
    public BrickController() {
    	
    }
    public BrickController( int screenWidth, int screenHeight, Color brickColor, int brickDurability) {
        int rows = screenHeight/20;
        int cols = screenWidth/80;
        bricks = new Brick[rows][cols];

        brickView = new BrickView();
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
            	int x = bricks[row][col].getX();
            	int y = bricks[row][col].getY();
            	boolean visible = bricks[row][col].getVisibility();
            	int durability = bricks[row][col].getDurability();
            	
                if (visible) {
                    brickView.drawBrick(g, x, y, getWidth(), getHeight(), durability);
                }
            }

        }
    }
}
