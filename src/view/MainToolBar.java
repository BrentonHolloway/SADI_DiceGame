package view;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainToolBar extends JToolBar {
	private static final long serialVersionUID = -4352341802466235417L;
	
	private JComboBox<Player> players;
	private GameEngine gameEngine;
	private JPanel mainPanel;
	
	public MainToolBar(GameEngine gameEngine, JPanel mainPanel) {
		this.gameEngine = gameEngine;
		this.mainPanel = mainPanel;
		JButton roll = new JButton("Roll");
		JButton pb = new JButton("Place Bet");
		JButton houseRoll = new JButton("House Roll");
		players = new JComboBox<Player>();
		
		add(pb);
		add(roll);
		add(players);
		add(houseRoll);
		
		setVisible(true);
	}
	
	public void updatePlayers() {
		players.removeAllItems();
		for(Player p : gameEngine.getAllPlayers()) {
			players.addItem(p);
		}
	}
}
