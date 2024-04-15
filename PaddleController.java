import java.awt.event.*;

public class PaddleController extends KeyAdapter {
    private PaddleModel model;
    private PaddleView view;

    public PaddleController(PaddleModel model, PaddleView view) {
        this.model = model;
        this.view = view;
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        if (key == KeyEvent.VK_LEFT) {
            model.moveLeft();
        }
        if (key == KeyEvent.VK_RIGHT) {
            model.moveRight();
        }
        view.repaint();
    }
}
