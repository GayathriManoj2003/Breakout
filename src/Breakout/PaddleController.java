package Breakout;

import java.awt.event.*;
import java.awt.Graphics2D;

public class PaddleController extends KeyAdapter {
    PaddleModel model;
    PaddleView view;

    public PaddleController(){
        this.model = new PaddleModel();
        this.view = new PaddleView();
    }
    public PaddleController(int width, int height, int paddle_width, int paddle_height) {
        this.model = new PaddleModel(width, height, paddle_width, paddle_height);
        this.view = new PaddleView();
    }

    public int getPaddleX() {
        return model.getPaddleX();
    }

    public int getPaddleY() {
        return model.getPaddleY();
    }

    public int getPaddleW() {
        return model.getPaddleW();
    }

    public int getPaddleH() {
        return model.getPaddleH();
    }
    public void moveLeft() {
        model.moveLeft();
    }

    public void moveRight() {
        model.moveRight();
    }

    public void drawPaddle(Graphics2D g2d) {
		view.drawPaddle( g2d, getPaddleX(), getPaddleY(), getPaddleW(), getPaddleH());
	}
}
