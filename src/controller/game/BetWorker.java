package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainToolBar;

public class BetWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private MainToolBar mtb;
	private Player p;
	private int bet;
	
	public BetWorker(GameEngine ge, MainToolBar mtb, Player p, int bet) {
		this.ge = ge;
		this.mtb = mtb;
		this.p = p;
		this.bet = bet;
	}

	@Override
	protected Void doInBackground() throws Exception {	
		if(!ge.getPlayer(p.getPlayerId()).placeBet(bet)) {
			throw new Exception("Bet out of bounds\n");
		}
		return null;
	}
	
	@Override
	protected void done() {
		try {
			get();
			mtb.updatePlayers();
		} catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Bet Not A Valid Number\n" + e.getMessage(), "Not A Valid Number", JOptionPane.ERROR_MESSAGE);
		}
	}
}
