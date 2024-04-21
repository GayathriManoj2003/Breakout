package Breakout;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class Login extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	public JButton btnNewButton;
	public JButton btnSignUp;
	public Login() {
        setBackground(Color.DARK_GRAY);
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
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Wingdings 2", Font.PLAIN, 10));
        textField_1.setColumns(10);
        textField_1.setBounds(354, 312, 220, 39);
        add(textField_1);
        
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
        btnSignUp.setFont(new Font("Impact", Font.PLAIN, 20));
        btnSignUp.setBackground(Color.YELLOW);
        btnSignUp.setBounds(316, 486, 146, 45);
        add(btnSignUp);
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(211, 579, 375, 54);
        add(lblNewLabel_2);
    }
	public void setSignUpAction(ActionListener actionListener) {
		btnSignUp.addActionListener(actionListener);
    }
	public void setLoginAction(ActionListener actionListener) {
		btnNewButton.addActionListener(actionListener);
    }
	public void reset() {
		textField.setText("");
		textField_1.setText("");
	}
}
