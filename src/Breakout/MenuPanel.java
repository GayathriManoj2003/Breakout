package Breakout;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionListener;
import javax.swing.SwingConstants;
import java.awt.event.ActionEvent;

public class MenuPanel extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JButton easyButton;
	public JButton mediumButton;
	public JButton hardButton;
	private JButton logoutButton;
    public MenuPanel() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        easyButton = new JButton("Easy");
        easyButton.setFont(new Font("Impact", Font.PLAIN, 24));
        easyButton.setActionCommand("Easy");
        easyButton.setBounds(329, 299, 145, 43);
        easyButton.setBackground(Color.GREEN);
        add(easyButton);
        
        mediumButton = new JButton("Medium");
        mediumButton.setFont(new Font("Impact", Font.PLAIN, 24));
        mediumButton.setActionCommand("Medium");
        mediumButton.setBackground(Color.ORANGE);
        mediumButton.setBounds(329, 365, 145, 43);
        add(mediumButton);
        
        hardButton = new JButton("Hard");
        hardButton.setFont(new Font("Impact", Font.PLAIN, 24));
        hardButton.setActionCommand("Hard");
        hardButton.setForeground(Color.BLACK);
        hardButton.setBackground(Color.RED);
        hardButton.setBounds(329, 427, 145, 43);
        add(hardButton);
        
        JLabel levelLabel = new JLabel("Choose Level");
        levelLabel.setHorizontalAlignment(SwingConstants.CENTER);
        levelLabel.setFont(new Font("Impact", Font.PLAIN, 45));
        levelLabel.setForeground(Color.WHITE);
        levelLabel.setBounds(262, 175, 274, 82);
        add(levelLabel);
        
        logoutButton = new JButton("Logout");
        logoutButton.setToolTipText("");
        logoutButton.setForeground(Color.DARK_GRAY);
        logoutButton.setFont(new Font("Impact", Font.PLAIN, 20));
        logoutButton.setBackground(Color.RED);
        logoutButton.setBounds(614, 91, 127, 43);
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
