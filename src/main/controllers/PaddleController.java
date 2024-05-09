package main.controllers;

import java.awt.Graphics2D;
import java.awt.event.*;

import main.models.PaddleModel;
import main.views.PaddleView;

public class PaddleController extends KeyAdapter {
    private PaddleModel model;
    private PaddleView view;

    public PaddleController(int width, int height, int paddle_width, int paddle_height) {
        this.model = PaddleModel.getInstance(width, height, paddle_width, paddle_height); // Get the singleton instance with initialization
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
        view.drawPaddle(g2d, getPaddleX(), getPaddleY(), getPaddleW(), getPaddleH());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if (keyCode == KeyEvent.VK_LEFT) {
            moveLeft();
        } else if (keyCode == KeyEvent.VK_RIGHT) {
            moveRight();
        }
    }
}