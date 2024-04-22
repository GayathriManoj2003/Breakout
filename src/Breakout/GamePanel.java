package Breakout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;

public abstract class GamePanel extends JPanel {
    private GameState currentState;
    private PlayingState playingState;
    private PausedState pausedState;
    private QuitState	quitState;
    private String message;

    public GamePanel() {
        this.playingState = new PlayingState();
        this.pausedState = new PausedState();
        this.quitState = new QuitState();

        // Register Key Bindings
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pause");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "quit");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "resume");

        actionMap.put("pause", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(pausedState);
            }
        });

        actionMap.put("quit", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(quitState);
            }
        });

        actionMap.put("resume", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(playingState);
            }
        });

        currentState = pausedState;
        updateGameState();
    }

    public void setCurrentState(GameState state) {
        currentState = state;
        updateGameState();
    }

    public void setPlayingState() {
        this.setCurrentState(playingState);
    }
    private void updateGameState() {
        if (currentState instanceof PlayingState) {
            setMessage("Game is playing. Press 'P' to pause or 'Q' to quit.");
        } else if (currentState instanceof PausedState) {
            setMessage("Game is paused. Press ENTER to resume.");
        } else if (currentState instanceof QuitState) {
            setMessage("Quit game");
        }
    }

    public void setMessage(String message) {
        this.message = message;
        repaint(); // Repaint the panel to update the message
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Playing paint
        
        g.drawString(message, 50, 50);
    }
}
