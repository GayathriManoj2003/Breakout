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

    PlayingState(ActionMap actionMap) {
        this.ballController = new BallController(0, 0, 10, 10);
        this.paddleController = new PaddleController(800, 600, 100, 20);
        this.brickController = new BrickController(800, 240);

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

    public void timeStep() {
        // Move the ball
        ballController.moveBall();
        
        // Check for paddle collision
        if (CollisionHandler.checkBallPaddleCollision(ballController.getBallX(), ballController.getBallY(), ballController.getBallRadius(), ballController.getBallRadius(),
                paddleController.getPaddleX(), paddleController.getPaddleY(), paddleController.getPaddleW(), paddleController.getPaddleH())) {
            ballController.reverseBallDirY(); // Reverse ball direction if it hits the paddle
        }

        // Check for brick collision
        // Logic for brick collision with the ball goes here

        // Update positions of other game objects (if any)

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
