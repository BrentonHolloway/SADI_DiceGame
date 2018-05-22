package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;

public class RemovePlayerAL implements ActionListener {
	
	private RemovePlayerWorker task;
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	
	public RemovePlayerAL(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	}

}
