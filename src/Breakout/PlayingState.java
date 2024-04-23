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
    public int score;

    PlayingState(ActionMap actionMap) {
        this.ballController = new BallController(400,500, 5, 10);
        this.paddleController = new PaddleController(800, 600, 100, 20);
        this.brickController = new BrickController(800, 240);
        this.score = 0;
  
        actionMap.put("leftPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paddleController.moveLeft();
            }
        });

        actionMap.put("rightPressed", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                paddleController.moveRight();
            }
        });
    }

    public void setBallVelocity(int velX, int velY) {
        ballController.setVelX(velX);
        ballController.setVelY(velY);
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
                            brick.getX(), brick.getY(), brick.getWidth(), brick.getHeight())) {
                        // Handle collision
                        brick.setVisible(false); // Remove brick
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
