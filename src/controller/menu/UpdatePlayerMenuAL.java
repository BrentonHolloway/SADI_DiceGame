package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainPanel;
import view.StatusBar;
import view.player.UpdatePlayer;

public class UpdatePlayerMenuAL implements ActionListener{
	
	private GameEngine gameEngine;
	private MainPanel mp;
	private StatusBar sb;
	
	public UpdatePlayerMenuAL(GameEngine gameEngine, MainPanel mp, StatusBar sb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.sb = sb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog up = new UpdatePlayer(gameEngine, mp, sb);
		up.setVisible(true);
		
	}

}
