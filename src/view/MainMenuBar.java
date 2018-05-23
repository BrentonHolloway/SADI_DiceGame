package view;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.menu.*;
import model.interfaces.GameEngine;


public class MainMenuBar extends JMenuBar {
	private static final long serialVersionUID = 4050748458020858696L;
	
	private GameEngine gameEngine;
	private List<JMenuItem> updateItems;
	
	private String helpTitle = "How To PLay";
	private String helpDescription = "The SADI dice game is based of the casino dice game. The rules are simple, each player places a bet and then rolls two dice before the house rolls against the players. "
			+ "Highest number (sum of the two dice) wins! A draw is a no contest and the bet are returned to the drawing player.\r\n" + 
			"\n" + 
			"NOTE: players only play against the house not against each other.\n\n" + 
			"HOW TO ADD PLAYERS\n"
			+ "To Add players go to Game > Add Player and enter players name and the starting account balance";
	
	private String creditsTitle = "Credits";
	private String creditsDescription = "Designed and Implemeted by:\n   Name: Brenton Holloway\n   SID: s2345302 \n\n"
			+ "I would like to acnoledge......";
	
	public MainMenuBar(GameEngine gameEngine, MainPanel mainPanel) {
		this.gameEngine = gameEngine;
		
		updateItems = new ArrayList<JMenuItem>();
		JMenu file = new JMenu("File");
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");
		
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenuItem addPlayer = new JMenuItem("Add Player");
		JMenuItem updatePlayer = new JMenuItem("Update Player");
		JMenuItem removePlayer = new JMenuItem("Remove Player");
		
		updateItems.add(updatePlayer);
		updateItems.add(removePlayer);
		
		JMenuItem howToPlay = new JMenuItem("How to play");
		JMenuItem credits = new JMenuItem("Credits");
		
		save.addActionListener(new SaveMenuAL());
		load.addActionListener(new LoadMenuAL());
		quit.addActionListener(new QuitMenuAL());
		
		addPlayer.addActionListener(new AddPlayerMenuAL(gameEngine, mainPanel, this));
		updatePlayer.addActionListener(new UpdatePlayerMenuAL(gameEngine, mainPanel));
		removePlayer.addActionListener(new RemovePlayerMenuAL(gameEngine, mainPanel, this));
		
		howToPlay.addActionListener(new DescriptorAL(mainPanel, helpTitle, helpDescription));
		credits.addActionListener(new DescriptorAL(mainPanel, creditsTitle, creditsDescription));
		
		
		file.add(save);
		file.add(load);
		file.add(quit);
		add(file);
		game.add(addPlayer);
		game.add(updatePlayer);
		game.add(removePlayer);
		add(game);
		help.add(howToPlay);
		help.add(credits);
		add(help);
		update();
	}
	
	public void update() {
		if(gameEngine.getAllPlayers().size() < 1) {
			for(JMenuItem jmi: updateItems) {
				jmi.setEnabled(false);
			}
		}else {
			for(JMenuItem jmi: updateItems) {
				jmi.setEnabled(true);
			}
		}
	}
}
