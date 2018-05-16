package view;

import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class UpdatePlayer extends JDialog {
	private static final long serialVersionUID = 2346069702958679341L;
	
	private GameEngine gameEngine;
	
	public UpdatePlayer(GameEngine gameEngine) {
		this.gameEngine = gameEngine;
		setTitle("Update Player");
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setModal(true);
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT);
		add(tabbedPane, BorderLayout.CENTER);
		
		for(Player p: gameEngine.getAllPlayers()) {
			addTab(tabbedPane, p);
		}
		pack();
	}
	
	public void addTab(JTabbedPane tabbedPane, Player player) {
		JPanel p = new JPanel();
		p.setLayout(new GridBagLayout());
		
		Insets inset = new Insets(0, 0, 5, 5); //adds padding

		//--------- Common Constraints ---------
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
		p.add(leftHorizStrut, strutConstraint);
		
		Component centerHorizStrut = Box.createHorizontalStrut(20);
		strutConstraint.gridx = 6;
		strutConstraint.gridy = 3;
		p.add(centerHorizStrut, strutConstraint);
		
		Component rightHorizStrut = Box.createHorizontalStrut(20);
		strutConstraint.gridx = 11;
		strutConstraint.gridy = 2;
		p.add(rightHorizStrut, strutConstraint);
		
		//Vertical Struts
		Component topVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 1;
		p.add(topVertStrut, strutConstraint);
		
		Component middleVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 4;
		p.add(middleVertStrut, strutConstraint);
		
		Component bottomVertStrut = Box.createVerticalStrut(20);
		strutConstraint.gridx = 10;
		strutConstraint.gridy = 6;
		p.add(bottomVertStrut, strutConstraint);
		
		//image
		JLabel lblImage = new JLabel(new ImageIcon("./images/player(100-100).png"));
		p.add(lblImage, imageConstraint);
		
		//Name Label
		JLabel nameLabel = new JLabel("Name:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 2;
		p.add(nameLabel, labelConstraint);
		
		//Account Balance Label
		JLabel AccountBLabel = new JLabel("Account Balance:");
		labelConstraint.gridx = 7;
		labelConstraint.gridy = 3;
		p.add(AccountBLabel, labelConstraint);
		
		//Text Input for name
		JTextField nameTextInput = new JTextField();
		nameTextInput.setText(player.getPlayerName());
		inputConstraint.gridy = 2;
		p.add(nameTextInput, inputConstraint);
		
		//Text Input for Points
		JTextField pointsTextInput = new JTextField();
		pointsTextInput.setText(String.format("%d", player.getPoints()));
		inputConstraint.gridy = 3;
		p.add(pointsTextInput, inputConstraint);
		
		//Buttons
		JButton btnCancel = new JButton("Cancel");
		btnConstraint.gridx = 9;
		btnCancel.addActionListener(new controller.game.CancelDialogAL(this));
		p.add(btnCancel, btnConstraint);
		
		JButton btnAddPlayer = new JButton("Update Player");
		btnConstraint.gridx = 10;
		p.add(btnAddPlayer, btnConstraint);
		
		tabbedPane.add(player.getPlayerName(), p);
	}

}
