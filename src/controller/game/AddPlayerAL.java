package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import javax.swing.JTextField;

import model.interfaces.GameEngine;
import view.UIPanel;

public class AddPlayerAL implements ActionListener {
	
	private GameEngine gameEngine;
	private JDialog owner;
	
	private AddPlayerWorker task;
	
	public AddPlayerAL(JDialog owner, GameEngine gameEngine, UIPanel ui, JTextField playerName, JTextField points) {
		this.gameEngine = gameEngine;
		this.owner = owner;
		task = new AddPlayerWorker(gameEngine, ui, playerName, points);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			task.execute();
			owner.dispose();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(owner, "Points Not A Number", "Not A Number", 0);
		}
	}
}
