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

public class GameHistory extends JPanel {
	private static final long serialVersionUID = 1L;
	private JButton logoutButton;
	private String username;
	private JButton btnBack;
	private JTable historyTable;
	private JComboBox<String> comboBox;
    public GameHistory() {
        setBackground(Color.BLACK);
        setForeground(Color.WHITE);
        setLayout(null);
        
        JLabel levelLabel = new JLabel("Game History");
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
        
        historyTable = new JTable();
        historyTable.setBorder(null);
        historyTable.setEnabled(false);
        historyTable.setRowSelectionAllowed(false);
        historyTable.setBackground(Color.BLACK);
        historyTable.setForeground(Color.WHITE);
        historyTable.setShowGrid(false);
        historyTable.setShowHorizontalLines(false);
        historyTable.setShowVerticalLines(false);
        historyTable.setFont(new Font("Arial", Font.PLAIN, 15));
        historyTable.setBounds(116, 250, 600, 380);
        historyTable.setRowHeight(30);

        add(historyTable);
        
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
                fetchAndDisplayHistory();
            }
        });
        
        fetchAndDisplayHistory();
    }
    public void setUserName(String username) {
    	this.username = username;
    }
    private void fetchAndDisplayHistory() {
    	DefaultTableModel model = new DefaultTableModel(new Object[]{"SNO.", "TIMESTAMP", "SCORE", "DURATION"}, 0);
    
        model.addRow(new Object[]{"SNO.", "SCORE", "DURATION", "TIMESTAMP"});
        try {
            // Connect to your SQL database
        	Connection connection = ConnectionManager.getConnection();
        	// Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/your_database", "username", "password");

        	String selectedGameLevel = comboBox.getSelectedItem().toString();
        	System.out.println("History Selected Level: " + selectedGameLevel);
            String query = "SELECT StartGame_Timestamp, Score,\r\n"
            		+ "TIMEDIFF(EndGame_Timestamp, StartGame_Timestamp) AS Duration\r\n"
            		+ "FROM Score WHERE Game_Level = ? AND Username = ? ORDER BY StartGame_Timestamp DESC LIMIT 8;";
     
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setString(1, selectedGameLevel);
            statement.setString(2, this.username);
            ResultSet resultSet = statement.executeQuery();

            // Populate data into the model
            int rank = 1;
            while (resultSet.next()) {
                int score = resultSet.getInt("Score");
                String time = resultSet.getString("StartGame_Timestamp");
                String duration = resultSet.getString("Duration");
                model.addRow(new Object[]{rank++, score, duration, time});
            }

            // Set the model to the JTable
            historyTable.setModel(model);

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

