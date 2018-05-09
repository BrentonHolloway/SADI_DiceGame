package view;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;


public class AddPlayer extends JDialog {
	private static final long serialVersionUID = -1701323917859373346L;
	private JTextField pointsTextInput;
	private JTextField nameTextInput;
	
	public AddPlayer() {
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setLayout(new GridBagLayout());
		setResizable(false);
		setModal(true);
		
		JLabel lblImage = new JLabel(new ImageIcon("./images/player(100-100).png"));
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(5, 0, 5, 5);
		gbc_lblImage.gridwidth = 5;
		gbc_lblImage.gridheight = 7;
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 0;
		add(lblImage, gbc_lblImage);
		
		//Horizontal Struts
		Component leftHorizStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_leftHorizStrut = new GridBagConstraints();
		gbc_leftHorizStrut.insets = new Insets(0, 0, 5, 5);
		gbc_leftHorizStrut.gridx = 0;
		gbc_leftHorizStrut.gridy = 2;
		add(leftHorizStrut, gbc_leftHorizStrut);
		
		Component centerHorizStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_centerHorizStrut = new GridBagConstraints();
		gbc_centerHorizStrut.insets = new Insets(0, 0, 5, 5);
		gbc_centerHorizStrut.gridx = 6;
		gbc_centerHorizStrut.gridy = 3;
		add(centerHorizStrut, gbc_centerHorizStrut);
		
		Component rightHorizStrut = Box.createHorizontalStrut(20);
		GridBagConstraints gbc_rightHorizStrut = new GridBagConstraints();
		gbc_rightHorizStrut.insets = new Insets(0, 0, 5, 5);
		gbc_rightHorizStrut.gridx = 11;
		gbc_rightHorizStrut.gridy = 2;
		add(rightHorizStrut, gbc_rightHorizStrut);
		
		//Vertical Struts
		Component topVertStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_topVertStrut = new GridBagConstraints();
		gbc_topVertStrut.insets = new Insets(0, 0, 5, 5);
		gbc_topVertStrut.gridx = 10;
		gbc_topVertStrut.gridy = 1;
		add(topVertStrut, gbc_topVertStrut);
		
		Component middleVertStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_middleVertStrut = new GridBagConstraints();
		gbc_middleVertStrut.insets = new Insets(0, 0, 5, 5);
		gbc_middleVertStrut.gridx = 10;
		gbc_middleVertStrut.gridy = 4;
		add(middleVertStrut, gbc_middleVertStrut);
		
		Component bottomVertStrut = Box.createVerticalStrut(20);
		GridBagConstraints gbc_bottomVertStrut = new GridBagConstraints();
		gbc_bottomVertStrut.insets = new Insets(0, 0, 5, 5);
		gbc_bottomVertStrut.gridx = 10;
		gbc_bottomVertStrut.gridy = 6;
		add(bottomVertStrut, gbc_bottomVertStrut);
		
		//Name Label
		JLabel nameLabel = new JLabel("Name:");
		GridBagConstraints gbc_nameLabel = new GridBagConstraints();
		gbc_nameLabel.anchor = GridBagConstraints.EAST;
		gbc_nameLabel.insets = new Insets(0, 0, 5, 5);
		gbc_nameLabel.gridx = 7;
		gbc_nameLabel.gridy = 2;
		add(nameLabel, gbc_nameLabel);
		
		//Text Input for name
		nameTextInput = new JTextField();
		nameTextInput.setText("Full Name");
		nameTextInput.setToolTipText("Enter Players Full Name");
		GridBagConstraints gbc_nameTextInput = new GridBagConstraints();
		gbc_nameTextInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameTextInput.insets = new Insets(0, 0, 5, 5);
		gbc_nameTextInput.gridwidth = 3;
		gbc_nameTextInput.gridx = 8;
		gbc_nameTextInput.gridy = 2;
		add(nameTextInput, gbc_nameTextInput);
		
		//Account Balance Label
		JLabel AccountBLabel = new JLabel("Account Balance:");
		GridBagConstraints gbc_AccountBLabel = new GridBagConstraints();
		gbc_AccountBLabel.anchor = GridBagConstraints.EAST;
		gbc_AccountBLabel.insets = new Insets(0, 0, 5, 5);
		gbc_AccountBLabel.gridx = 7;
		gbc_AccountBLabel.gridy = 3;
		add(AccountBLabel, gbc_AccountBLabel);
		
		//Text Input for Points
		pointsTextInput = new JTextField();
		pointsTextInput.setText("Points");
		pointsTextInput.setToolTipText("Enter Points for Player");
		GridBagConstraints gbc_pointsTextInput = new GridBagConstraints();
		gbc_pointsTextInput.fill = GridBagConstraints.HORIZONTAL;
		gbc_pointsTextInput.insets = new Insets(0, 0, 5, 5);
		gbc_pointsTextInput.gridwidth = 3;
		gbc_pointsTextInput.gridx = 8;
		gbc_pointsTextInput.gridy = 3;
		add(pointsTextInput, gbc_pointsTextInput);
		
		//Buttons
		JButton btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.insets = new Insets(0, 0, 5, 5);
		gbc_btnCancel.gridx = 9;
		gbc_btnCancel.gridy = 5;
		add(btnCancel, gbc_btnCancel);
		
		JButton btnAddPlayer = new JButton("Add Player");
		GridBagConstraints gbc_btnAddPlayer = new GridBagConstraints();
		gbc_btnAddPlayer.insets = new Insets(0, 0, 5, 5);
		gbc_btnAddPlayer.gridx = 10;
		gbc_btnAddPlayer.gridy = 5;
		add(btnAddPlayer, gbc_btnAddPlayer);
		
		pack();
	}
}