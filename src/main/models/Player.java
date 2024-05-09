package main.models;

public class Player {
	public String Username;
	public int Score;
	public String Level;
	Player() {
		this.Score = 0;
	}
	public Player(String Username) {
		this.Username = Username;
		this.Level = "";
		this.Score = 0;
	}
	public String getUsername() {
		return Username;
	}
	public void setUsername(String username) {
		Username = username;
	}
	public int getScore() {
		return Score;
	}
	public void setScore(int score) {
		Score = score;
	}
	public String getLevel() {
		return Level;
	}
	public void setLevel(String level) {
		Level = level;
	}
	
}
