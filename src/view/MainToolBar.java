package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JToolBar;

import controller.game.BetDialogAL;
import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainToolBar extends JToolBar {
	private static final long serialVersionUID = -4352341802466235417L;
	
	private JComboBox<Player> players;
	private GameEngine ge;
	private JButton pb;
	private JButton roll;
	private JButton houseRoll;
	
	public MainToolBar(GameEngine ge, MainPanel mp) {
		this.ge = ge;
		roll = new JButton("Roll");
		pb = new JButton("Place Bet");
		houseRoll = new JButton("House Roll");
		players = new JComboBox<Player>();
		
		pb.addActionListener(new BetDialogAL(ge, mp, this, players));
		
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
	}
}
