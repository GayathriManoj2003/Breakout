package main.controllers;

import java.awt.Color;
import java.awt.Graphics2D;

import main.models.Ball;
import main.views.BallView;

public class BallController {
	Ball ball;
	BallView ballView;
	BallController() {
		this.ball = new Ball();
		this.ballView = new BallView();
	}
	public BallController( int posX, int posY, int velX, int velY, Color ballColor) {
		this.ball = new Ball( posX, posY, velX, velY);
		this.ball.setColor(ballColor);
		this.ballView = new BallView();
	}
	public int getBallX() {
		return ball.getPosX();
	}
	public int getBallY() {
		return ball.getPosY();
	}
	public int getBallRadius() {
		return ball.getRadius();
	}
	Color getBallColor() {
		return ball.getColor();
	}
	public void moveBall() {
		ball.setPosX( getBallX() + ball.getVelX());
		ball.setPosY( getBallY() + ball.getVelY());
	}
	public void reverseBallDirX() {
		ball.setVelX(ball.getVelX() * -1);
	}
	public void reverseBallDirY() {
		ball.setVelY(ball.getVelY() * -1);
	}
	void setVelX( int velX) {
		ball.setVelX(velX);
	}
	void setVelY( int velY) {
		ball.setVelX(velY);
	}
	public void drawBall(Graphics2D g2d) {
		ballView.drawBall( g2d, getBallX(), getBallY(), getBallRadius(), getBallColor());
	}
}
