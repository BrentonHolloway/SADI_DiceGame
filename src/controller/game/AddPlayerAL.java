package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;

public class AddPlayerAL implements ActionListener {
	private JDialog owner;
	
	private AddPlayerWorker task;
	
	public AddPlayerAL(JDialog owner, GameEngine gameEngine, MainPanel ui, MainMenuBar mmb, JTextField playerName, JTextField points) {
		this.owner = owner;
		task = new AddPlayerWorker(gameEngine, ui, mmb, playerName, points);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
			task.execute();
			owner.dispose();
		
	}
}
