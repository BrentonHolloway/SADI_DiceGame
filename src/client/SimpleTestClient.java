package client;

import model.GameEngineImpl;
import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;

/**
 * Simple console client for SADI assignment 1, 2018
 * NOTE: This code will not compile until you have implemented stubs for the supplied interfaces!
 * 
 * You must be able to compile your code WITHOUT modifying this class.
 * Additional testing should be done by copying and extending this class while ensuring this class still works.
 * 
 * @author Caspar Ryan
 * @author Brenton Holloway s3485302
 * 
 * PLEASE NOTE: IN THE ORIGINAL CODE YOU WHERE ADDING A PLAYER AFTER PLACING A BET
 * 				IT ONLY MAKES SENSE TO ADD THE PLAYER TO THE GAME BEFORE PLACING A BET
 * 
 * 
 */
public class SimpleTestClient
{
	public static void main(String args[])
	{
		// instantiate the GameEngine so we can make calls
		final GameEngine gameEngine = new GameEngineImpl();

		// create two test players (NOTE: you will need to implement the 3 arg contructor in SimplePlayer)
		Player[] players = new Player[]
		{ new SimplePlayer("1", "The Roller", 1000), new SimplePlayer("2", "The Loser", 500), new SimplePlayer("3", "Fake", 100000) };

		// register the callback for notifications (all logging output is done by GameEngineCallbackImpl)
		// see provided skeleton class GameEngineCallbackImpl.java
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());

		// main loop to add players place a bet and roll
		for (Player player : players)
		{
			/*ORIGINAL
			 * gameEngine.placeBet(player, 100);
			 * gameEngine.addPlayer(player);
			 * gameEngine.rollPlayer(player, 1, 100, 20);
			 */
			
			gameEngine.addPlayer(player);//can't place be before adding the player
			gameEngine.placeBet(player, 100);
			gameEngine.rollPlayer(player, 1, 100, 20);
		}

		// all players have rolled so now house rolls (GameEngineCallBack is
		// called) and results are calculated
		gameEngine.rollHouse(1, 100, 20);
	}
}
