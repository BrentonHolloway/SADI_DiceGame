package model;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

/**
 * 
 * @author Brenton Holloway SID: s3485302
 *
 */
public class GameEngineImpl implements GameEngine{
	
	Map<String, Player> players = new HashMap<String, Player>(); //Hashmap for storing players
	List<GameEngineCallback> gameEngineCallbacks = new ArrayList<GameEngineCallback>(); //ArrayList for storing game engine call backs
	private final int MIN_DIE_NUM = 1;
	
	public GameEngineImpl() { 
	}
	
	private int roll(int numberOfFaces) {
		return MIN_DIE_NUM + (int)(Math.random() * ((numberOfFaces - MIN_DIE_NUM) + 1));
	}

	@Override
	public boolean placeBet(Player player, int bet) {
		if(players.containsValue(player)) {
			return players.get(player.getPlayerId()).placeBet(bet);
		}else {
			return false;
		}
	}
	
	@Override
	public void rollPlayer(Player player, int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dice = null;
		int initDel = initialDelay;
		try {
			if(!players.containsValue(player))
				return;
			
			if(player.getBet() > 0) {
				//intermediate dice rolls for the player
				while(initDel < finalDelay) {
					dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
					
					for(GameEngineCallback gecb: gameEngineCallbacks) {
						gecb.intermediateResult(player, dice, this);
					}
					
					Thread.sleep(initDel);
					initDel += delayIncrement;
				}
				
				//final dice roll
				Thread.sleep(initDel);
				dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
				
				for(GameEngineCallback gecb: gameEngineCallbacks) {
					gecb.result(player, dice, this);
				}
				
				player.setRollResult(dice);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void rollHouse(int initialDelay, int finalDelay, int delayIncrement) {
		DicePair dice = null;
		int initDel = initialDelay;
		try {
			//intermediate dice rolls for the house
			while(initDel < finalDelay) {
				dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
				
				for(GameEngineCallback gecb: gameEngineCallbacks) {
					gecb.intermediateHouseResult(dice, this);
				}
				
				Thread.sleep(initDel);
				initDel += delayIncrement;
			}
			
			//final dice roll
			Thread.sleep(initDel);
			dice = new DicePairImpl(roll(NUM_FACES),roll(NUM_FACES),NUM_FACES);
			
			for(GameEngineCallback gecb: gameEngineCallbacks) {
				gecb.houseResult(dice, this);
			}
			
			//update plays points
			for(Player p : players.values()) {
				if(p.getBet() > 0) {
					if((p.getRollResult().getDice1() + p.getRollResult().getDice2()) > (dice.getDice1() + dice.getDice2())) {
						//player wins 2* their bet
						p.setPoints(p.getPoints()+2*p.getBet());
						//set bet to zero again
						//p.placeBet(0);
					}else if((p.getRollResult().getDice1() + p.getRollResult().getDice2()) == (dice.getDice1() + dice.getDice2())){
						//player has their bet amount returned
						p.setPoints(p.getPoints()+p.getBet());
						//set bet to zero
						//p.placeBet(0);
					}else {
						//player looses bet
						//p.placeBet(0);
					}
				}
			}
		}  catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void addPlayer(Player player) {
		this.players.put(player.getPlayerId(), player);
	}

	@Override
	public Player getPlayer(String id) {
		return this.players.get(id);
	}

	@Override
	public boolean removePlayer(Player player) {
		return this.players.remove(player.getPlayerId(), player);
	}

	@Override
	public void addGameEngineCallback(GameEngineCallback gameEngineCallback) {
		this.gameEngineCallbacks.add(gameEngineCallback);
	}

	@Override
	public boolean removeGameEngineCallback(GameEngineCallback gameEngineCallback) {
		return this.gameEngineCallbacks.remove(gameEngineCallback);
	}

	@Override
	public Collection<Player> getAllPlayers() {
		return Collections.unmodifiableCollection(this.players.values());
	}
}
