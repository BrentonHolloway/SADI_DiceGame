package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.AddPlayer;


public class AddPlayerAL implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog addP = new AddPlayer();
		addP.setVisible(true);
		
	}
	
}
