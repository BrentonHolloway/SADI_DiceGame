package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;
import view.StatusBar;

public class UpdatePlayerAL implements ActionListener {
	
	private UpdatePlayerWorker task;
	private GameEngine gameEngine;
	private MainPanel mp;
	private Player p;
	private StatusBar sb;
	private JTextField playerName;
	private JTextField points;
	private JDialog owner;
	
	public UpdatePlayerAL(JDialog owner, GameEngine gameEngine, MainPanel mp, StatusBar sb, Player p, JTextField playerName, JTextField points) {
		this.owner = owner;
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.p = p;
		this.sb = sb;
		this.playerName = playerName;
		this.points = points;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new UpdatePlayerWorker(gameEngine, mp, sb, p, playerName.getText(), Integer.parseInt(points.getText()));
		task.execute();
		owner.dispose();
	}
}
