package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

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
	
	private DiceDisplay diceDisplay;
	
	public MainPanel(GameEngine ge) {
		this.gameEngine = ge;
		setLayout(new BorderLayout());
		
		tb = new MainToolBar(ge, this);
		diceDisplay = new DiceDisplay(ge);
		
		ScorePanel scorePanel = new ScorePanel();
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scorePanel, diceDisplay);
		
		add(tb, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		setVisible(true);
		update();
	}

	public void update() {
		tb.updatePlayers();
	}
}
