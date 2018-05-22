package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;

public class RemovePlayerAL implements ActionListener {
	
	private RemovePlayerWorker task;
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	private JComboBox<Player> p;
	private JDialog owner;
	
	public RemovePlayerAL(JDialog owner, GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, JComboBox<Player> p) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.p = p;
		this.owner = owner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RemovePlayerWorker(gameEngine, mp, mmb, (Player) p.getSelectedItem());
		task.execute();
		owner.dispose();
	}

}
