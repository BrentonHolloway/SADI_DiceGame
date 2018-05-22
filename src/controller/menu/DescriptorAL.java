package controller.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDialog;

import view.Descriptor;

public class DescriptorAL implements ActionListener {
	
	String title;
	String description;
	
	public DescriptorAL(String title, String description) {
		this.title = title;
		this.description = description;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JDialog help = new Descriptor(title, description);
		help.setVisible(true);
	}

}
