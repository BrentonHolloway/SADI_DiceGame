package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import view.MainPanel;

public class AddPlayerAL implements ActionListener {
	
	private GameEngine gameEngine;
	private JDialog owner;
	
	private AddPlayerWorker task;
	
	public AddPlayerAL(JDialog owner, GameEngine gameEngine, MainPanel ui, JTextField playerName, JTextField points) {
		this.gameEngine = gameEngine;
		this.owner = owner;
		task = new AddPlayerWorker(gameEngine, ui, playerName, points);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			task.execute();
			owner.dispose();
		
	}
}
