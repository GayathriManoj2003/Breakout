package Breakout;

import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

class PlayingState implements GameState {
	private String message;
	private BallController ballController;
	private PaddleController paddleController;
	private BrickController brickController;
	// Create objects of Controllers within constructor of Playing state.
	// Also create collision handler object
	
	PlayingState( ActionMap actionMap ) {
		this.ballController = new BallController( 0, 0, 10, 10);
		this.paddleController = new PaddleController(800, 600, 100, 20);
		this.brickController = new BrickController(800, 240);

		// // Register Key Bindings

		 actionMap.put("leftPressed", new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 paddleController.moveLeft();
                 System.out.println(paddleController.getPaddleX());
//                 System.out.println("Here Left");
             }
         });

         actionMap.put("rightPressed", new AbstractAction() {
             @Override
             public void actionPerformed(ActionEvent e) {
                 paddleController.moveRight();
                 System.out.println(paddleController.getPaddleX());
//                 System.out.println("Here Right");
             }
         });
	}	
	
	// PlayingState( int ballX, int ballY, int ballVelX, int ballVelY) {
	// 	this.ballController = new BallController(ballX, ballY, ballVelX, ballVelY);
	// }

	PlayingState(int width, int height, int paddle_width, int paddle_height){
		this.paddleController = new PaddleController(width, height, paddle_width, paddle_height);
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
		
		paddleController.drawPaddle(g2d);
		ballController.drawBall(g2d);
		brickController.drawBricks(g2d);
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
