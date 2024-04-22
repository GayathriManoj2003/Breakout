package Breakout;

import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class PlayingState implements GameState {
	private String message;
	private BallController ballController;
	private PaddleController paddleController;
	// Create objects of Controllers within constructor of Playing state.
	// Also create collision handler object
	
	PlayingState() {
		this.ballController = new BallController( 0, 0, 10, 10);
		this.paddleController = new PaddleController(60, 40, 100,5);

		// // Register Key Bindings
        // InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        // ActionMap actionMap = getActionMap();
		// inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftPressed");
        // inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightPressed");

		// actionMap.put("leftPressed", new AbstractAction() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         paddleController.moveLeft();
        //     }
        // });

        // actionMap.put("rightPressed", new AbstractAction() {
        //     @Override
        //     public void actionPerformed(ActionEvent e) {
        //         paddleController.moveRight();
        //     }
        // });
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
