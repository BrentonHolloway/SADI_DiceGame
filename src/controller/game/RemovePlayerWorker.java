package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;

public class RemovePlayerWorker extends SwingWorker<Void, Player> {
	
	private GameEngine ge;
	private MainPanel mp;
	private MainMenuBar mmb;
	private Player p;
	
	public RemovePlayerWorker(GameEngine ge, MainPanel mp, MainMenuBar mmb, Player p) {
		this.ge = ge;
		this.mp = mp;
		this.mmb = mmb;
		this.p = p;
	}

	@Override
	protected Void doInBackground() throws Exception {
		ge.removePlayer(p);
		return null;
	}
	
	@Override
	protected void done() {
		try {
			get();
			mp.update();
			mmb.update();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "There was a problem removing player: " + p.getPlayerName()+ "\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
	}

}
