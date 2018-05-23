package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;

public class UpdatePlayerAL implements ActionListener {
	
	private UpdatePlayerWorker task;
	private GameEngine gameEngine;
	private MainPanel mp;
	private Player p;
	private JTextField playerName;
	private JTextField points;
	private JDialog owner;
	
	public UpdatePlayerAL(JDialog owner, GameEngine gameEngine, MainPanel mp, Player p, JTextField playerName, JTextField points) {
		this.owner = owner;
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.p = p;
		this.playerName = playerName;
		this.points = points;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new UpdatePlayerWorker(gameEngine, mp, p, playerName.getText(), Integer.parseInt(points.getText()));
		task.execute();
		owner.dispose();
	}
}
