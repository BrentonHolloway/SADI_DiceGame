package view;

import javax.swing.JPanel;
import javax.swing.BoxLayout;
import javax.swing.JLabel;

public class StatusBar extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7960319300551657388L;

	public StatusBar() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		JLabel player = new JLabel("No Players Added");
		add(player);
	}
}
