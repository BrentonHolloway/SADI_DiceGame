package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RollWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private Player p;
	
	public RollWorker(GameEngine ge, Player p) {
		this.ge = ge;
		this.p = p;
	}

	@Override
	protected Void doInBackground() throws Exception {
		if(ge.getPlayer(p.getPlayerId()).getRollResult()==null) {
			if(ge.getPlayer(p.getPlayerId()).getBet() > 0) {
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
	protected void done() {
		try {
			get();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
	}

}
