package main;

import java.awt.Rectangle;

import main.controllers.BallController;

public class CollisionHandler {
    public static boolean checkBallPaddleCollision(int ballX, int ballY, int ballWidth, int ballHeight, int paddleX, int paddleY, int paddleWidth, int paddleHeight) {
        Rectangle ballRect = new Rectangle(ballX, ballY, ballWidth, ballHeight);
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
        return ballRect.intersects(paddleRect);
    }
	public static int handleBallWallCollision( BallController ballController) {
		if( ballController.getBallX() < 0 || (ballController.getBallX() + ballController.getBallRadius() )> 800 ) {
			ballController.reverseBallDirX();
		}
		
		if( (ballController.getBallY() + ballController.getBallRadius()) > 700 ) {
			return 1;
		}

		if( ballController.getBallY() <= 0 ) {
			ballController.reverseBallDirY();
		}
		return 0;
	}
	public static boolean checkBallBrickCollision(int ballX, int ballY, int ballWidth, int ballHeight, int brickX, int brickY, int brickWidth, int brickHeight) {
        Rectangle ballRect = new Rectangle(ballX, ballY, ballWidth, ballHeight);
        Rectangle brickRect = new Rectangle(brickX, brickY, brickWidth, brickHeight);
        return ballRect.intersects(brickRect);
    }
}
