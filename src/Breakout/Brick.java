package Breakout;

import java.awt.*;

public class Brick {
    private int x, y;
    private boolean visible;
    int durability;
    private BrickFlyweight flyweight;
    private BrickView brickView;

    public Brick(int x, int y, int durability, BrickFlyweight flyweight) {
    	this.x = x;
        this.y = y;
        this.flyweight = flyweight;
        this.durability = durability; 
        this.visible = true;
        this.brickView = new BrickView();
    }

    public void draw(Graphics2D g) {
        if (visible) {
            brickView.drawBrick(g, x, y, flyweight, durability);
        }
    }


    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return flyweight.getWidth();
    }

    public int getHeight() {
        return flyweight.getHeight();
    }

    public Color getColor() {
        return flyweight.getColor();
    }
    
    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    public void setColor(Color color) {
        this.flyweight.setColor(color);
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
