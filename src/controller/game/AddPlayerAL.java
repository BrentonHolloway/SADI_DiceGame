package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import javax.swing.JTextField;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;

public class AddPlayerAL implements ActionListener {
	
	private SwingWorker<Void, String> task;
	private JDialog owner;
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	private JTextField playerName;
	private JTextField points;
	private StatusBar sb;
	
	
	public AddPlayerAL(JDialog owner, GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, StatusBar sb, JTextField playerName, JTextField points) {
		this.owner = owner;
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
		this.playerName = playerName;
		this.points = points;
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new AddPlayerWorker(gameEngine, mp, mmb, sb, playerName.getText(), Integer.parseInt(points.getText()));
		task.execute();
		owner.dispose();
		
	}
}
