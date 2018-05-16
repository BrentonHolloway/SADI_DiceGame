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
		
		MainPanel mainPanel = new MainPanel(gameEngine);
		JMenuBar menu = new MainMenuBar(gameEngine, mainPanel);
		JPanel status = new StatusBar();
		
		
		final GameEngineCallbackGUI gecbGUI = new GameEngineCallbackGUI();
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
