package view.dice_board;

import java.awt.Color;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.GridLayout;
import java.util.HashMap;

import javax.swing.JLabel;

public class DiceBoard extends JPanel {
	private static final long serialVersionUID = -5786950587255241119L;
	private JLabel die1value;
	private JLabel die2value;
	private JLabel playerName;
	public DiceBoard(GameEngine ge, Player p) {
		setBackground(Color.WHITE);
		setLayout(new GridLayout(1, 2, 0, 0));
		
		playerName = new JLabel(p.toString());
		JLabel die1 = new JLabel("Die1");
		JLabel die2 = new JLabel("Die2");
		die1value = new JLabel("-");
		die2value = new JLabel("-");
		
		add(playerName);
		add(die1);
		add(die2);
		add(die1value);
		add(die2value);
	}
	
	public void updateDice(String die1, String die2) {
		die1value.setText(die1);
		die2value.setText(die2);
	}
	
	public void setPlayerName(String name) {
		playerName.setText(name);
	}
}
