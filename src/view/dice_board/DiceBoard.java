package view.dice_board;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class DiceBoard extends JPanel {
	private static final long serialVersionUID = -5786950587255241119L;
	private JLabel die1value;
	private JLabel die2value;
	private JLabel playerName;
	public DiceBoard(GameEngine ge, Player p) {
		//setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		
		playerName = new JLabel(p.toString());
		GridBagConstraints gbc_lblPlayername = new GridBagConstraints();
		gbc_lblPlayername.gridwidth = 7;
		gbc_lblPlayername.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayername.gridx = 1;
		gbc_lblPlayername.gridy = 1;
		add(playerName, gbc_lblPlayername);
		
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		JLabel lblDie = new JLabel(new ImageIcon("./images/pair_of_die_6.png"));
		GridBagConstraints gbc_lblDie = new GridBagConstraints();
		gbc_lblDie.gridheight = 2;
		gbc_lblDie.gridwidth = 3;
		gbc_lblDie.insets = new Insets(0, 0, 5, 5);
		gbc_lblDie.gridx = 1;
		gbc_lblDie.gridy = 3;
		add(lblDie, gbc_lblDie);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 3;
		add(horizontalStrut, gbc_horizontalStrut);
		
		JLabel lblDie_1 = new JLabel(new ImageIcon("./images/pair_of_die_6.png"));
		GridBagConstraints gbc_lblDie_1 = new GridBagConstraints();
		gbc_lblDie_1.gridheight = 2;
		gbc_lblDie_1.gridwidth = 3;
		gbc_lblDie_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblDie_1.gridx = 5;
		gbc_lblDie_1.gridy = 3;
		add(lblDie_1, gbc_lblDie_1);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 5;
		add(verticalStrut, gbc_verticalStrut);
		
		die1value = new JLabel(" ");
		GridBagConstraints gbc_lblDievalue = new GridBagConstraints();
		gbc_lblDievalue.insets = new Insets(0, 0, 0, 5);
		gbc_lblDievalue.gridx = 2;
		gbc_lblDievalue.gridy = 6;
		add(die1value, gbc_lblDievalue);
		
		die2value = new JLabel(" ");
		GridBagConstraints gbc_lblDievalue_1 = new GridBagConstraints();
		gbc_lblDievalue_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblDievalue_1.gridx = 6;
		gbc_lblDievalue_1.gridy = 6;
		add(die2value, gbc_lblDievalue_1);
		
//		Insets inset = new Insets(0, 0, 5, 5);
//		
//		//--------- Constraints ---------
//		//Strut Constraints
//		GridBagConstraints strutConstraint = new GridBagConstraints();
//		
//		
//		playerName = new JLabel(p.toString());
//		
//		GridBagConstraints gbc_playerName = new GridBagConstraints();
//		gbc_playerName.gridwidth = 2;
//		gbc_playerName.insets = new Insets(0, 0, 5, 5);
//		gbc_playerName.gridx = 0;
//		gbc_playerName.gridy = 0;
//		add(playerName, gbc_playerName);
//		
//		JLabel die1 = new JLabel("Die1");
//		GridBagConstraints gbc_die1 = new GridBagConstraints();
//		gbc_die1.gridheight = 3;
//		gbc_die1.gridwidth = 3;
//		gbc_die1.insets = new Insets(0, 0, 5, 5);
//		gbc_die1.gridx = 1;
//		gbc_die1.gridy = 2;
//		add(die1, gbc_die1);
//		
//		JLabel die2 = new JLabel("Die2");
//		GridBagConstraints gbc_die2 = new GridBagConstraints();
//		gbc_die2.gridheight = 3;
//		gbc_die2.gridwidth = 4;
//		gbc_die2.insets = new Insets(0, 0, 5, 0);
//		gbc_die2.gridx = 4;
//		gbc_die2.gridy = 2;
//		add(die2, gbc_die2);
//		
//		die1value = new JLabel("-");
//		GridBagConstraints gbc_die1value = new GridBagConstraints();
//		gbc_die1value.insets = new Insets(0, 0, 0, 5);
//		gbc_die1value.gridx = 2;
//		gbc_die1value.gridy = 5;
//		add(die1value, gbc_die1value);
//		
//		die2value = new JLabel("-");
//		GridBagConstraints gbc_die2value = new GridBagConstraints();
//		gbc_die2value.insets = new Insets(0, 0, 0, 5);
//		gbc_die2value.gridx = 5;
//		gbc_die2value.gridy = 5;
//		add(die2value, gbc_die2value);
	}
	
	public void updateDice(String die1, String die2) {
		die1value.setText(die1);
		die2value.setText(die2);
	}
	
	public void setPlayerName(String name) {
		playerName.setText(name);
	}
}
