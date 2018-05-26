package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;

public class AddPlayerWorker extends SwingWorker<Void, Player> {
	private GameEngine gameEngine;
	private MainPanel mp;
	private String playerName;
	private int points;
	private Player p;
	private MainMenuBar mmb;
	private int id = 0;
	
	public AddPlayerWorker(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, String playerName, int points) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		for(Player p: gameEngine.getAllPlayers()) {
			if(Integer.parseInt(p.getPlayerId()) > id) {
				id = Integer.parseInt(p.getPlayerId());
			}
		}
		
		p = new SimplePlayer(String.valueOf(id+1), playerName, points);
		gameEngine.addPlayer(p);
		
		return null;
	}

	@Override
	protected void done() {
		try {
			get();
			mp.addDisplay(p);
			mp.update();
			
			mmb.update();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Points Not A Number\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
