package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;
import view.StatusBar;

public class UpdatePlayerWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private MainPanel mp;
	private StatusBar sb;
	private Player p;
	private String playerName;
	private int points;
	
	public UpdatePlayerWorker(GameEngine ge, MainPanel mp, StatusBar sb, Player p, String playerName, int points) {
		this.ge = ge;
		this.mp = mp;
		this.sb = sb;
		this.p = p;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		publish("Updating player: " + p.getPlayerName());
		Player pl = ge.getPlayer(p.getPlayerId());
		pl.setPlayerName(playerName);
		pl.setPoints(points);
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
			mp.update();
			publish("Player: " + p.getPlayerName() + " updated");
		}catch (ExecutionException | InterruptedException e) {
			publish("There was a problem updateing player: " + p.getPlayerName());
			JOptionPane.showMessageDialog(null, "There was a problem updateing player: " + p.getPlayerName()+ "\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
	}
}
