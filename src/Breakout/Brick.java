package Breakout;

import java.awt.*;

public class Brick {
    private int x, y;
    private int width, height;
    private Color color;
    private boolean visible;
    private int durability; // New attribute
    private BrickView brickView;

    public Brick(int x, int y, int width, int height, Color color, int durability) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
        this.visible = true;
        this.durability = durability; // Initialize durability
        this.brickView = new BrickView();
    }

    public void draw(Graphics2D g) {
        if (visible) {
            brickView.drawBrick(g, x, y, width, height, durability);
        }
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
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }

    public void setColor(Color color) {
        this.color = color;
    }
    
    public int getDurability() {
        return durability;
    }

    public void hit() {
        durability--; // Decrement durability when hit
        if (durability <= 0) {
            visible = false; // Set brick to not visible when durability reaches 0
        }
    }
}
