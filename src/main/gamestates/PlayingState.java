package main.gamestates;
import java.awt.Graphics2D;
import javax.swing.*;

import main.CollisionHandler;
import main.controllers.BallController;
import main.controllers.BrickController;
import main.controllers.PaddleController;
import main.interfaces.GameState;
import main.models.Brick;

import java.awt.*;
import java.awt.event.ActionEvent;

public class PlayingState implements GameState {
    private String message;
    private BallController ballController;
    private PaddleController paddleController;
    private BrickController brickController;
    public int score;

    public PlayingState(ActionMap actionMap, int ballVelX, int ballVelY, int numberOfBrickRows, Color ballColor, Color brickColor, int brickDurability) {
        this.ballController = new BallController(400, 500, ballVelX, ballVelY, ballColor);
        this.paddleController = new PaddleController(800, 600, 100, 20);
        int widthBrickRows = numberOfBrickRows*20;
        this.brickController = new BrickController(800, widthBrickRows, brickColor, brickDurability);
        this.score = 0;
  
        actionMap.put("leftPressed", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -5078958172327309776L;

			@Override
            public void actionPerformed(ActionEvent e) {
                paddleController.moveLeft();
            }
        });

        actionMap.put("rightPressed", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 5831734143244893201L;

			@Override
            public void actionPerformed(ActionEvent e) {
                paddleController.moveRight();
            }
        });
    }

    public int timeStep() {
        // Move the ball
        ballController.moveBall();
        
        int ret = CollisionHandler.handleBallWallCollision(ballController);
        
        if (ret == 1)
            return 1;

        // Check for paddle collision
        if (CollisionHandler.checkBallPaddleCollision(ballController.getBallX(), ballController.getBallY(), ballController.getBallRadius(), ballController.getBallRadius(),
                paddleController.getPaddleX(), paddleController.getPaddleY(), paddleController.getPaddleW(), paddleController.getPaddleH())) {
            ballController.reverseBallDirY(); // Reverse ball direction if it hits the paddle
        }

     // Check for brick collision
        int bricks_exist = 0;
        Brick[][] bricks = brickController.getBricks();
        for (int i = 0; i < bricks.length; i++) {
            for (int j = 0; j < bricks[i].length; j++) {
                Brick brick = bricks[i][j];
                if (brick != null && brick.isVisible()) {
                    bricks_exist++;
                    if (CollisionHandler.checkBallBrickCollision(ballController.getBallX(), ballController.getBallY(), ballController.getBallRadius(), ballController.getBallRadius(),
                            brick.getX(), brick.getY(), brickController.getWidth(), brickController.getHeight())) {
                        // Handle collision
                        brick.hit(); // Reduce durability
                        ballController.reverseBallDirY(); // Reverse ball direction (you may adjust this based on your game's logic)
                        score += 5; // Increment score
                        bricks_exist--;
                    }
                }
            }
        }

        
        if( bricks_exist == 0 ) {
        	return 1;
        }

        // Update positions of other game objects (if any)
        return 0;
    }


    public void drawObjects(Graphics2D g2d) {
        paddleController.drawPaddle(g2d);
        ballController.drawBall(g2d);
        brickController.drawBricks(g2d);
    }

    @Override
    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
