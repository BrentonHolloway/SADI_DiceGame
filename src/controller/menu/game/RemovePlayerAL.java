package controller.menu.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.RemovePlayer;

public class RemovePlayerAL implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog rp = new RemovePlayer();
		rp.setVisible(true);

	}

}
