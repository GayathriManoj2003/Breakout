package Breakout;

import javax.swing.*;
import java.awt.*;

public class Main {
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
        cardPanel.add(menuPanel, "MenuPanel");
        cardPanel.add(signup, "SignUp");

        // Add cardPanel to frame
        frame.add(cardPanel);

        // Display the frame
        frame.setVisible(true);

        // Handle switching between panels
        menuPanel.setStartGameAction(e -> {
            String command = e.getActionCommand();
            GamePanel gameLevelPanel = factory.getGameInstance(command);

            cardPanel.add(gameLevelPanel, "GamePanel");

            cardLayout.show(cardPanel, "GamePanel");
        });
        login.setSignUpAction(e -> {
            cardLayout.show(cardPanel, "SignUp");
        });
        login.setLoginAction(e -> {
            cardLayout.show(cardPanel, "MenuPanel");
        });
        signup.setGoToLoginAction(e -> {
            cardLayout.show(cardPanel, "Login");
        });
        menuPanel.setLogoutAction(e -> cardLayout.show(cardPanel, "Login"));
    }
}
