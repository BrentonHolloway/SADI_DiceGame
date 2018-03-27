package model;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.GameEngineCallback;
import model.interfaces.Player;

/**
 * 
 * Skeleton example implementation of GameEngineCallback showing Java logging behaviour
 * 
 * @author Caspar Ryan
 * @see model.interfaces.GameEngineCallback
 * 
 */
public class GameEngineCallbackImpl implements GameEngineCallback
{
	private Logger logger = Logger.getLogger("assignment1");

	public GameEngineCallbackImpl()
	{
		ConsoleHandler consoleHandler = new ConsoleHandler();
		consoleHandler.setLevel(Level.FINE);
		logger.addHandler(consoleHandler);
		logger.setUseParentHandlers(false);
		
		//FINE shows rolling output, INFO only shows result
		logger.setLevel(Level.FINE);
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine)
	{
		logger.log(Level.FINE, String.format("%s: ROLLING Die 1: %d Die 2: %d .. Total: %d", player.getPlayerName(), dicePair.getDice1(), dicePair.getDice2(), dicePair.getDice1()+dicePair.getDice2()));
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine)
	{
		logger.log(Level.INFO, String.format("%s: *RESULT* Die 1: %d Die 2: %d .. Total: %d", player.getPlayerName(), result.getDice1(), result.getDice2(), result.getDice1()+result.getDice2()));
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		logger.log(Level.FINE, String.format("House: ROLLING Die 1: %d Die 2: %d .. Total: %d", dicePair.getDice1(), dicePair.getDice2(), dicePair.getDice1()+dicePair.getDice2()));
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		logger.log(Level.INFO, String.format("House: *RESULT* Die 1: %d Die 2: %d .. Total: %d", result.getDice1(), result.getDice2(), result.getDice1()+result.getDice2()));
	}
}
