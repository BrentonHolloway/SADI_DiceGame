package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import model.interfaces.GameEngine;

import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8456560429229699542L;
	
	public MainFrame(final GameEngine gameEngine) {
		super();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		StatusBar status = new StatusBar(gameEngine);
		MainPanel mainPanel = new MainPanel(gameEngine, status);
		JMenuBar menu = new MainMenuBar(gameEngine, mainPanel, status);
		
		
		
		final GameEngineCallbackGUI gecbGUI = new GameEngineCallbackGUI(mainPanel);
		new Thread() {
			@Override
			public void run() {
				gameEngine.addGameEngineCallback(gecbGUI);
			};
		}.start();
		
		add(menu, BorderLayout.NORTH);
		add(mainPanel, BorderLayout.CENTER);
		add(status, BorderLayout.SOUTH);
		
		pack();
	}
}
