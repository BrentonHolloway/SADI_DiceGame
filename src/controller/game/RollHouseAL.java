package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;

public class RollHouseAL implements ActionListener {
	
	private SwingWorker<Void, Player> task;
	private GameEngine ge;
	private DiceDisplay dd;
	
	public RollHouseAL(GameEngine ge, DiceDisplay dd) {
		this.ge = ge;
		this.dd = dd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RollHouseWorker(ge, dd);
		task.execute();
	}

}
