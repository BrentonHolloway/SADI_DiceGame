package controller.game;

import java.util.List;
import java.util.concurrent.ExecutionException;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;

public class AddPlayerWorker extends SwingWorker<Void, String> {
	private GameEngine gameEngine;
	private MainPanel mp;
	private String playerName;
	private int points;
	private Player p;
	private MainMenuBar mmb;
	private StatusBar sb;
	private int id = 0;
	
	public AddPlayerWorker(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, StatusBar sb, String playerName, int points) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		publish("Adding Player");
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
	protected void process(List<String> chunks) {
		sb.update(chunks.get(0));
	}

	@Override
	protected void done() {
		try {
			get();
			mp.addDisplay(p);
			mp.update();
			mmb.update();
			publish("Player: " + p.getPlayerName() + " Added");
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Points Not A Number\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
