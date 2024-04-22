package Breakout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class GamePanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GameState currentState;
    private PlayingState playingState;
    private PausedState pausedState;
    private QuitState	quitState;
    private Timer timer;
    
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

        timer = new Timer( 20, new GameCycle());
        timer.start();

        currentState = pausedState;
        updateGameState();
    }

    public void setCurrentState(GameState state) {
        currentState = state;
        updateGameState();
        repaint();
    }

    public void setPlayingState() {
        this.setCurrentState(playingState);
    }
    private void updateGameState() {
        if (currentState instanceof PlayingState) {
            currentState.setMessage("Game is playing. Press 'P' to pause or 'Q' to quit.");
        } else if (currentState instanceof PausedState) {
            currentState.setMessage("Game is paused. Press ENTER to resume.");
        } else if (currentState instanceof QuitState) {
            currentState.setMessage("Quit game");
        }
    }
    
    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            playingState.timeStep();
            repaint();
        }

    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        // Playing paint
        if( currentState instanceof PlayingState ) {
        	var g2d = (Graphics2D) g;

            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                    RenderingHints.VALUE_ANTIALIAS_ON);

            g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                    RenderingHints.VALUE_RENDER_QUALITY);

            playingState.drawObjects(g2d);

            Toolkit.getDefaultToolkit().sync();
        	System.out.println( "Playing State");
        } else {
            g.drawString(currentState.getMessage(), 50, 50);
            System.out.println( "Message is: "+ currentState.getMessage());
        }
    }
}
