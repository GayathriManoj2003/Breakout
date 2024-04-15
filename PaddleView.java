import javax.swing.*;
import java.awt.*;

public class PaddleView extends JPanel {
    private PaddleModel model;

    public PaddleView(PaddleModel model) {
        this.model = model;
        setPreferredSize(new Dimension(PaddleModel.WIDTH, PaddleModel.HEIGHT));
        setBackground(Color.BLACK);
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawPaddle(g);
    }

    private void drawPaddle(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(model.getPaddleX(), PaddleModel.HEIGHT - PaddleModel.PADDLE_HEIGHT, PaddleModel.PADDLE_WIDTH, PaddleModel.PADDLE_HEIGHT);
    }
}
