package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;

public class RollAL implements ActionListener {
	
	private SwingWorker<Void, Player> task;
	private GameEngine ge;
	private JComboBox<Player> players;
	private DiceDisplay dd;
	
	public RollAL(GameEngine ge, JComboBox<Player> players, DiceDisplay dd) {
		this.ge = ge;
		this.players = players;
		this.dd = dd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RollWorker(ge, (Player) players.getSelectedItem());
		dd.showDicePanel(((Player) players.getSelectedItem()).toString());
		task.execute();
	}

}
