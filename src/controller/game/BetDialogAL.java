package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;
import view.StatusBar;
import view.player.BetDialog;
import view.score_board.ScorePanel;

public class BetDialogAL implements ActionListener {
	
	private GameEngine ge;
	private MainPanel mp;
	private ScorePanel sp;
	private StatusBar sb;
	private JComboBox<Player> p;
	
	public BetDialogAL(GameEngine ge, MainPanel mp, ScorePanel sp, StatusBar sb, JComboBox<Player> p) {
		this.ge = ge;
		this.mp = mp;
		this.sp = sp;
		this.sb = sb;
		this.p = p;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog bet = new BetDialog(ge, mp, sp, sb, (Player) p.getSelectedItem());
		bet.setVisible(true);
	}

}
