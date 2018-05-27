package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainToolBar;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class newRoundAL implements ActionListener {
	
	private newRoundWorker task;
	private GameEngine ge;
	private ScorePanel sp;
	private DiceDisplay dd;
	private MainToolBar mtb;
	
	public newRoundAL(GameEngine ge, ScorePanel sp, DiceDisplay dd, MainToolBar mtb) {
		this.ge = ge;
		this.sp = sp;
		this.dd = dd;
		this.mtb = mtb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dd.hideDicePanel();
		mtb.setEnabled(true);
		mtb.setNewRound(false);
		task = new newRoundWorker(ge, sp, dd);
		task.execute();
	}

}
