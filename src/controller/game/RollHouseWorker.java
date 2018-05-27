package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;
import view.dice_board.DiceDisplay;

public class RollHouseWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private DiceDisplay dd;
	private StatusBar sb;
	private boolean oneRolled;
	
	public RollHouseWorker(GameEngine ge, DiceDisplay dd, StatusBar sb) {
		this.ge = ge;
		this.dd = dd;
		this.sb = sb;
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
			publish("House Rolling...");
			dd.showDicePanel("House");
			ge.rollHouse(0, 1000, 100);
		}else {
			throw new Exception("No Players have rolled");
		}
		
		return null;
	}
	
	@Override
	protected void process(List<String> chunks) {
		sb.update(chunks.get(0));
	}

	@Override
	protected void done() {
		try {
			get();
			publish("House Rolled");
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

}
