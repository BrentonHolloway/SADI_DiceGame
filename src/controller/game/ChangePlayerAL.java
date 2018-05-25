package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.interfaces.Player;
import view.dice_board.DiceDisplay;

public class ChangePlayerAL implements ActionListener{
	
	private DiceDisplay dd;
	private JComboBox<Player> players;
	
	public ChangePlayerAL(DiceDisplay dd, JComboBox<Player> players) {
		this.dd = dd;
		this.players = players;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(players.getSelectedIndex() != -1) {
			dd.showDicePanel((Player) players.getSelectedItem()); 
		}
	}

}
