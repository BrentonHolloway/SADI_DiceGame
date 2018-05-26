package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;

public class RollHouseWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private DiceDisplay dd;
	private boolean oneRolled;
	
	public RollHouseWorker(GameEngine ge, DiceDisplay dd) {
		this.ge = ge;
		this.dd = dd;
	}

	@Override
	protected Void doInBackground() throws Exception {
		oneRolled = false;
		for(Player p : ge.getAllPlayers()) {
			if(p.getRollResult() != null) {
				oneRolled = true;
				break;
			}
		}
		
		if(oneRolled) {
			dd.showDicePanel("House");
			ge.rollHouse(0, 1000, 100);
		}else {
			throw new Exception("No Players have rolled");
		}
		
		return null;
	}
	
	@Override
	protected void done() {
		try {
			get();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
