package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.StatusBar;
import view.dice_board.DiceDisplay;

public class RollAL implements ActionListener {
	
	private SwingWorker<Void, String> task;
	private GameEngine ge;
	private JComboBox<Player> players;
	private DiceDisplay dd;
	private StatusBar sb;
	
	public RollAL(GameEngine ge, JComboBox<Player> players, DiceDisplay dd, StatusBar sb) {
		this.ge = ge;
		this.players = players;
		this.dd = dd;
		this.sb = sb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RollWorker(ge, sb, (Player) players.getSelectedItem());
		dd.showDicePanel(((Player) players.getSelectedItem()).toString());
		task.execute();
	}

}
