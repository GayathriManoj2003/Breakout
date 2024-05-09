package main.views;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.ConnectionManager;
import main.models.Player;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import java.awt.event.ActionEvent;

public class Login extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	private JPasswordField passwordField;
	public JButton btnNewButton;
	public JButton btnSignUp;
	public JLabel messageLabel;
	public Login() {
        setBackground(new Color(0, 0, 51));
        setLayout(null);
        
        JLabel lblNewLabel = new JLabel("PLAYER LOGIN");
        lblNewLabel.setForeground(Color.ORANGE);
        lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 45));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(189, 131, 385, 71);
        add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("Username:");
        lblNewLabel_1.setForeground(Color.CYAN);
        lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(189, 246, 155, 36);
        add(lblNewLabel_1);
        
        textField = new JTextField();
        textField.setBounds(354, 245, 220, 39);
        add(textField);
        textField.setColumns(10);
        
        passwordField = new JPasswordField();
        passwordField.setColumns(10);
        passwordField.setBounds(354, 312, 220, 39);
        add(passwordField);
        
        JLabel lblNewLabel_1_1 = new JLabel("Password:");
        lblNewLabel_1_1.setForeground(Color.CYAN);
        lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setBounds(180, 312, 164, 36);
        add(lblNewLabel_1_1);
        
        btnNewButton = new JButton("Login");
        btnNewButton.setBackground(Color.GREEN);
        btnNewButton.setFont(new Font("Impact", Font.PLAIN, 20));
        btnNewButton.setBounds(316, 412, 146, 45);
        add(btnNewButton);
        
        btnSignUp = new JButton("Sign Up");
        btnSignUp.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        btnSignUp.setFont(new Font("Impact", Font.PLAIN, 20));
        btnSignUp.setBackground(Color.YELLOW);
        btnSignUp.setBounds(316, 486, 146, 45);
        add(btnSignUp);
        
        messageLabel = new JLabel("");
        messageLabel.setForeground(Color.RED);
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        messageLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        messageLabel.setBounds(189, 579, 414, 54);
        add(messageLabel);
    }
	public void setSignUpAction(ActionListener actionListener) {
		btnSignUp.addActionListener(actionListener);
    }
	public void setLoginAction(ActionListener actionListener) {
		btnNewButton.addActionListener(actionListener);
    }
	public Player verifyPlayer() {
		messageLabel.setText("");
		
		String username = textField.getText();
        String password = new String(passwordField.getPassword());
        
		try {
			String query = "SELECT * FROM Player WHERE username = ? AND password = ? ";
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                // Player exists with the given user name and password
            	this.reset();
                return new Player(username);
            } else {
                // No player found with the given credentials
                this.reset();
                messageLabel.setText("Incorrect Username or Password.");
                return null;
            }
   
		}	catch ( Exception e ) {
			System.out.println("Error: " + e);
			messageLabel.setText("Error: Failed to Login");
		}
		return null;
	}
	public void reset() {
		textField.setText("");
		passwordField.setText("");
	}
}
