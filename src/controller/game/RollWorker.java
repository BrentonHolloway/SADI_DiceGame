package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;

public class RollWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private StatusBar sb;
	private Player p;
	
	public RollWorker(GameEngine ge, StatusBar sb, Player p) {
		this.ge = ge;
		this.sb = sb;
		this.p = p;
	}

	@Override
	protected Void doInBackground() throws Exception {
		if(ge.getPlayer(p.getPlayerId()).getRollResult()==null) {
			if(ge.getPlayer(p.getPlayerId()).getBet() > 0) {
				publish("Player: " + p.getPlayerName() + " is Rolling...");
				ge.rollPlayer(p, 0, 1000, 100);
			}else {
				throw new Exception("A Bet must be placed before you can roll");
			}
		}else {
			throw new Exception("You can only roll once");
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
			publish("Player: " + p.getPlayerName() + " Rolled");
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
