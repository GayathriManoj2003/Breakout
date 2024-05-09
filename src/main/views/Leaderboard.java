package main.views;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import main.ConnectionManager;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class Leaderboard extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton logoutButton;
	private JButton btnBack;
	private JTable leaderboardTable;
	private JComboBox<String> comboBox;
    public Leaderboard() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        JLabel levelLabel = new JLabel("Leaderboard");
        levelLabel.setBounds(260, 79, 274, 82);
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
        
        leaderboardTable = new JTable();
        leaderboardTable.setBorder(null);
        leaderboardTable.setEnabled(false);
        leaderboardTable.setRowSelectionAllowed(false);
        leaderboardTable.setBackground(Color.BLACK);
        leaderboardTable.setForeground(Color.WHITE);
        leaderboardTable.setShowGrid(false);
        leaderboardTable.setShowHorizontalLines(false);
        leaderboardTable.setShowVerticalLines(false);
        leaderboardTable.setFont(new Font("Arial", Font.PLAIN, 15));
        leaderboardTable.setBounds(116, 250, 600, 380);
        leaderboardTable.setRowHeight(30);

        add(leaderboardTable);
        
        comboBox = new JComboBox<String>();
        comboBox.setForeground(Color.DARK_GRAY);
        comboBox.setFont(new Font("Ink Free", Font.PLAIN, 20));
        comboBox.setBackground(Color.LIGHT_GRAY);
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"Easy", "Medium", "Hard"}));
        comboBox.setBounds(309, 171, 173, 35);
        add(comboBox);

        comboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fetchAndDisplayLeaderboard();
            }
        });
        
        fetchAndDisplayLeaderboard();
    }
    
    private void fetchAndDisplayLeaderboard() {
    	DefaultTableModel model = new DefaultTableModel(new Object[]{"RANK", "USERNAME", "SCORE", "DURATION"}, 0);
    
        model.addRow(new Object[]{"Rank", "Username", "Score", "Duration"});
        try {
            // Connect to your SQL database
        	Connection connection = ConnectionManager.getConnection();
        	// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

        	String selectedGameLevel = comboBox.getSelectedItem().toString();
        	System.out.println("Leaderboard Selected Level: " + selectedGameLevel);
            String query = 
            		"SELECT Username,\r\n"
            		+ "Score,\r\n"
            		+ "TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) AS Duration\r\n"
            		+ "FROM Score WHERE Game_Level = ? ORDER BY Score DESC,\r\n"
            		+ "TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) ASC LIMIT 10;";
     
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, selectedGameLevel);
            ResultSet resultSet = statement.executeQuery();

            // Populate data into the model
            int rank = 1;
            while (resultSet.next()) {
                String username = resultSet.getString("Username");
                int score = resultSet.getInt("Score");
                String duration = resultSet.getString("Duration");
                model.addRow(new Object[]{rank++, username, score, duration});
            }

            // Set the model to the JTable
            leaderboardTable.setModel(model);

            // Close resources
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void setBackAction(ActionListener actionListener) {
        btnBack.addActionListener(actionListener);
    }
    
    public void setLogoutAction(ActionListener actionListener) {
        logoutButton.addActionListener(actionListener);
    }
}

