package view.dice_board;

import java.awt.CardLayout;
import java.util.Map;

import javax.swing.JPanel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

public class DiceDisplay extends JPanel {
	private static final long serialVersionUID = -2016345827366227570L;
	private Map<Player, DicePanel> playerDice;
	public DiceDisplay(GameEngine ge) {
		setLayout(new CardLayout());
	}
}
