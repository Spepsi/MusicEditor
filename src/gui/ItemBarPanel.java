package gui;

import java.util.Vector;

import javax.swing.JPanel;

import actions.ActionType;

public class ItemBarPanel {
	
	public static JPanel getItemBarPanel(){
		JPanel panel = new JPanel();
		
		// Adding external actions bar
		Vector<ActionType> items = new Vector<ActionType>();
		items.add(ActionType.CreateNewSheet);
		items.add(ActionType.OpenNewSheet);
		items.add(ActionType.SaveCurrentSheet);
		panel.add(new ItemBar("File Items", items));
		
		return panel;		
	}

}
