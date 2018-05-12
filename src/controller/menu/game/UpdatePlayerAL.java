package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.UpdatePlayer;

public class UpdatePlayerAL implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog up = new UpdatePlayer();
		up.setVisible(true);
		
	}

}
