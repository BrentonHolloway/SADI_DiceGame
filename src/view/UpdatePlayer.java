package view;

import javax.swing.JDialog;
import javax.swing.JTabbedPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.BorderLayout;


public class UpdatePlayer extends JDialog {
	private static final long serialVersionUID = 2346069702958679341L;
	
	public UpdatePlayer(GameEngine gameEngine, MainPanel mp) {
		setTitle("Update Player");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		add(tabbedPane, BorderLayout.CENTER);
		
		for(Player p: gameEngine.getAllPlayers()) {
			tabbedPane.add(p.toString(), new UpdatePlayerPanel(this, gameEngine, mp, p));
		}
		pack();
	}

}
