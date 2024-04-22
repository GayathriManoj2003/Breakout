package Breakout;

import java.awt.Color;

public class PaddleModel {
    public int WIDTH;
    public int HEIGHT;
    public int PADDLE_WIDTH;
    public int PADDLE_HEIGHT;
    public int paddleX;
    public Color color;

    PaddleModel(){}

    public PaddleModel(int width, int height, int paddle_width, int paddle_height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.PADDLE_WIDTH = paddle_width;
        this.PADDLE_HEIGHT = paddle_height;
        paddleX = width / 2 - paddle_width / 2;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY(){
        return HEIGHT - PADDLE_HEIGHT;
    }

    public int getPaddleW(){
        return WIDTH;
    }

    public int getPaddleH(){
        return HEIGHT;
    }

    public void moveLeft() {
        if (paddleX > 0) {
            paddleX -= 20;
        }
    }

    public void moveRight() {
        if (paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 20;
        }
    }

    public Color getColor() {
		return color;
	}
	public void setColor(Color color) {
		this.color = color;
	}
}
