package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controller.game.BetDialogAL;
import controller.game.ChangePlayerAL;
import controller.game.RollAL;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class MainToolBar extends JToolBar {
	private static final long serialVersionUID = -4352341802466235417L;
	
	private JComboBox<Player> players;
	private GameEngine ge;
	private DiceDisplay dd;
	private JButton pb;
	private JButton roll;
	private JButton houseRoll;
	
	public MainToolBar(GameEngine ge, MainPanel mp, DiceDisplay dd, ScorePanel sp) {
		this.ge = ge;
		this.dd = dd;
		roll = new JButton("Roll");
		pb = new JButton("Place Bet");
		houseRoll = new JButton("House Roll");
		players = new JComboBox<Player>();
		
		pb.addActionListener(new BetDialogAL(ge, mp, this, sp, players));
		roll.addActionListener(new RollAL(ge, players));
		players.addActionListener(new ChangePlayerAL(dd, players));
		
		add(pb);
		add(roll);
		add(players);
		add(houseRoll);
		
		setVisible(true);
	}
	
	public void updatePlayers() {
		players.removeAllItems();
		for(Player p : ge.getAllPlayers()) {
			players.addItem(p);
		}
		
		if(ge.getAllPlayers().size()<1) {
			roll.setEnabled(false);
			pb.setEnabled(false);
			houseRoll.setEnabled(false);
			players.setEnabled(false);
		} else {
			roll.setEnabled(true);
			pb.setEnabled(true);
			houseRoll.setEnabled(true);
			players.setEnabled(true);
		}
		
		if(players.getSelectedItem() != null) {
			dd.showDicePanel((Player) players.getSelectedItem());
		}
	}
}
