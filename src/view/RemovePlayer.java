package view;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import java.awt.BorderLayout;

public class RemovePlayer extends JDialog {
	private static final long serialVersionUID = -1050677024189306384L;
	
	public RemovePlayer() {
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		JPanel panel1 = new JPanel();
		JPanel panel2 = new JPanel();
		
		placePanelComponents(panel1, "Player 1", 167.34);
		placePanelComponents(panel2, "Player 2", 15.23);
		
		tabbedPane.addTab("Player 1", panel1);
		tabbedPane.addTab("Player 2", panel2);
		
		getContentPane().add(tabbedPane, BorderLayout.CENTER);
	}
	
	public void placePanelComponents(JPanel panel, String playerName, Double accountBalance) {
		JLabel labelName = new JLabel("Name: ");
		JLabel labelBalance = new JLabel("Account Balance: ");
		
		JLabel name = new JLabel(playerName);
		JLabel balance = new JLabel(accountBalance.toString());
		
		panel.add(labelName);
		panel.add(name);
		
		panel.add(labelBalance);
		panel.add(balance);
		
		
	}
	
	
	
}
