package view.player;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controller.game.AddPlayerAL;
import controller.game.CancelDialogAL;
import model.interfaces.GameEngine;
import view.MainMenuBar;
import view.MainPanel;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;


public class AddPlayerDialog extends JDialog {
	private static final long serialVersionUID = -1701323917859373346L;
	private JTextField pointsTextInput;
	private JTextField nameTextInput;
	
	public AddPlayerDialog(GameEngine gameEngine, MainPanel mp, MainMenuBar mmb) {
		setTitle("Add Player");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(mp);
		setLayout(new GridBagLayout());
		setResizable(false);
		setModal(true);
		
		Insets inset = new Insets(0, 0, 5, 5);

		//--------- Constraints ---------
		//Strut Constraints
		GridBagConstraints strutConstraint = new GridBagConstraints();
		
		//Constraints for image
		GridBagConstraints imageConstraint = new GridBagConstraints();
		imageConstraint.gridwidth = 5;
		imageConstraint.gridheight = 7;
		imageConstraint.gridx = 1;
		imageConstraint.gridy = 0;
		
		//Common Constraints for Labels
		GridBagConstraints labelConstraint = new GridBagConstraints();
		labelConstraint.anchor = GridBagConstraints.EAST;
		labelConstraint.insets = inset;
		
		//Common Constraints for Inputs
		GridBagConstraints inputConstraint = new GridBagConstraints();
		inputConstraint.fill = GridBagConstraints.HORIZONTAL;
		inputConstraint.insets = inset;
		inputConstraint.gridwidth = 3;
		inputConstraint.gridx = 8;
		
		//Common Constraints for Buttons
		GridBagConstraints btnConstraint = new GridBagConstraints();
		btnConstraint.insets = inset;
		btnConstraint.gridy = 5;
		
		//--------- Struts ---------
		//Horizontal Struts
		Component leftHorizStrut = Box.createHorizontalStrut(20);
		strutConstraint.gridx = 0;
		strutConstraint.gridy = 2;
		add(leftHorizStrut, strutConstraint);
		
		Component centerHorizStrut = Box.createHorizontalStrut(20);
		strutConstraint.gridx = 6;
		strutConstraint.gridy = 3;
		add(centerHorizStrut, strutConstraint);
		
		Component rightHorizStrut = Box.createHorizontalStrut(20);
		strutConstraint.gridx = 11;
		strutConstraint.gridy = 2;
		add(rightHorizStrut, strutConstraint);
		
		//Vertical Struts
		Component topVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 1;
		add(topVertStrut, strutConstraint);
		
		Component middleVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 4;
		add(middleVertStrut, strutConstraint);
		
		Component bottomVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 6;
		add(bottomVertStrut, strutConstraint);
		
		//image
		JLabel lblImage = new JLabel(new ImageIcon("./images/player(100-100).png"));
		add(lblImage, imageConstraint);
		
		//Name Label
		JLabel nameLabel = new JLabel("Name:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 2;
		add(nameLabel, labelConstraint);
		
		//Account Balance Label
		JLabel AccountBLabel = new JLabel("Account Balance:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 3;
		add(AccountBLabel, labelConstraint);
		
		//Text Input for name
		nameTextInput = new JTextField();
		nameTextInput.setText("Full Name");
		nameTextInput.setToolTipText("Enter Players Full Name");
		inputConstraint.gridy = 2;
		add(nameTextInput, inputConstraint);
		
		//Text Input for Points
		pointsTextInput = new JTextField();
		pointsTextInput.setText("Points");
		pointsTextInput.setToolTipText("Enter Points for Player");
		inputConstraint.gridy = 3;
		add(pointsTextInput, inputConstraint);
		
		//Buttons
		JButton btnCancel = new JButton("Cancel");
		btnConstraint.gridx = 9;
		btnCancel.addActionListener(new CancelDialogAL(this));
		add(btnCancel, btnConstraint);
		
		JButton btnAddPlayer = new JButton("Add Player");
		btnConstraint.gridx = 10;
		btnAddPlayer.addActionListener(new AddPlayerAL(this, gameEngine, mp, mmb, nameTextInput, pointsTextInput));
		add(btnAddPlayer, btnConstraint);
		
		pack();
	}
}