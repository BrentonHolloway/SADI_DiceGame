package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

public class GameEngineImpl implements GameEngine{
	
	HashMap<String, Player> players = new HashMap<String, Player>();
	GameEngineCallback gameEngineCallback;
	private final int MIN_DIE_NUM = 1;
	
	public GameEngineImpl() { 
	}
	
	public int roll(int numberOfFaces) {
		return MIN_DIE_NUM + (int)(Math.random() * ((numberOfFaces - MIN_DIE_NUM) + 1));
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		return player.placeBet(bet);
	}
	
	/**
	 * roll the dice progressing from the initialDelay to the finalDelay in
	 * increments of delayIncrement, delays are in milliseconds (ms)
	 * 
	 * 1. start at initialDelay then increment the delay each time a new number
	 *    is shown on the die faces 
	 * 2. call GameEngineCallback.intermediateResult(...) or intermediateHouseResult(...) each time 
	 *    a pair of new dice faces are shown until delay greater than or equal to finalDelay 
	 * 3. call GameEngineCallback.result(...) or houseResult(...) with final result for player or house 
	 * 4. make sure you update the player with final result so it can be retreived later
	 * 
	 * @param player
	 *            the player who is rolling and will have their result set
	 *            at the end of the roll
	 * @param initialDelay
	 *            the starting delay in ms between updates (based on how fast
	 *            dice are rolling)
	 * @param finalDelay
	 *            the final delay in ms between updates when the dice stop
	 *            rolling
	 * @param delayIncrement
	 *            how much the dice slow down (delay gets longer) after each
	 *            roll/tumble
	 * 
	 * @see model.interfaces.GameEngineCallback
	 * 
	 */
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dice = null;
		
		while(initialDelay < finalDelay) {
			dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
			gameEngineCallback.intermediateResult(player, dice, this);
			initialDelay += delayIncrement;
		}
		player.setRollResult(dice);
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		// TODO Auto-generated method stub
		
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
		this.gameEngineCallback = gameEngineCallback;
		
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return players.values();
	}
}
