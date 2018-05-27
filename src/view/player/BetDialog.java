package view.player;

import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

import controller.game.BetAL;
import controller.game.CancelDialogAL;
import model.interfaces.GameEngine;
import model.interfaces.Player;
import view.MainPanel;
import view.MainToolBar;
import view.StatusBar;
import view.score_board.ScorePanel;

public class BetDialog extends JDialog {
	private static final long serialVersionUID = 3079190134366086480L;
	
	private JTextField pointsTextInput;

	public BetDialog(GameEngine ge, MainPanel mp, MainToolBar mtb, ScorePanel sp, StatusBar sb, Player p) {
		setTitle("Place/Update Bet");
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
		JLabel nameLabel = new JLabel("Current Bet:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 2;
		add(nameLabel, labelConstraint);
		
		//Account Balance Label
		JLabel AccountBLabel = new JLabel("Place/Change Bet:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 3;
		add(AccountBLabel, labelConstraint);
		
		//Text Input for name
		JLabel currentBet = new JLabel();
		currentBet.setText(String.valueOf(p.getBet()));
		currentBet.setToolTipText("Players Current Bet");
		inputConstraint.gridy = 2;
		add(currentBet, inputConstraint);
		
		//Text Input for Points
		pointsTextInput = new JTextField();
		pointsTextInput.setText(String.valueOf(p.getBet()));
		pointsTextInput.setToolTipText("Enter Points for Player");
		inputConstraint.gridy = 3;
		add(pointsTextInput, inputConstraint);
		
		//Buttons
		JButton btnCancel = new JButton("Cancel");
		btnConstraint.gridx = 9;
		btnCancel.addActionListener(new CancelDialogAL(this));
		add(btnCancel, btnConstraint);
		
		JButton btnAddPlayer = new JButton("Place Bet");
		btnConstraint.gridx = 10;
		btnAddPlayer.addActionListener(new BetAL(this, ge, mtb, sp, sb, p, pointsTextInput));
		add(btnAddPlayer, btnConstraint);
		
		pack();
	}
}
