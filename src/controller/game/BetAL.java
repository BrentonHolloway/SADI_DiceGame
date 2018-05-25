package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainToolBar;
import view.score_board.ScorePanel;

public class BetAL implements ActionListener{
	
	private SwingWorker<Void, Player> task;
	private GameEngine ge;
	private ScorePanel sp;
	private MainToolBar mtb;
	private Player p;
	private JDialog owner;
	private JTextField bet;
	
	public BetAL(JDialog owner, GameEngine ge, MainToolBar mtb, ScorePanel sp, Player p, JTextField bet) {
		this.ge = ge;
		this.sp = sp;
		this.mtb = mtb;
		this.p = p;
		this.owner = owner;
		this.bet = bet;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		task = new BetWorker(ge, mtb, sp, p, Integer.parseInt(bet.getText()));
		task.execute();
		owner.dispose();
	}
}
