package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import model.SimplePlayer;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;

public class AddPlayer implements ActionListener {
	
	private GameEngine gameEngine;
	private JTextField playerName;
	private JTextField points;
	private MainPanel mp;
	private JDialog owner;
	
	public AddPlayer(JDialog owner, GameEngine gameEngine, JPanel mp, JTextField playerName, JTextField points) {
		this.gameEngine = gameEngine;
		this.playerName = playerName;
		this.points = points;
		this.mp = (MainPanel) mp;
		this.owner = owner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try {
			final Player p = new SimplePlayer(String.valueOf(gameEngine.getAllPlayers().size()+1), playerName.getText(), Integer.parseInt(points.getText()));
			new Thread() {
				@Override public void run() {
					gameEngine.addPlayer(p);
					mp.updatePlayers();
				}
			}.start();
			
			owner.dispose();
		}catch(Exception ex) {
			JOptionPane.showMessageDialog(owner, "Points Not A Number", "Not A Number", 0);
		}
	}
}
