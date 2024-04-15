public class PaddleModel {
    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public static final int PADDLE_WIDTH = 100;
    public static final int PADDLE_HEIGHT = 10;
    private int paddleX;

    public PaddleModel() {
        paddleX = WIDTH / 2 - PADDLE_WIDTH / 2;
    }

    public int getPaddleX() {
        return paddleX;
    }

    public void moveLeft() {
        if (paddleX > 0) {
            paddleX -= 20;
        }
    }

    public void moveRight() {
        if (paddleX < WIDTH - PADDLE_WIDTH) {
            paddleX += 20;
        }
    }
}
