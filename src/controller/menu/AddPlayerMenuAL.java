package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.AddPlayerDialog;
import view.MainMenuBar;
import view.MainPanel;


public class AddPlayerMenuAL implements ActionListener {
	
	GameEngine gameEngine;
	MainPanel mp;
	MainMenuBar mmb;

	public AddPlayerMenuAL(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog addP = new AddPlayerDialog(gameEngine, mp, mmb);
		addP.setVisible(true);
		
	}
	
}
