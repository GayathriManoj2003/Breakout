// BrickController.java
package Breakout;

import java.awt.*;

public class BrickController {
    private Brick[][] bricks;

    public BrickController() {
        int rows = 3;
        int cols = 5;
        bricks = new Brick[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * 10 + 40;
                int y = row * 30 + 50;
                Color color = Color.YELLOW;
                bricks[row][col] = new Brick(x, y, 90, 20, color);
            }
        }
    }

    public void drawBricks(Graphics2D g) {
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                bricks[row][col].draw(g);
            }
        }
    }
}
