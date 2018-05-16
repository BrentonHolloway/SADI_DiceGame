package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.AddPlayerDialog;
import view.MainPanel;


public class AddPlayerMenuAL implements ActionListener {
	
	GameEngine gameEngine;
	MainPanel mp;

	public AddPlayerMenuAL(GameEngine gameEngine, MainPanel mp) {
		this.gameEngine = gameEngine;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog addP = new AddPlayerDialog(gameEngine, mp);
		addP.setVisible(true);
		
	}
	
}
