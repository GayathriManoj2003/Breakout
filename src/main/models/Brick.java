package main.models;

public class Brick {
    private int x, y;
    private boolean visible;
    private int durability;

    public Brick(int x, int y, int durability) {
        this.x = x;
        this.y = y;
        this.visible = true;
        this.durability = durability; // Initialize durability
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
    
    public boolean getVisibility() {
    	return visible;
    }

    public void hit() {
        durability--; // Decrement durability when hit
        if (durability <= 0) {
            visible = false; // Set brick to not visible when durability reaches 0
        }
    }
}
