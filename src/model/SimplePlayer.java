package model;

import model.interfaces.DicePair;
import model.interfaces.Player;

public class SimplePlayer implements Player{
	public SimplePlayer(String playerNum, String name, int credit) {
		
	}

	@Override
	public String getPlayerName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerName(String playerName) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getPoints() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setPoints(int points) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getPlayerId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean placeBet(int bet) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBet() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public DicePair getRollResult() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRollResult(DicePair rollResult) {
		// TODO Auto-generated method stub
		
	}

}
