package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class newRoundWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private ScorePanel sp;
	private DiceDisplay dd;
	
	public newRoundWorker(GameEngine ge, ScorePanel sp, DiceDisplay dd) {
		this.ge = ge;
		this.sp = sp;
		this.dd = dd;
	}

	@Override
	protected Void doInBackground() throws Exception {
		for(Player p : ge.getAllPlayers()) {
			p.setRollResult(null);
			p.placeBet(0);
		}
		return null;
	}
	
	@Override
	protected void done() {
		try {
			get();
			sp.update();
			for(Player p : ge.getAllPlayers()) {
				dd.updateDicePanel(p.toString(), "-", "-");
			}
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
