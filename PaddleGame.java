import javax.swing.*;

public class PaddleGame {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                PaddleModel model = new PaddleModel();
                PaddleView view = new PaddleView(model);
                JFrame frame = new JFrame("Paddle Game");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.getContentPane().add(view);
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
                view.setFocusable(true);
                view.addKeyListener(new PaddleController(model, view));
            }
        });
    }
}
