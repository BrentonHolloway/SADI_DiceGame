package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JPanel;

import model.interfaces.GameEngine;
import view.AddPlayerDialog;
import view.MainPanel;


public class AddPlayerAL implements ActionListener {
	
	GameEngine gameEngine;
	JPanel mp;

	public AddPlayerAL(GameEngine gameEngine, JPanel mp) {
		this.gameEngine = gameEngine;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog addP = new AddPlayerDialog(gameEngine, mp);
		addP.setVisible(true);
		
	}
	
}
