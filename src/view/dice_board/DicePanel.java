package view.dice_board;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

import java.awt.Insets;

import javax.swing.JLabel;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;

public class DicePanel extends JPanel {
	private static final long serialVersionUID = -5786950587255241119L;
	private JLabel die1value;
	private JLabel die2value;
	private JLabel playerName;
	public DicePanel(GameEngine ge, String pn) {
		setBackground(Color.WHITE);
		setLayout(new GridBagLayout());
		
		//--------- Constraints ---------
		//Strut Constraints
		GridBagConstraints gbc_lblPlayername = new GridBagConstraints();
		gbc_lblPlayername.gridwidth = 7;
		gbc_lblPlayername.insets = new Insets(0, 0, 5, 5);
		gbc_lblPlayername.gridx = 1;
		gbc_lblPlayername.gridy = 1;
		
		GridBagConstraints gbc_lblDie = new GridBagConstraints();
		gbc_lblDie.gridheight = 2;
		gbc_lblDie.gridwidth = 3;
		gbc_lblDie.insets = new Insets(0, 0, 5, 5);
		gbc_lblDie.gridx = 1;
		gbc_lblDie.gridy = 3;
		
		GridBagConstraints gbc_lblDie_1 = new GridBagConstraints();
		gbc_lblDie_1.gridheight = 2;
		gbc_lblDie_1.gridwidth = 3;
		gbc_lblDie_1.insets = new Insets(0, 0, 5, 0);
		gbc_lblDie_1.gridx = 5;
		gbc_lblDie_1.gridy = 3;
		
		GridBagConstraints gbc_verticalStrut = new GridBagConstraints();
		gbc_verticalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut.gridx = 1;
		gbc_verticalStrut.gridy = 5;
		
		GridBagConstraints gbc_lblDievalue = new GridBagConstraints();
		gbc_lblDievalue.insets = new Insets(0, 0, 0, 5);
		gbc_lblDievalue.gridx = 2;
		gbc_lblDievalue.gridy = 6;
		
		GridBagConstraints gbc_verticalStrut_1 = new GridBagConstraints();
		gbc_verticalStrut_1.insets = new Insets(0, 0, 5, 5);
		gbc_verticalStrut_1.gridx = 1;
		gbc_verticalStrut_1.gridy = 2;
		
		GridBagConstraints gbc_horizontalStrut = new GridBagConstraints();
		gbc_horizontalStrut.insets = new Insets(0, 0, 5, 5);
		gbc_horizontalStrut.gridx = 4;
		gbc_horizontalStrut.gridy = 3;
		
		GridBagConstraints gbc_lblDievalue_1 = new GridBagConstraints();
		gbc_lblDievalue_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblDievalue_1.gridx = 6;
		gbc_lblDievalue_1.gridy = 6;
		
		//--------- Struts ---------
		Component verticalStrut_1 = Box.createVerticalStrut(20);
		add(verticalStrut_1, gbc_verticalStrut_1);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		add(horizontalStrut, gbc_horizontalStrut);
		
		Component verticalStrut = Box.createVerticalStrut(20);
		add(verticalStrut, gbc_verticalStrut);
		
		playerName = new JLabel(pn);
		add(playerName, gbc_lblPlayername);
		
		JLabel lblDie = new JLabel(new ImageIcon("./images/pair_of_die_6.png")); //Dice by Marco Livolsi from the Noun Project
		add(lblDie, gbc_lblDie);
		
		JLabel lblDie_1 = new JLabel(new ImageIcon("./images/pair_of_die_6.png")); //Dice by Marco Livolsi from the Noun Project
		add(lblDie_1, gbc_lblDie_1);
		
		die1value = new JLabel(" ");
		add(die1value, gbc_lblDievalue);
		
		die2value = new JLabel(" ");
		add(die2value, gbc_lblDievalue_1);
	}
	
	public void updateDice(String die1, String die2) {
		die1value.setText(die1);
		die2value.setText(die2);
	}
	
	public void setPlayerName(String name) {
		playerName.setText(name);
	}
}
