package main.views;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import main.ConnectionManager;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.JPasswordField;

public class SignUp extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;
	public JButton btnGoToLogin;
	public JButton btnSubmit;
	public JLabel messageLabel;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public SignUp() {
		setBackground(Color.DARK_GRAY);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setForeground(Color.YELLOW);
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 45));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(221, 116, 344, 82);
		add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Username:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(221, 240, 117, 44);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(221, 306, 117, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_1_1.setForeground(Color.WHITE);
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(137, 376, 201, 44);
		add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(348, 240, 217, 44);
		add(textField);
		textField.setColumns(10);
		
		btnSubmit = new JButton("Submit");
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(SystemColor.desktop);
		btnSubmit.setFont(new Font("Impact", Font.PLAIN, 20));
		btnSubmit.setBounds(293, 483, 117, 44);
		add(btnSubmit);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setForeground(new Color(0, 0, 0));
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setFont(new Font("Impact", Font.PLAIN, 20));
		btnReset.setBackground(Color.ORANGE);
		btnReset.setBounds(421, 483, 117, 44);
		add(btnReset);
		
		btnGoToLogin = new JButton("Go To Login");
		btnGoToLogin.setForeground(new Color(0, 0, 0));
		btnGoToLogin.setFont(new Font("Impact", Font.PLAIN, 20));
		btnGoToLogin.setBackground(Color.CYAN);
		btnGoToLogin.setBounds(334, 537, 164, 44);
		add(btnGoToLogin);
		
		messageLabel = new JLabel("");
		messageLabel.setForeground(new Color(255, 0, 0));
		messageLabel.setFont(new Font("Bahnschrift", Font.PLAIN, 22));
		messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
		messageLabel.setBounds(137, 605, 587, 35);
		add(messageLabel);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(348, 311, 217, 44);
		add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(348, 380, 217, 44);
		add(passwordField_1);
	}
	public void setGoToLoginAction(ActionListener actionListener) {
		btnGoToLogin.addActionListener(actionListener);
    }
	public void setSubmitAction(ActionListener actionListener) {
		btnSubmit.addActionListener(actionListener);
    }
	public void reset() {
		textField.setText("");
		passwordField.setText("");
		passwordField_1.setText("");
	}
	public int submitDataToDatabase() {
		messageLabel.setText("");
		
		String username = textField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(passwordField_1.getPassword());
        
        if( username.length() < 5 ) {
        	this.reset();
            messageLabel.setText("Username must be atleast 5 characters long.");
            return 1;
        }
        
        if (!password.equals(confirmPassword)) {
        	this.reset();
            messageLabel.setText("Passwords do not match.");
            return 1;
        }
        
        if( password.length() < 5 ) {
        	this.reset();
            messageLabel.setText("Password must be atleast 5 characters long.");
            return 1;
        }
        
		try {
			String query = "SELECT * FROM Player WHERE username = ? ";
            Connection connection = ConnectionManager.getConnection();
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setString(1, username);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
            	this.reset();
                messageLabel.setText("Username already exists. Please try again.");
                return 1;
            }
            
			query = "INSERT INTO Player VALUES (?,?);";
			ps = connection.prepareStatement(query);
			ps.setString(1, textField.getText());
			ps.setString(2, password);
			
			int res = ps.executeUpdate();
			
			if( res > 0 ) {
				// Trigger event that will change panel
				this.reset();
				return 0;
			} else {
				this.reset();
				messageLabel.setText("Error: Failed to Sign Up");
			}
		}	catch ( Exception e ) {
			System.out.println("Error: " + e);
			messageLabel.setText("Error: Failed to Sign Up");
		}
		return 1;
	}
}
