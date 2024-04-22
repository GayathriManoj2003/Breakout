package Breakout;

public class CollisionHandler {
	public int handleCollision( BallController ballController, PaddleController paddleController, BrickController brickController) {
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
}
