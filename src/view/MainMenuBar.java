package view;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MainMenuBar extends JMenuBar {
	private static final long serialVersionUID = 4050748458020858696L;
	public MainMenuBar() {
		JMenu file = new JMenu("File");
		JMenu game = new JMenu("Game");
		JMenu help = new JMenu("Help");
		
		JMenuItem save = new JMenuItem("Save");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem quit = new JMenuItem("Quit");
		
		JMenuItem addPlayer = new JMenuItem("Add Player");
		JMenuItem updatePlayer = new JMenuItem("Update Player");
		JMenuItem removePlayer = new JMenuItem("Remove Player");
		
		JMenuItem howToPlay = new JMenuItem("How to play");
		JMenuItem credits = new JMenuItem("Credits");
		
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
	}
	
	
	
	
}
