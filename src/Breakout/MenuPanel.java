package Breakout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton easyButton;
	public JButton mediumButton;
	public JButton hardButton;
	public JButton logoutButton;
    public MenuPanel() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        easyButton = new JButton("Easy");
        easyButton.setActionCommand("Easy");
        easyButton.setBounds(169, 125, 85, 21);
        easyButton.setBackground(Color.GREEN);
        add(easyButton);
        
        mediumButton = new JButton("Medium");
        mediumButton.setActionCommand("Medium");
        mediumButton.setBackground(Color.ORANGE);
        mediumButton.setBounds(169, 156, 85, 21);
        add(mediumButton);
        
        hardButton = new JButton("Hard");
        hardButton.setActionCommand("Hard");
        hardButton.setForeground(Color.BLACK);
        hardButton.setBackground(Color.RED);
        hardButton.setBounds(169, 187, 85, 21);
        add(hardButton);
        
        JLabel levelLabel = new JLabel("Choose Level");
        levelLabel.setFont(new Font("Impact", Font.PLAIN, 26));
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setBounds(143, 68, 145, 33);
        add(levelLabel);
        
        logoutButton = new JButton("Logout");
        logoutButton.setForeground(Color.RED);
        logoutButton.setBounds(344, 24, 85, 21);
        add(logoutButton);
    }

    public void setStartGameAction(ActionListener actionListener) {
        easyButton.addActionListener(actionListener);
        mediumButton.addActionListener(actionListener);
        hardButton.addActionListener(actionListener);
    }

    public void setLogoutAction(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }
}
