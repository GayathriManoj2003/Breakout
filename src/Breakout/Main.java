package Breakout;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
    	BreakoutGameFactory factory = new BreakoutGameFactory();
        JFrame frame = new JFrame("Breakout Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 300);

        // Create panels
        MenuPanel menuPanel = new MenuPanel();

        // Create CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);

        // Add panels to cardPanel
        cardPanel.add(menuPanel, "MenuPanel");
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
        menuPanel.setLogoutAction(e -> System.exit(0));
    }
}
