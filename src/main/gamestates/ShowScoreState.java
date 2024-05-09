package main.gamestates;

import main.interfaces.GameState;

public class ShowScoreState implements GameState {
	public String message;
	@Override
	public void setMessage(String message) {
		// TODO Auto-generated method stub
		this.message = message;
	}

	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return message;
	}

}
