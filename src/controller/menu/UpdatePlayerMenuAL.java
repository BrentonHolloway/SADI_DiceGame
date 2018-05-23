package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainPanel;
import view.UpdatePlayer;

public class UpdatePlayerMenuAL implements ActionListener{
	
	private GameEngine gameEngine;
	private MainPanel mp;
	
	public UpdatePlayerMenuAL(GameEngine gameEngine, MainPanel mp) {
		this.gameEngine = gameEngine;
		this.mp = mp;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog up = new UpdatePlayer(gameEngine, mp);
		up.setVisible(true);
		
	}

}
