package main.models;

import java.awt.Color;

public class PaddleModel {
    private static PaddleModel instance;

    private int WIDTH;
    private int HEIGHT;
    private int PADDLE_WIDTH;
    private int PADDLE_HEIGHT;
    private int paddleX;
    private Color color;

    private PaddleModel(int width, int height, int paddle_width, int paddle_height) {
        this.WIDTH = width;
        this.HEIGHT = height;
        this.PADDLE_WIDTH = paddle_width;
        this.PADDLE_HEIGHT = paddle_height;
        paddleX = width / 2 - paddle_width / 2;
    }

    public static PaddleModel getInstance(int width, int height, int paddle_width, int paddle_height) {
        if (instance == null) {
            instance = new PaddleModel(width, height, paddle_width, paddle_height);
        }
        instance.setPaddleX(width / 2 - paddle_width / 2);
        return instance;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public int getPaddleY() {
        return HEIGHT - PADDLE_HEIGHT;
    }

    public int getPaddleW() {
        return PADDLE_WIDTH;
    }

    public int getPaddleH() {
        return PADDLE_HEIGHT;
    }

    public void moveLeft() {
        if (paddleX > 0) {
            paddleX -= 60;
        }
    }

    public static PaddleModel getInstance() {
		return instance;
	}

	public static void setInstance(PaddleModel instance) {
		PaddleModel.instance = instance;
	}

	public int getWIDTH() {
		return WIDTH;
	}

	public void setWIDTH(int wIDTH) {
		WIDTH = wIDTH;
	}

	public int getHEIGHT() {
		return HEIGHT;
	}

	public void setHEIGHT(int hEIGHT) {
		HEIGHT = hEIGHT;
	}

	public int getPADDLE_WIDTH() {
		return PADDLE_WIDTH;
	}

	public void setPADDLE_WIDTH(int pADDLE_WIDTH) {
		PADDLE_WIDTH = pADDLE_WIDTH;
	}

	public int getPADDLE_HEIGHT() {
		return PADDLE_HEIGHT;
	}

	public void setPADDLE_HEIGHT(int pADDLE_HEIGHT) {
		PADDLE_HEIGHT = pADDLE_HEIGHT;
	}

	public void setPaddleX(int paddleX) {
		this.paddleX = paddleX;
	}

	public void moveRight() {
        if (paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 60;
        }
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}