package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;

import actions.Action;
import actions.ActionType;

public class ItemBarPanel extends JToolBar{
	
	public static Dimension buttonDimension = new Dimension(24,24);

	public ItemBarPanel(JPanel pan){
		super();
		setFloatable(false);
		setRollover(true);
		
		// Adding external actions bar
		Vector<ActionType> items;
		items = new Vector<ActionType>();
		items.add(ActionType.CreateNewSheet);
		items.add(ActionType.OpenNewSheet);
		items.add(ActionType.SaveCurrentSheet);
		addItems(items);
		// Adding Redo and Undo
		items = new Vector<ActionType>();
		items.add(ActionType.Redo);
		items.add(ActionType.Undo);
		addItems(items);
		
	}
	
	private void addItems(Vector<ActionType> items){
		for(ActionType type: items){
			ImageIcon icon = new ImageIcon(type.getIcone().getImage().getScaledInstance(buttonDimension.width, buttonDimension.height, Image.SCALE_SMOOTH));
			JButton bouton = new JButton(icon);
			bouton.setPreferredSize(buttonDimension);
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Action.redoAction(type);
				}
			});
			add(bouton);
		}
		addSeparator();
	}

}
