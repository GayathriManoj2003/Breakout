package Breakout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class Leaderboard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton logoutButton;
	private JButton btnBack;
    public Leaderboard() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        JLabel levelLabel = new JLabel("Leaderboard");
        levelLabel.setBounds(260, 97, 274, 82);
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
        btnBack.setBounds(49, 22, 137, 43);
        btnBack.setForeground(new Color(0, 0, 51));
        btnBack.setFont(new Font("Impact", Font.PLAIN, 20));
        btnBack.setBackground(new Color(51, 255, 255));
        add(btnBack);
    }

    public void setBackAction(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
    
    public void setLogoutAction(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }
}

