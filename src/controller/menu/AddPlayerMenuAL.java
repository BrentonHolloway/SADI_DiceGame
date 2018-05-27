package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;
import view.player.AddPlayerDialog;


public class AddPlayerMenuAL implements ActionListener {
	
	GameEngine gameEngine;
	MainPanel mp;
	MainMenuBar mmb;
	StatusBar sb;

	public AddPlayerMenuAL(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, StatusBar sb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog addP = new AddPlayerDialog(gameEngine, mp, mmb, sb);
		addP.setVisible(true);
		
	}
	
}
