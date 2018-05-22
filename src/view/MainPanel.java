package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = -8170814423728632014L;
	
	private GameEngine gameEngine;
	private MainToolBar tb;
	private ArrayList<DicePanel> playerDice;
	private DicePanel currDicePanel = null;
	
	public MainPanel(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		setLayout(new BorderLayout());
		tb = new MainToolBar(gameEngine, this);
		DicePanel dicePanel = new DicePanel();
		ScorePanel scorePanel = new ScorePanel();
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scorePanel, currDicePanel);
		
		add(tb, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		setVisible(true);
		update();
	}

	public void update() {
		tb.updatePlayers();
	}
	
	public void updatePlayers() {
		for(Player p : gameEngine.getAllPlayers()) {
			
		}
	}
}
