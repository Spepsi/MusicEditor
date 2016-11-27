package actions;

import javax.swing.ImageIcon;

import main.Main;

public enum ActionType {

	// Actions - File Menu
	CreateNewSheet("new_file", "New File"),
	SaveCurrentSheet("save_file", "Save File"),
	OpenNewSheet("open_file", "Open File"),
	ExitSoftware("exit", "Exit"), 
	// Actions - Edition Menu
	CopyElement("copy", "Copy"), 
	PasteElement("paste", "Paste"), 
	Undo("undo", "Undo"), 
	Redo("redo", "Redo"),
	// Actions Switch Name
	SwitchSheet("", "Switch Sheet"),
	DeleteSheet("", "Delete Sheet");
	
	private ActionType(String iconname, String name){
		this.icone = Main.icones.getIcone(iconname);
		this.name = name;
	}
	private ActionType(){
		this.name= this.name();
		this.icone = Main.icones.getIcone("default");
	}
	
	
	ImageIcon icone = null;	
	String name = null;
	
	public ImageIcon getIcone() {
		return icone;
	}
	public String getName() {
		return name;
	}
	
}
