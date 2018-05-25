package view;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JSplitPane;

import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.dice_board.DiceDisplay;
import view.score_board.ScorePanel;

public class MainPanel extends JPanel{
	private static final long serialVersionUID = -8170814423728632014L;
	
	private MainToolBar tb;
	
	private DiceDisplay diceDisplay;
	ScorePanel scorePanel;
	
	public MainPanel(GameEngine ge) {
		setLayout(new BorderLayout());
		
		
		diceDisplay = new DiceDisplay(ge);
		
		scorePanel = new ScorePanel(ge);
		tb = new MainToolBar(ge, this, diceDisplay, scorePanel);
		
		JSplitPane sp = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scorePanel, diceDisplay);
		
		add(tb, BorderLayout.NORTH);
		add(sp, BorderLayout.CENTER);
		
		setVisible(true);
		update();
	}

	public void update() {
		tb.updatePlayers();
		scorePanel.update();
		diceDisplay.updateDiceBoard();
	}
	
	public void updateInterPlayerRoll(Player p, int dice1, int dice2) {
		diceDisplay.updateDicePanel(p, String.valueOf(dice1), String.valueOf(dice2));
	}
	
	public void updateFinalPlayerRoll(Player p, int dice1, int dice2) {
		diceDisplay.updateDicePanel(p, String.valueOf(dice1), String.valueOf(dice2));
	}
	
	public void updateInterHouseRoll(int dice1, int dice2) {
		diceDisplay.updateHouseDicePanel(String.valueOf(dice1), String.valueOf(dice2));
	}
	
	public void updateFinalHouseRoll(int dice1, int dice2) {
		diceDisplay.updateHouseDicePanel(String.valueOf(dice1), String.valueOf(dice2));
	}
}
