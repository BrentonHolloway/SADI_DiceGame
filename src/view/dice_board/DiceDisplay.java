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
	private Map<String, DicePanel> playerDice;
	private JPanel cards;
	
	public DiceDisplay(GameEngine ge) {
		this.ge = ge;
		setLayout(new GridLayout(1, 1));
		setBackground(Color.WHITE);
		playerDice = new HashMap<String, DicePanel>();
		
		cards = new JPanel(new CardLayout());
		cards.setBackground(Color.WHITE);
		
		DicePanel db = new DicePanel(ge, "House");
		playerDice.put("House", db);
		cards.add("House", db);
		
		add(cards);
		cards.setVisible(false);
	}
	
	public void addDiceBoard(Player p) {
		DicePanel db = new DicePanel(ge, p.getPlayerName());
		playerDice.put(p.toString(), db);
		cards.add(p.toString(), db);
		cards.setVisible(true);
	}
	
	public void removeDiceBoard(Player p) {
		playerDice.remove(p.toString());
		if(ge.getAllPlayers().size() < 1) {
			cards.setVisible(false);
		}
	}
	
	public void showDicePanel(String id) {
		CardLayout c = (CardLayout)cards.getLayout();
		c.show(cards, id);
	}
	
	public void updateDicePanel(String id, String die1, String die2) {
		playerDice.get(id).updateDice(die1, die2);
	}
	
}
