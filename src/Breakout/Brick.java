package Breakout;

import java.awt.*;

public class Brick {
    private int x, y;
    private boolean visible;
    private int durability; // New attribute
    private BrickView brickView;

    public Brick(int x, int y, int durability) {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.durability = durability; // Initialize durability
        this.brickView = new BrickView();
    }

    public void draw(Graphics2D g, int width, int height) {
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
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
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
