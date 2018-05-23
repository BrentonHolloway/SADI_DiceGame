package controller.menu;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.Descriptor;

public class DescriptorAL implements ActionListener {
	
	private String title;
	private String description;
	private Component c;
	
	public DescriptorAL(Component c, String title, String description) {
		this.title = title;
		this.description = description;
		this.c = c;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog help = new Descriptor(c, title, description);
		help.setVisible(true);
	}

}
