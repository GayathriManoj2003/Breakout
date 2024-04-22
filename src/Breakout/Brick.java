// Brick.java
package Breakout;

import java.awt.*;

public class Brick {
    private int x, y;
    private int width, height;
    private Color color;
    private BrickView brickView;

    public Brick(int x, int y, int width, int height, Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.brickView = new BrickView();
    }

    public void draw(Graphics2D g) {
        brickView.drawBrick(g, x, y, width, height, color);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Color getColor() {
        return color;
    }
}
