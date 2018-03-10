package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player{
	
	String playerId;
	String name;
	int points;
	int bet;
	DicePair roll;
	
	public SimplePlayer(String playerId, String name, int points) {
		this.playerId = playerId;
		this.name = name;
		this.points = points;
	}

	@Override
	public String getPlayerName() {
		return this.name;
	}

	@Override
	public void setPlayerName(String playerName) {
		this.name = playerName;
		
	}

	@Override
	public int getPoints() {
		return this.points;
	}

	@Override
	public void setPoints(int points) {
		this.points = points;
	}

	@Override
	public String getPlayerId() {
		return this.playerId;
	}

	@Override
	public boolean placeBet(int bet) {
		if(bet <= points) {
			this.points -= bet;
			this.bet += bet;
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getBet() {
		return this.bet;
	}

	@Override
	public DicePair getRollResult() {
		return this.roll;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		this.roll = rollResult;
	}

}
