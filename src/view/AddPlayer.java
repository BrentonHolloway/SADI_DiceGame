package view;

import javax.swing.JDialog;
import javax.swing.JFrame;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.FlowLayout;



public class AddPlayer extends JDialog {
	private static final long serialVersionUID = -1701323917859373346L;
	private JTextField txtPoints;
	private JTextField txtFullName;
	
	public AddPlayer() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());
		
		JLabel lblPlayerName = new JLabel("Player Name: ");
		
		txtFullName = new JTextField();
		txtFullName.setText("Full Name");
		txtFullName.setColumns(20);
		
		JLabel lblAccountBalance = new JLabel("Account Balance: ");
		
		txtPoints = new JTextField();
		txtPoints.setText("Points");
		txtPoints.setColumns(10);
		
		JButton btnCancel = new JButton("Cancel");		
		JButton btnPlayer = new JButton("Add Player");

		add(lblPlayerName);
		add(txtFullName);
		add(lblAccountBalance);
		add(txtPoints);
		add(btnCancel);
		add(btnPlayer);
	}
}
