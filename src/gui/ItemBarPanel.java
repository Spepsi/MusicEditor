package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.UIManager;

import actions.Action;
import actions.ActionType;
import main.Main;
import main.Mode;

public class ItemBarPanel extends JToolBar{

	public static Dimension buttonDimension = new Dimension(24,24);

	Vector<JButton> boutons = new Vector<JButton>();

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
		// Adding Input and Select
		items = new Vector<ActionType>();
		items.add(ActionType.EnterInputMode);
		items.add(ActionType.EnterSelectMode);
		addItems(items);
		// Adding Nondotted and Dotted
		items = new Vector<ActionType>();
		items.add(ActionType.EnterDottedMode);
		items.add(ActionType.EnterNondottedMode);
		addItems(items);
		// Adding Rest and Nonrest
		items = new Vector<ActionType>();
		items.add(ActionType.EnterRestMode);
		items.add(ActionType.EnterNonrestMode);
		addItems(items);
		// Adding RythmMode
		items = new Vector<ActionType>();
		items.add(ActionType.RythmMode1);
		items.add(ActionType.RythmMode2);
		items.add(ActionType.RythmMode4);
		items.add(ActionType.RythmMode8);
		items.add(ActionType.RythmMode16);
		addItems(items);
		update();
	}

	private void addItems(Vector<ActionType> items){
		for(ActionType type: items){
			ImageIcon icon = new ImageIcon(type.getIcone().getImage().getScaledInstance(buttonDimension.width, buttonDimension.height, Image.SCALE_SMOOTH));
			JButton bouton = new JButton(icon);
			bouton.setPreferredSize(buttonDimension);
			bouton.setToolTipText(type.getName());
			bouton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					Action.redoAction(type);
				}
			});
			add(bouton);
			boutons.add(bouton);
		}
		addSeparator();
	}

	public void update(){
		for(JButton bouton : boutons){
			// Rythm Selection
			if(bouton.getToolTipText().startsWith(ActionType.RythmMode1.getName().substring(0, 6))){
				if(bouton.getToolTipText().endsWith(" "+Main.user.getRythmMode())){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			// Mode Selection
			if(bouton.getToolTipText().equals(ActionType.EnterInputMode.getName())){
				if(Main.user.getMode()==Mode.INPUT){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			if(bouton.getToolTipText().equals(ActionType.EnterSelectMode.getName())){
				if(Main.user.getMode()==Mode.SELECTION){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			// Dotted Selection
			if(bouton.getToolTipText().equals(ActionType.EnterDottedMode.getName())){
				if(Main.user.isDotted()){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			if(bouton.getToolTipText().equals(ActionType.EnterNondottedMode.getName())){
				if(!Main.user.isDotted()){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			// Rest Selection
			if(bouton.getToolTipText().equals(ActionType.EnterRestMode.getName())){
				if(Main.user.isRest()){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}
			if(bouton.getToolTipText().equals(ActionType.EnterNonrestMode.getName())){
				if(!Main.user.isRest()){	
					bouton.setBackground(Color.cyan);
				} else {
					bouton.setBackground(UIManager.getColor("control"));
				}
			}

		}
	}

}
