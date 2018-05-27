package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;
import view.player.RemovePlayer;

public class RemovePlayerMenuAL implements ActionListener {
	
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	private StatusBar sb;
	
	public RemovePlayerMenuAL(GameEngine gameEngine,  MainPanel mp, MainMenuBar mmb, StatusBar sb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog rp = new RemovePlayer(gameEngine,mp,mmb, sb);
		rp.setVisible(true);

	}

}
