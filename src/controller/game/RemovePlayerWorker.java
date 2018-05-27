package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;

public class RemovePlayerWorker extends SwingWorker<Void, String> {
	
	private GameEngine ge;
	private MainPanel mp;
	private MainMenuBar mmb;
	private StatusBar sb;
	private Player p;
	
	public RemovePlayerWorker(GameEngine ge, MainPanel mp, MainMenuBar mmb, StatusBar sb, Player p) {
		this.ge = ge;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
		this.p = p;
	}

	@Override
	protected Void doInBackground() throws Exception {
		publish("Removing Player");
		ge.removePlayer(p);
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
			mp.removeDisplay(p);
			mmb.update();
			publish("Removed Player: " + p.getPlayerName());
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "There was a problem removing player: " + p.getPlayerName()+ "\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
	}

}
