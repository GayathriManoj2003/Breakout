package main.views;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;

public class LevelPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton easyButton;
	public JButton mediumButton;
	public JButton hardButton;
	private JButton logoutButton;
	private JButton btnBack;
    public LevelPanel() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        easyButton = new JButton("Easy");
        easyButton.setForeground(new Color(0, 0, 0));
        easyButton.setBounds(304, 278, 183, 50);
        easyButton.setFont(new Font("Impact", Font.PLAIN, 24));
        easyButton.setActionCommand("Easy");
        easyButton.setBackground(Color.GREEN);
        add(easyButton);
        
        mediumButton = new JButton("Medium");
        mediumButton.setForeground(new Color(0, 0, 0));
        mediumButton.setBounds(304, 365, 183, 50);
        mediumButton.setFont(new Font("Impact", Font.PLAIN, 24));
        mediumButton.setActionCommand("Medium");
        mediumButton.setBackground(Color.ORANGE);
        add(mediumButton);
        
        hardButton = new JButton("Hard");
        hardButton.setBounds(304, 449, 183, 50);
        hardButton.setFont(new Font("Impact", Font.PLAIN, 24));
        hardButton.setActionCommand("Hard");
        hardButton.setForeground(new Color(0, 0, 0));
        hardButton.setBackground(Color.RED);
        add(hardButton);
        
        JLabel levelLabel = new JLabel("Choose Level");
        levelLabel.setBounds(261, 135, 274, 82);
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        levelLabel.setFont(new Font("Impact", Font.PLAIN, 45));
        levelLabel.setForeground(Color.WHITE);
        add(levelLabel);
        
        logoutButton = new JButton("Logout");
        logoutButton.setBounds(629, 22, 127, 43);
        logoutButton.setToolTipText("");
        logoutButton.setForeground(new Color(255, 255, 204));
        logoutButton.setFont(new Font("Impact", Font.PLAIN, 20));
        logoutButton.setBackground(Color.RED);
        add(logoutButton);
        
        btnBack = new JButton("Back");
        btnBack.setForeground(new Color(0, 0, 51));
        btnBack.setFont(new Font("Impact", Font.PLAIN, 20));
        btnBack.setBackground(new Color(51, 255, 255));
        btnBack.setBounds(49, 22, 137, 43);
        add(btnBack);
    }

    public void setStartGameAction(ActionListener actionListener) {
        easyButton.addActionListener(actionListener);
        mediumButton.addActionListener(actionListener);
        hardButton.addActionListener(actionListener);
    }

    public void setBackAction(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
    
    public void setLogoutAction(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }
}

