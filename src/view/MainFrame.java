package view;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;

import java.awt.BorderLayout;

public class MainFrame extends JFrame {
	private static final long serialVersionUID = 8456560429229699542L;
	
	public MainFrame() {
		super();
		
		JMenuBar menu = new MainMenuBar();
		JPanel status = new StatusBar();
		
		add(menu, BorderLayout.NORTH);
		add(status, BorderLayout.SOUTH);
		
		pack();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		new Thread() {
			@Override
			public void run() {
				gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
				gameEngine.addGameEngineCallback(new GameEngineCallbackGUI());
			}
		}.start();
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        JFrame mainFrame = new MainFrame();
		        mainFrame.setLocationRelativeTo(null);
		    }
		});
	}
}
