package Breakout.controller;

import Breakout.model.Ball;

public class BallController {
	Ball ball;
	BallController() {
		this.ball = new Ball();
	}
	BallController( int posX, int posY, int velX, int velY) {
		this.ball = new Ball( posX, posY, velX, velY);
	}
	int getBallX() {
		return ball.getPosX();
	}
	int getBallY() {
		return ball.getPosY();
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
}
