package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine{
	
	Map<String, Player> players = new HashMap<String, Player>();
	List<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>();
	private final int MIN_DIE_NUM = 1;
	
	public GameEngineImpl() { 
	}
	
	private int roll(int numberOfFaces) {
		return MIN_DIE_NUM + (int)(Math.random() * ((numberOfFaces - MIN_DIE_NUM) + 1));
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}
	
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dice = null;
		int initDel = initialDelay;
		
		while(initDel < finalDelay) {
			dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
			
			for(GameEngineCallback gecb: gameEngineCallbacks) {
				gecb.intermediateResult(player, dice, this);
			}
			
			initDel += delayIncrement;
		}
		
		dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
		
		for(GameEngineCallback gecb: gameEngineCallbacks) {
			gecb.result(player, dice, this);
		}
		
		player.setRollResult(dice);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dice = null;
		int initDel = initialDelay;
		
		while(initDel < finalDelay) {
			dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
			
			for(GameEngineCallback gecb: gameEngineCallbacks) {
				gecb.intermediateHouseResult(dice, this);
			}
			
			initDel += delayIncrement;
		}
		
		dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
		
		for(GameEngineCallback gecb: gameEngineCallbacks) {
			gecb.houseResult(dice, this);
		}
	}

	@Override
	public void addPlayer(Player player) {
		players.put(player.getPlayerId(), player);
	}

	@Override
	public Player getPlayer(String id) {
		return this.players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		if(this.players.remove(player.getPlayerId()) == null) {
			return false;
		}
		return true;
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallbacks.add(gameEngineCallback);
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		for(GameEngineCallback g : gameEngineCallbacks) {
			if(g.equals(gameEngineCallback)) {
				gameEngineCallbacks.remove(g);
				return true;
			}
		}
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players.values();
	}
}
