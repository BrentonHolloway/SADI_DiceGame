package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class RollAL implements ActionListener {
	
	private SwingWorker<Void, Player> task;
	private GameEngine ge;
	private JComboBox<Player> players;
	
	public RollAL(GameEngine ge, JComboBox<Player> players) {
		this.ge = ge;
		this.players = players;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RollWorker(ge, (Player) players.getSelectedItem());
		task.execute();
	}

}
