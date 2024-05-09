package main.gamepanels;
import javax.swing.*;

import main.ConnectionManager;
import main.gamestates.PausedState;
import main.gamestates.PlayingState;
import main.gamestates.QuitState;
import main.gamestates.ShowScoreState;
import main.interfaces.GameState;
import main.models.Player;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.sql.Timestamp;  
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.time.Instant;
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
    private ShowScoreState scoreState;
    private Timestamp startGameTimestamp;
    private Timestamp endGameTimestamp;
    private int totalPausedTime;
    private Player player;
    private Timer timer;
    private JButton b1;
    private int score;
    private boolean isPaused;
    private long startPauseMilliseconds;
    
    public GamePanel(int ballVelocityX, int ballVelocityY, int numberOfBrickRows, int brickDurability, Color ballColor, Color brickColor) {
        this.pausedState = new PausedState();
        this.quitState = new QuitState();
        this.scoreState = new ShowScoreState();
        this.totalPausedTime = 0;
        this.isPaused = false;

        // Register Key Bindings
        InputMap inputMap = getInputMap(WHEN_IN_FOCUSED_WINDOW);
        ActionMap actionMap = getActionMap();
        this.playingState = new PlayingState(actionMap, ballVelocityX, ballVelocityY, numberOfBrickRows, ballColor, brickColor, brickDurability);
        this.startGameTimestamp = Timestamp.from(Instant.now());

        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_P, 0), "pause");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_Q, 0), "quit");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "resume");

		inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "leftPressed");
        inputMap.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "rightPressed");

        actionMap.put("pause", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			@Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(pausedState);
            }
        });

        actionMap.put("quit", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = -2847179244756254627L;

			@Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(quitState);
            }
        });

        actionMap.put("resume", new AbstractAction() {
            /**
			 * 
			 */
			private static final long serialVersionUID = 349860883800250007L;

			@Override
            public void actionPerformed(ActionEvent e) {
                setCurrentState(playingState);
            }
        });

        timer = new Timer( 20, new GameCycle());
        timer.start();

        currentState = pausedState;
        updateGameState();
        b1 = new JButton();
        
    }

    public void setCurrentState(GameState state) {
        currentState = state;
        if( state instanceof PausedState ) {
        	if( this.isPaused == false ) {
        		this.isPaused = true;
        		this.startPauseMilliseconds = System.currentTimeMillis();
        	}
        } else {
        	if( this.isPaused ) {
        		this.isPaused = false;
        		this.totalPausedTime += (System.currentTimeMillis() - startPauseMilliseconds);
        		this.startPauseMilliseconds = 0;
        	}
        }
        updateGameState();
        repaint();
    }

    public void setPlayingState() {
        this.setCurrentState(playingState);
    }
    private void updateGameState() {
        if (currentState instanceof PlayingState) {
        	currentState.setMessage("Score: " + playingState.score);
            timer.start();
        } else if (currentState instanceof PausedState) {
            currentState.setMessage("Game is paused. Press ENTER to resume.");
            timer.stop();
        } else if (currentState instanceof QuitState) {
            currentState.setMessage("Quit game");
            timer.stop();
            b1.doClick();
        }	else if (currentState instanceof ShowScoreState) {
            currentState.setMessage("Game Over, Your Score is: " + score);
            JButton b2 = new JButton("Exit");
            b2.setBounds(340, 360, 100, 40);
            add(b2);
        	b2.addActionListener( event -> {
        		b1.doClick();
        	});
            timer.stop();
        }
    }
    public void setPlayer( Player player ) {
    	System.out.println(player.getUsername() + " in Play Game.");
    	this.player = player;
    }
    private class GameCycle implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            int ret = playingState.timeStep();
            if( ret == 1 ) {
            	// gameOver
            	timer.stop();
            	score = playingState.score;
            	System.out.println("Game Over: Ball Out of Scope, Score = " + score);
            	endGameTimestamp = Timestamp.from(Instant.now());
            	endGameTimestamp.setTime(endGameTimestamp.getTime() - totalPausedTime);
            	insertScoreToDatabase();
            	setCurrentState(scoreState);
            }
            repaint();
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        var g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHint(RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);
        // Playing paint
        if( currentState instanceof PlayingState ) {
        	

            playingState.drawObjects(g2d);
            Font font = new Font("Impact", Font.PLAIN, 20);
            g.setFont(font);

        	currentState.setMessage("Score: " + playingState.score);
            g.drawString(currentState.getMessage(), 360, 650);
//        	System.out.println( "Playing State");
        } else {
        	playingState.drawObjects(g2d);
        	Font font = new Font("Impact", Font.PLAIN, 25);
            g.setFont(font);
        	g.setColor(Color.BLACK);

            g.drawString(currentState.getMessage(), 240, 320);
//            System.out.println( "Message is: "+ currentState.getMessage());
        }

        Toolkit.getDefaultToolkit().sync();
    }
    public void setMenuAction(ActionListener actionListener) {
		b1.addActionListener(actionListener);
    }
    public void insertScoreToDatabase() {
		String username = player.getUsername();
		String level = player.getLevel();
        
		try {
			String query = "INSERT INTO Score VALUES (?, ?, ?, ?, ?);";
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            
            ps.setString(1, username);
            ps.setString(2, level);
            ps.setInt(3, score);
            ps.setTimestamp(4, this.startGameTimestamp);
            ps.setTimestamp(5, this.endGameTimestamp);
			
			ps.executeUpdate();
		}	catch ( Exception e ) {
			System.out.println("Error: " + e);
		}
    }
}
