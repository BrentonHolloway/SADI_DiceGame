package controller.game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

public class CancelDialogAL implements ActionListener {
	private JDialog owner;
	
	public CancelDialogAL(JDialog owner) {
		this.owner = owner;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		owner.dispose();
	}

}
