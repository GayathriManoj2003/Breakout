package Breakout;

import java.awt.Graphics2D;

class PlayingState implements GameState {
	private String message;
	private BallController ballController;
	
	// Create objects of Controllers within constructor of Playing state.
	// Also create collision handler object
	
	PlayingState() {
		this.ballController = new BallController( 0, 0, 10, 10);
	}	
	
	PlayingState( int ballX, int ballY, int ballVelX, int ballVelY) {
		this.ballController = new BallController(ballX, ballY, ballVelX, ballVelY);
	}	
	
	public void setBallVelocity( int velX, int velY) {
		ballController.setVelX(velX);
		ballController.setVelY(velY);
	}
	
	public void timeStep() {
		
		ballController.moveBall();
		
		// Move Paddle Here
		
		// Check Ball Boundaries within CollionHandler
		// Detect Collision through CollionHandler over Here
		
	}

	public void drawObjects(Graphics2D g2d) {
		
		// Draw Other objects Also by calling functions
		// Can Split into MVC by placing these functions inside View Classes for 
		// each object and using the View Class inside Controller of Object
		
		ballController.drawBall(g2d);
    }
	
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message = "" ;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
}
