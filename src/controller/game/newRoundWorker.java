package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class newRoundWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private ScorePanel sp;
	private DiceDisplay dd;
	private StatusBar sb;
	
	public newRoundWorker(GameEngine ge, ScorePanel sp, DiceDisplay dd, StatusBar sb) {
		this.ge = ge;
		this.sp = sp;
		this.dd = dd;
		this.sb = sb;
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
	protected void process(List<String> chunks) {
		sb.update(chunks.get(0));
	}

	@Override
	protected void done() {
		try {
			get();
			sp.update();
			for(Player p : ge.getAllPlayers()) {
				dd.updateDicePanel(p.toString(), "-", "-");
			}
			publish("New Round Started");
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Error\n" + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
}
