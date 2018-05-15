package app;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import model.GameEngineImpl;
import model.interfaces.GameEngine;
import view.GameEngineCallbackGUI;
import view.GameEngineCallbackImpl;
import view.MainFrame;

public class DiceGame {

	public static void main(String[] args) {
		final GameEngine gameEngine = new GameEngineImpl();
		gameEngine.addGameEngineCallback(new GameEngineCallbackImpl());
		
		SwingUtilities.invokeLater(new Runnable() {
		    public void run() {
		        JFrame mainFrame = new MainFrame(gameEngine);
		        mainFrame.setLocationRelativeTo(null);
		        mainFrame.setMinimumSize(new Dimension(600, 400));
		    }
		});

	}

}
