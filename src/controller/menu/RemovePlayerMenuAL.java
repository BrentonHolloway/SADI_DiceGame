package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;
import view.player.RemovePlayer;

public class RemovePlayerMenuAL implements ActionListener {
	
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	
	public RemovePlayerMenuAL(GameEngine gameEngine,  MainPanel mp, MainMenuBar mmb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog rp = new RemovePlayer(gameEngine,mp,mmb);
		rp.setVisible(true);

	}

}
