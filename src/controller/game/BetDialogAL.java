package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;
import view.MainToolBar;
import view.player.BetDialog;
import view.score_board.ScorePanel;

public class BetDialogAL implements ActionListener {
	
	private GameEngine ge;
	private MainToolBar mtb;
	private MainPanel mp;
	private ScorePanel sp;
	private JComboBox<Player> p;
	
	public BetDialogAL(GameEngine ge, MainPanel mp, MainToolBar mtb, ScorePanel sp, JComboBox<Player> p) {
		this.ge = ge;
		this.mp = mp;
		this.mtb = mtb;
		this.sp = sp;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog bet = new BetDialog(ge, mp, mtb, sp, (Player) p.getSelectedItem());
		bet.setVisible(true);
	}

}
