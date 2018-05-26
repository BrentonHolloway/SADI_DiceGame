package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;

public class UpdatePlayerWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private MainPanel mp;
	private Player p;
	private String playerName;
	private int points;
	
	public UpdatePlayerWorker(GameEngine ge, MainPanel mp, Player p, String playerName, int points) {
		this.ge = ge;
		this.mp = mp;
		this.p = p;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		Player pl = ge.getPlayer(p.getPlayerId());
		pl.setPlayerName(playerName);
		pl.setPoints(points);
		return null;
	}

	@Override
	protected void done() {
		try {
			get();
			mp.update();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "There was a problem updateing player: " + p.getPlayerName()+ "\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
	}
}
