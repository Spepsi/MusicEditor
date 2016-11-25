package gui;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.JPanel;

import actions.Action;
import actions.ActionType;

public class ItemBar extends JPanel{

	public String name;
	
	public ItemBar(String name, Vector<ActionType> items) {
		this.name = name;
		for(ActionType type: items){
			Icon icon = type.getIcone();
			JButton bouton = new JButton(icon);
			bouton.setPreferredSize(new Dimension(48,48));
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Action.redoAction(type);
				}
			});
			this.add(bouton);
		}
	}
	
	

}
