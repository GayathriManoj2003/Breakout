package Breakout;
import java.awt.Rectangle;

class CollisionHandler {
    public static boolean checkBallPaddleCollision(int ballX, int ballY, int ballWidth, int ballHeight, int paddleX, int paddleY, int paddleWidth, int paddleHeight) {
        Rectangle ballRect = new Rectangle(ballX, ballY, ballWidth, ballHeight);
        Rectangle paddleRect = new Rectangle(paddleX, paddleY, paddleWidth, paddleHeight);
        return ballRect.intersects(paddleRect);
    }
}
