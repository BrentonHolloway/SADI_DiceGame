package controller.game;

import java.util.List;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.UIPanel;

public class AddPlayerWorker extends SwingWorker<Void, Player> {
	private GameEngine gameEngine;
	private UIPanel ui;
	private JTextField playerName;
	private JTextField points;
	private Player p;
	
	public AddPlayerWorker(GameEngine gameEngine, UIPanel ui, JTextField playerName, JTextField points) {
		this.gameEngine = gameEngine;
		this.ui = ui;
		this.playerName = playerName;
		this.points = points;
	}

	@Override
	protected Void doInBackground() throws Exception {
		p = new SimplePlayer(String.valueOf(gameEngine.getAllPlayers().size()+1), playerName.getText(), Integer.parseInt(points.getText()));
		publish(p);
		
		return null;
	}

	@Override
	protected void process(List<Player> chunks) {
		gameEngine.addPlayer(p);
	}

	@Override
	protected void done() {
		ui.update();
	}
	
	

}
