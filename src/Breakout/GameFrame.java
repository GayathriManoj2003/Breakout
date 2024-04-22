package Breakout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameFrame extends JFrame implements KeyListener {
    private GameState currentState;
    private GameStatePanel gameStatePanel;

    public GameFrame() {
        this.setTitle("Game State Example");
        this.setSize(300, 200);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        gameStatePanel = new GameStatePanel();
        this.add(gameStatePanel);

        this.addKeyListener(this);
        this.setFocusable(true);
        this.requestFocusInWindow();

        currentState = new PausedState();
        updateGameState();
    }

    public void setCurrentState(GameState state) {
        currentState = state;
        updateGameState();
    }

    private void updateGameState() {
        if (currentState instanceof PlayingState) {
            gameStatePanel.setMessage("Game is playing. Press 'P' to pause or 'Q' to quit.");
        } else if (currentState instanceof PausedState) {
            gameStatePanel.setMessage("Game is paused. Press ENTER to resume.");
        } else if (currentState instanceof QuitState) {
            gameStatePanel.setMessage("Quit game");
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        currentState.handleKey(this, e);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            GameFrame frame = new GameFrame();
            frame.setVisible(true);
        });
    }
}
