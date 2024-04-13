package BrickGame;
import javax.swing.*;
import java.awt.*;

public class BrickController extends JPanel {
    private Brick[][] bricks;

    public BrickController() {
        // Initialize a 3x7 grid of bricks
        int rows = 3;
        int cols = 5;
        bricks = new Brick[rows][cols];
        
        // Create the bricks with positions and colors
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int x = col * 100 + 80;
                int y = row * 30 + 50;
                Color color = Color.YELLOW; // You can customize the color here
                
                // Create a new brick and add it to the array
                bricks[row][col] = new Brick(x, y, 90, 20, color);
            }
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // Draw each brick
        for (int row = 0; row < bricks.length; row++) {
            for (int col = 0; col < bricks[row].length; col++) {
                bricks[row][col].draw(g);
            }
        }
    }
}
