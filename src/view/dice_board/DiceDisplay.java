package view.dice_board;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DiceDisplay extends JPanel {
	private static final long serialVersionUID = -2016345827366227570L;
	private GameEngine ge;
	private Map<Player, DiceBoard> playerDice;
	JPanel cards;
	
	public DiceDisplay(GameEngine ge) {
		this.ge = ge;
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);
		playerDice = new HashMap<Player, DiceBoard>();
		
		
		cards = new JPanel(new CardLayout());
		cards.setBackground(Color.WHITE);
		
		add(cards);
	}
	
	public void updateDiceBoard() {
		playerDice.clear();
		cards.removeAll();
		for(Player p : ge.getAllPlayers()) {
			addDiceBoard(p);
		}
	}
	
	public void addDiceBoard(Player p) {
		DiceBoard db = new DiceBoard(ge, p);
		playerDice.put(p, db);
		cards.add(p.toString(), db);
	}
	
	public void removeDiceBoard(Player p) {
		cards.remove(playerDice.get(p));
		playerDice.remove(p);
	}
	
	public void showDicePanel(Player p) {
		CardLayout c = (CardLayout)cards.getLayout();
		c.show(cards, p.toString());
	}
	
	public void updateDicePanel(Player p, String die1, String die2) {
		playerDice.get(p).updateDice(die1, die2);
	}
	
	public void showHouseDicePanel() {
		DiceBoard db = new DiceBoard(ge, null);
		db.setPlayerName("House");
		playerDice.put(null, db);
		cards.add("", db);
	}
	
	public void updateHouseDicePanel(String die1, String die2) {
		playerDice.get(null).updateDice(die1, die2);
	}
}
