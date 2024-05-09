// BrickFlyweight.java
package main.models;

import java.awt.Color;

public class BrickFlyweight {
    private Color color;
    private int width;
    private int height;

    public BrickFlyweight(Color color, int width, int height) {
        this.color = color;
        this.width = width;
        this.height = height;
    }

    public void setColor(Color color) {
		this.color = color;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public Color getColor() {
        return color;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
}