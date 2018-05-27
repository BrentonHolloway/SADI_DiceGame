package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.SwingWorker;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainMenuBar;
import view.MainPanel;
import view.StatusBar;

public class RemovePlayerAL implements ActionListener {
	
	private SwingWorker<Void, String> task;
	private GameEngine gameEngine;
	private MainPanel mp;
	private MainMenuBar mmb;
	private StatusBar sb;
	private JComboBox<Player> p;
	private JDialog owner;
	
	public RemovePlayerAL(JDialog owner, GameEngine gameEngine, MainPanel mp, MainMenuBar mmb, StatusBar sb, JComboBox<Player> p) {
		this.gameEngine = gameEngine;
		this.mp = mp;
		this.mmb = mmb;
		this.sb = sb;
		this.p = p;
		this.owner = owner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		task = new RemovePlayerWorker(gameEngine, mp, mmb, sb, (Player) p.getSelectedItem());
		task.execute();
		owner.dispose();
	}

}
