package Breakout;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class SignUp extends JPanel {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	public JButton btnGoToLogin;
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
		lblNewLabel_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(221, 240, 117, 44);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password:");
		lblNewLabel_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1_1.setBounds(221, 306, 117, 44);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Confirm Password:");
		lblNewLabel_1_1_1.setFont(new Font("Segoe UI Black", Font.PLAIN, 20));
		lblNewLabel_1_1_1.setBounds(137, 376, 201, 44);
		add(lblNewLabel_1_1_1);
		
		textField = new JTextField();
		textField.setBounds(348, 240, 217, 44);
		add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(348, 306, 217, 44);
		add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(348, 376, 217, 44);
		add(textField_2);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(SystemColor.desktop);
		btnNewButton.setFont(new Font("Impact", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(340, 483, 117, 44);
		add(btnNewButton);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				reset();
			}
		});
		btnReset.setForeground(Color.WHITE);
		btnReset.setFont(new Font("Impact", Font.PLAIN, 20));
		btnReset.setBackground(Color.ORANGE);
		btnReset.setBounds(340, 537, 117, 44);
		add(btnReset);
		
		btnGoToLogin = new JButton("Go To Login");
		btnGoToLogin.setForeground(Color.WHITE);
		btnGoToLogin.setFont(new Font("Impact", Font.PLAIN, 20));
		btnGoToLogin.setBackground(Color.CYAN);
		btnGoToLogin.setBounds(315, 591, 164, 44);
		add(btnGoToLogin);
	}
	public void setGoToLoginAction(ActionListener actionListener) {
		btnGoToLogin.addActionListener(actionListener);
    }
	public void reset() {
		textField.setText("");
		textField_1.setText("");
		textField_2.setText("");
	}

}
