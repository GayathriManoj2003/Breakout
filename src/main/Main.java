package main;

import javax.swing.*;

import main.gamepanels.GamePanel;
import main.models.Player;
import main.views.GameHistory;
import main.views.Leaderboard;
import main.views.LevelPanel;
import main.views.Login;
import main.views.MenuPanel;
import main.views.SignUp;

import java.awt.*;

public class Main {
	private static Player currentPlayer;
    public static void main(String[] args) {
    	BreakoutGameFactory factory = new BreakoutGameFactory();
        JFrame frame = new JFrame("Breakout Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        // Create panels
        MenuPanel menuPanel = new MenuPanel();
        Login login = new Login();
        SignUp signup = new SignUp();

        // Create CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Add panels to cardPanel
        cardPanel.add(login, "Login");
        cardPanel.add(signup, "SignUp");
        cardPanel.add(menuPanel, "MenuPanel");
        

        // Add cardPanel to frame
        frame.add(cardPanel);

        // Display the frame
        frame.setVisible(true);

        menuPanel.setPlayGameAction(e -> {
            LevelPanel levelPanel = new LevelPanel();
            levelPanel.setStartGameAction(event -> {
                String command = event.getActionCommand();
                currentPlayer.setLevel(command);
                GamePanel gameLevelPanel = factory.getGameInstance(command);
                gameLevelPanel.setPlayer(currentPlayer);
                gameLevelPanel.setMenuAction(ev -> {
	            	cardLayout.show(cardPanel, "MenuPanel");
	            });
                System.out.println("New game of type: " + command);

                cardPanel.add(gameLevelPanel, "GamePanel");
                cardLayout.show(cardPanel, "GamePanel");
            });

            levelPanel.setBackAction(event -> {
            	cardLayout.show(cardPanel, "MenuPanel");
            });

            levelPanel.setLogoutAction(event -> {
            	System.out.println("Current Player: " + currentPlayer.getUsername() + " Logging Out.");
            	currentPlayer = null;
            	cardLayout.show(cardPanel, "Login");
            });

            cardPanel.add(levelPanel, "LevelPanel");
            cardLayout.show(cardPanel, "LevelPanel");
        });
        
        
 
        menuPanel.setLogoutAction(event -> {
        	System.out.println("Current Player: " + currentPlayer.getUsername() + " Logging Out.");
        	currentPlayer = null;
        	cardLayout.show(cardPanel, "Login");
        });

        menuPanel.setLeaderboardAction( e -> {
        	Leaderboard leaderboard = new Leaderboard();
            cardPanel.add(leaderboard, "Leaderboard");

            leaderboard.setBackAction(event -> {
            	cardLayout.show(cardPanel, "MenuPanel");
            });
            
            leaderboard.setLogoutAction(event -> {
            	System.out.println("Current Player: " + currentPlayer.getUsername() + " Logging Out.");
            	currentPlayer = null;
            	cardLayout.show(cardPanel, "Login");
            });
            cardLayout.show(cardPanel, "Leaderboard");
        });
        
        menuPanel.setMyGamesAction( e -> {
        	GameHistory gameHistory = new GameHistory();
        	gameHistory.setUserName(currentPlayer.getUsername());
        	
            cardPanel.add(gameHistory, "GameHistory");

            gameHistory.setBackAction(event -> {
            	cardLayout.show(cardPanel, "MenuPanel");
            });
            
            gameHistory.setLogoutAction(event -> {
            	System.out.println("Current Player: " + currentPlayer.getUsername() + " Logging Out.");
            	currentPlayer = null;
            	cardLayout.show(cardPanel, "Login");
            });

            cardLayout.show(cardPanel, "GameHistory");
        });

        login.setSignUpAction(e -> {
            cardLayout.show(cardPanel, "SignUp");
        });

        login.setLoginAction(e -> {
        	Player player = login.verifyPlayer();
        	if( player != null ) {
        		currentPlayer = player;
        	    System.out.println("Current Player: " + currentPlayer.getUsername() + " Logged In.");
        		menuPanel.setUsername(currentPlayer.getUsername());
        		cardLayout.show(cardPanel, "MenuPanel");
        	}
        });
        signup.setGoToLoginAction(e -> {
            cardLayout.show(cardPanel, "Login");
        });
        signup.setSubmitAction(e -> {
        	int res = signup.submitDataToDatabase();
        	if( res == 0 ) {
        		cardLayout.show(cardPanel, "Login");
        	}
        });
    }
}
