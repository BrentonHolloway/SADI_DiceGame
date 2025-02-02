package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import view.MainToolBar;
import view.StatusBar;
import view.dice_board.DiceDisplay;

public class RollHouseAL implements ActionListener {
	
	private SwingWorker<Void, String> task;
	private GameEngine ge;
	private DiceDisplay dd;
	private MainToolBar mtb;
	private StatusBar sb;
	
	public RollHouseAL(GameEngine ge, DiceDisplay dd, MainToolBar mtb, StatusBar sb) {
		this.ge = ge;
		this.dd = dd;
		this.mtb = mtb;
		this.sb = sb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		int cont = JOptionPane.showConfirmDialog(null, "Are you sure you want the house to roll?");
		if(cont == JOptionPane.YES_OPTION){
			mtb.setEnabled(false);
			mtb.setNewRound(true);
			task = new RollHouseWorker(ge, dd, sb, mtb);
			task.execute();
		}
	}

}
