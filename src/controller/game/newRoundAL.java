package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainToolBar;
import view.StatusBar;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class newRoundAL implements ActionListener {
	
	private newRoundWorker task;
	private GameEngine ge;
	private ScorePanel sp;
	private DiceDisplay dd;
	private MainToolBar mtb;
	private StatusBar sb;
	
	public newRoundAL(GameEngine ge, ScorePanel sp, DiceDisplay dd, MainToolBar mtb, StatusBar sb) {
		this.ge = ge;
		this.sp = sp;
		this.dd = dd;
		this.mtb = mtb;
		this.sb = sb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		dd.hideDicePanel();
		mtb.setEnabled(true);
		mtb.setNewRound(false);
		task = new newRoundWorker(ge, sp, dd, sb);
		task.execute();
	}

}
