package view.player;

import javax.swing.JDialog;

import controller.game.CancelDialogAL;
import controller.game.RemovePlayerAL;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;

import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;

public class RemovePlayer extends JDialog {
	private static final long serialVersionUID = -1050677024189306384L;
	
	public RemovePlayer(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, StatusBar sb) {
		setTitle("Remove Player");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setResizable(false);
		setModal(true);
		
		//Struts
		Component topStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_topStrut = new GridBagConstraints();
		gbc_topStrut.gridx = 2;
		gbc_topStrut.gridy = 0;
		add(topStrut, gbc_topStrut);
		
		Component centerStrut = Box.createVerticalStrut(10);
		GridBagConstraints gbc_centerStrut = new GridBagConstraints();
		gbc_centerStrut.gridx = 2;
		gbc_centerStrut.gridy = 2;
		add(centerStrut, gbc_centerStrut);
		
		Component bottomStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_bottomStrut = new GridBagConstraints();
		gbc_bottomStrut.gridx = 2;
		gbc_bottomStrut.gridy = 4;
		add(bottomStrut, gbc_bottomStrut);
		
		Component leftStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_leftStrut = new GridBagConstraints();
		gbc_leftStrut.gridx = 0;
		gbc_leftStrut.gridy = 3;
		add(leftStrut, gbc_leftStrut);
		
		Component rightStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_rightStrut = new GridBagConstraints();
		gbc_rightStrut.gridx = 3;
		gbc_rightStrut.gridy = 3;
		add(rightStrut, gbc_rightStrut);
		
		//Combo Box of all players
		JComboBox<Player> players = new JComboBox<Player>();
		GridBagConstraints gbc_players = new GridBagConstraints();
		gbc_players.gridwidth = 2;
		gbc_players.insets = new Insets(0, 0, 5, 5);
		gbc_players.fill = GridBagConstraints.HORIZONTAL;
		gbc_players.gridx = 1;
		gbc_players.gridy = 1;
		
		for(Player p : gameEngine.getAllPlayers()) {
			players.addItem(p);
		}
		
		add(players, gbc_players);
		
		//Buttons
		JButton cancel = new JButton("Cancel");
		GridBagConstraints gbc_cancel = new GridBagConstraints();
		gbc_cancel.anchor = GridBagConstraints.EAST;
		gbc_cancel.insets = new Insets(0, 0, 5, 5);
		gbc_cancel.gridx = 1;
		gbc_cancel.gridy = 3;
		cancel.addActionListener(new CancelDialogAL(this));
		add(cancel, gbc_cancel);
		
		JButton removePlayer = new JButton("Remove");
		GridBagConstraints gbc_removePlayer = new GridBagConstraints();
		gbc_removePlayer.insets = new Insets(0, 0, 5, 5);
		gbc_removePlayer.gridx = 2;
		gbc_removePlayer.gridy = 3;
		removePlayer.addActionListener(new RemovePlayerAL(this, gameEngine, mp, mmb, sb, players));
		add(removePlayer, gbc_removePlayer);
			
		pack();
	}
	
}
