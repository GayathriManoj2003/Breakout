package Breakout;

import java.awt.Graphics2D;

class PlayingState implements GameState {
    private String message;
    private BallController ballController;
    private BrickController brickController; // Add BrickController

    PlayingState() {
        this.ballController = new BallController(0, 0, 10, 10);
        this.brickController = new BrickController(); // Initialize BrickController
    }

    PlayingState(int ballX, int ballY, int ballVelX, int ballVelY) {
        this.ballController = new BallController(ballX, ballY, ballVelX, ballVelY);
        this.brickController = new BrickController(); // Initialize BrickController
    }

    public void setBallVelocity(int velX, int velY) {
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
        // Draw Ball
        ballController.drawBall(g2d);
        
        // Draw Bricks
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
