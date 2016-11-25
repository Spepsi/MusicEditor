package gui;

import java.util.Vector;

import javax.swing.JMenuBar;

import actions.Action;

public class MenuBar {
	
	public static JMenuBar getMenuBar(){
		JMenuBar menuBar = new JMenuBar();
		
		return menuBar;
	}
	
	public class Menu{
		public String name;
		public Vector<Action> actions;
		
		public Menu(String name, Vector<Action> actions){
			this.name = name;
			this.actions = actions;
		}
	}

}
