package Breakout;

import java.awt.Color;
import java.awt.Graphics2D;

public class BallController {
	Ball ball;
	BallView ballView;
	BallController() {
		this.ball = new Ball();
		this.ballView = new BallView();
	}
	BallController( int posX, int posY, int velX, int velY, Color ballColor) {
		this.ball = new Ball( posX, posY, velX, velY);
		this.ball.setColor(ballColor);
		this.ballView = new BallView();
	}
	int getBallX() {
		return ball.getPosX();
	}
	int getBallY() {
		return ball.getPosY();
	}
	int getBallRadius() {
		return ball.getRadius();
	}
	Color getBallColor() {
		return ball.getColor();
	}
	void moveBall() {
		ball.setPosX( getBallX() + ball.getVelX());
		ball.setPosY( getBallY() + ball.getVelY());
	}
	void reverseBallDirX() {
		ball.setVelX(ball.getVelX() * -1);
	}
	void reverseBallDirY() {
		ball.setVelY(ball.getVelY() * -1);
	}
	void setVelX( int velX) {
		ball.setVelX(velX);
	}
	void setVelY( int velY) {
		ball.setVelX(velY);
	}
	void drawBall(Graphics2D g2d) {
		ballView.drawBall( g2d, getBallX(), getBallY(), getBallRadius(), getBallColor());
	}
}
