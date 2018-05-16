package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;

import view.RemovePlayer;

public class RemovePlayerMenuAL implements ActionListener {
	
	private GameEngine gameEngine;
	
	public RemovePlayerMenuAL(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog rp = new RemovePlayer(gameEngine);
		rp.setVisible(true);

	}

}
