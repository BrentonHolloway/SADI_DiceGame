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
	private ScorePanel scorePanel;
	
	public MainPanel(GameEngine ge) {
		setLayout(new BorderLayout());
		
		
		diceDisplay = new DiceDisplay(ge);
		
		scorePanel = new ScorePanel(ge, diceDisplay);
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
	}
	
	public void addDisplay(Player p) {
		diceDisplay.addDiceBoard(p);
	}
	
	public void removeDisplay(Player p) {
		diceDisplay.removeDiceBoard(p);
	}
	
	public void updateInterRoll(String id, int dice1, int dice2) {
		diceDisplay.updateDicePanel(id, String.valueOf(dice1), String.valueOf(dice2));
	}
	
	public void updateFinalRoll(String id, int dice1, int dice2) {
		diceDisplay.updateDicePanel(id, String.valueOf(dice1), String.valueOf(dice2));
		scorePanel.update();
	}
	
	public void updateHouseFinalRoll(String id, int dice1, int dice2) {
		diceDisplay.updateDicePanel(id, String.valueOf(dice1), String.valueOf(dice2));
		scorePanel.finalUpdate(dice1+dice2);
	}
	
	public void newRound(boolean v) {
		tb.setNewRoundEnabled(true);
	}
}
