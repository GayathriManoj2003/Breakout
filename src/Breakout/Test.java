package Breakout;

import javax.swing.JFrame;

//public class Test {
//	public static void main(String[] args) {
//        JFrame frame = new JFrame("Breakout Game");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(800, 600);
//
//        GamePanel gamePanel = new EasyGamePanel();
//
//        frame.add(gamePanel); // Add the GamePanel to the JFrame
//        frame.addKeyListener(gamePanel);
//        frame.setVisible(true);
//    }
//}

//package Breakout;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Test {
    public static void main(String[] args) {
    	BreakoutGameFactory factory = new BreakoutGameFactory();
        JFrame frame = new JFrame("Breakout Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 700);

        // Create CardLayout
        CardLayout cardLayout = new CardLayout();
        JPanel cardPanel = new JPanel(cardLayout);
   
        // Add cardPanel to frame
        frame.add(cardPanel);

        // Display the frame
        frame.setVisible(true);

    	String command = "Easy";
        GamePanel gameLevelPanel = factory.getGameInstance(command);
        frame.addKeyListener(gameLevelPanel);

        cardPanel.add(gameLevelPanel, "GamePanel");
        cardLayout.show(cardPanel, "GamePanel");
 
    }
}
