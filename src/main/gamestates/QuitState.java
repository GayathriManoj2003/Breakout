package main.gamestates;

import main.interfaces.GameState;

public class QuitState implements GameState {
	private String message;
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message = "Quit Game" ;
	}
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return this.message;
	}
}
