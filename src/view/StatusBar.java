package view;

import javax.swing.JPanel;

import model.interfaces.GameEngine;

import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class StatusBar extends JPanel {
	private static final long serialVersionUID = -7960319300551657388L;
	
	private JLabel info;
	
	public StatusBar(GameEngine gameEngine) {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		info = new JLabel("No Players Added");
		add(info);
	}
	
	public void update(String message) {
		info.setText(message);
	}
}
