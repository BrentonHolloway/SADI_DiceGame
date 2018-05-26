package view.score_board;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.interfaces.GameEngine;
import model.interfaces.Player;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.util.Vector;



public class ScorePanel extends JPanel {
	private static final long serialVersionUID = -6690581566092366602L;
	
	private String[] header = {"ID", "Player Name", "Bet", "Die 1", "Die 2", "Dice Total"};
	private JTable table;
	private DefaultTableModel dm;
	private GameEngine ge;
	
	public ScorePanel(GameEngine ge) {
		this.ge = ge;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		JLabel title = new JLabel("Results");
		
		table = new JTable();

		update();
		
		add(title);
		add(table.getTableHeader());
		add(table);
	}
	
	public void update() {
		dm = new DefaultTableModel(0,0);
		dm.setColumnIdentifiers(header);
		for(Player p : ge.getAllPlayers()) {
	        Vector<Object> data = new Vector<Object>();
	        data.add(p.getPlayerId());
	        data.add(p.getPlayerName());
	        data.add(p.getBet());
	        data.add((p.getRollResult()==null)?"-":p.getRollResult().getDice1());
	        data.add((p.getRollResult()==null)?"-":p.getRollResult().getDice2());
	        data.add((p.getRollResult()==null)?"-":(p.getRollResult().getDice1() + p.getRollResult().getDice2()));
	        dm.addRow(data);
		}
		table.setModel(dm);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
	}
	
}
