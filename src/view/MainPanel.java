package view;

import java.awt.BorderLayout;


import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = -8170814423728632014L;
	
	GameEngine gameEngine;
	JLabel players;
	
	public MainPanel(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		setLayout(new BorderLayout());
		players = new JLabel("No Players");
		add(players);
		
		setVisible(true);
	}

	public void update() {
		String playersS = null;
		
		for(Player p : gameEngine.getAllPlayers()) {
			playersS = playersS + "ID: " + p.getPlayerId() + " Name: " + p.getPlayerName() + " Points: " + p.getPoints() + "\n";
		}
		final String fpls = playersS;
		
		SwingUtilities.invokeLater(new Runnable() {
			@Override public void run() {
				players.setText(fpls);
			}
		});
		
	}
}
