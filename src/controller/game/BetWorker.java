package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;
import view.score_board.ScorePanel;

public class BetWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private ScorePanel sp;
	private StatusBar sb;
	private Player p;
	private int bet;
	
	public BetWorker(GameEngine ge, ScorePanel sp, StatusBar sb, Player p, int bet) {
		this.ge = ge;
		this.sp = sp;
		this.sb = sb;
		this.p = p;
		this.bet = bet;
	}

	@Override
	protected Void doInBackground() throws Exception {
		
		if(ge.getPlayer(p.getPlayerId()).getRollResult() == null) {
			if(!ge.getPlayer(p.getPlayerId()).placeBet(bet)) {
				publish("Placing bet");
				throw new Exception("Bet out of bounds\n");
			}
		} else {
			
			throw new Exception("You have already rolled");
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
			sp.update();
			publish(p.getPlayerName() + "placed a bet of: " + bet);
		} catch (ExecutionException | InterruptedException e) {
			publish(e.getMessage());
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
