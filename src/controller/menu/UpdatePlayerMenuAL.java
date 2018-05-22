package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.UpdatePlayer;

public class UpdatePlayerMenuAL implements ActionListener{
	
	private GameEngine gameEngine;
	
	public UpdatePlayerMenuAL(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog up = new UpdatePlayer(gameEngine);
		up.setVisible(true);
		
	}

}
