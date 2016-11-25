package actions;

import javax.swing.Icon;

import ressources.Icones;

public enum ActionType {

	// Actions - File Menu
	CreateNewSheet(Icones.newFile, "New File"),
	SaveCurrentSheet,
	OpenNewSheet,
	ExitSoftware, 
	// Actions - Edition Menu
	CopyElement, 
	PasteElement, 
	Undo, 
	Redo;
	
	private ActionType(Icones icone, String name){
		this.icone = icone;
		this.name = name;
	}
	private ActionType(){
		this.name= this.name();
		this.icone = Icones.defaut;
	}
	
	
	Icones icone = null;	
	String name = null;
	
	public Icon getIcone() {
		return icone.image();
	}
	public String getName() {
		return name;
	}
	

	
}
