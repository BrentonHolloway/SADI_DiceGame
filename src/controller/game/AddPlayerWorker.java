package controller.game;

import java.util.concurrent.ExecutionException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.AddPlayerDialog;
import view.MainMenuBar;
import view.MainPanel;

public class AddPlayerWorker extends SwingWorker<Void, Player> {
	private GameEngine gameEngine;
	private MainPanel ui;
	private JTextField playerName;
	private JTextField points;
	private Player p;
	private MainMenuBar mmb;
	
	public AddPlayerWorker(GameEngine gameEngine, MainPanel ui, MainMenuBar mmb, JTextField playerName, JTextField points) {
		this.gameEngine = gameEngine;
		this.ui = ui;
		this.mmb = mmb;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		p = new SimplePlayer(String.valueOf(gameEngine.getAllPlayers().size()+1), playerName.getText(), Integer.parseInt(points.getText()));
		gameEngine.addPlayer(p);
		
		return null;
	}

	@Override
	protected void done() {
		try {
			get();
			ui.update();
			mmb.update();
		}catch (ExecutionException | InterruptedException e) {
			JOptionPane.showMessageDialog(null, "Points Not A Number\n" + e.getMessage(), "Not A Number", JOptionPane.ERROR_MESSAGE);
		}
		
	}
}
