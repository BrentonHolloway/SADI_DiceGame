package view;

import javax.swing.JDialog;
import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JTextPane;

import controller.game.CancelDialogAL;

public class Descriptor extends JDialog {
	private static final long serialVersionUID = 383050409321781593L;
	public Descriptor(Component c, String title, String description) {
		setTitle(title);
		setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(c);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setMinimumSize(new Dimension(500, 300));
		
		
		JTextPane txtpnJtextpane = new JTextPane();
		Component horizontalGlue = Box.createHorizontalGlue();
		JButton close = new JButton("Close");
		
		txtpnJtextpane.setText(description);
		txtpnJtextpane.setEditable(false);
		
		close.addActionListener(new CancelDialogAL(this));
		
		add(horizontalGlue, BorderLayout.SOUTH);
		add(close, BorderLayout.SOUTH);
		add(txtpnJtextpane, BorderLayout.CENTER);
	}

}
