package view;

import model.interfaces.DicePair;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.interfaces.GameEngineCallback;

public class GameEngineCallbackGUI implements GameEngineCallback{
	
	private MainPanel mp;
	
	public GameEngineCallbackGUI(MainPanel mp) {
		this.mp = mp;
	}

	@Override
	public void intermediateResult(Player player, DicePair dicePair, GameEngine gameEngine) {
		final DicePair dp = dicePair;
		final Player p = player;
		new Thread() {
			@Override
			public void run() {
				mp.updateInterRoll(p.toString(), dp.getDice1(), dp.getDice2());
			};
		}.start();
	}

	@Override
	public void result(Player player, DicePair result, GameEngine gameEngine) {
		final DicePair r = result;
		final Player p = player;
		new Thread() {
			@Override
			public void run() {
				mp.updateFinalRoll(p.toString(), r.getDice1(), r.getDice2());
			};
		}.start();
	}

	@Override
	public void intermediateHouseResult(DicePair dicePair, GameEngine gameEngine) {
		final DicePair dp = dicePair;
		new Thread() {
			@Override
			public void run() {
				mp.updateInterRoll("House", dp.getDice1(), dp.getDice2());
			};
		}.start();
	}

	@Override
	public void houseResult(DicePair result, GameEngine gameEngine) {
		final DicePair r = result;
		new Thread() {
			@Override
			public void run() {
				mp.updateFinalRoll("House", r.getDice1(), r.getDice2());
			};
		}.start();
	}
}
