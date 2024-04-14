package Breakout.controller;

import java.awt.Rectangle;

import Breakout.model.Ball;
import Breakout.model.Paddle;

public class CollisionController {
    public boolean checkCollision(Ball ball, Paddle paddle) {
        Rectangle ballRect = ball.getBounds();
        Rectangle paddleRect = paddle.getBounds();
        return ballRect.intersects(paddleRect);
    }
}
