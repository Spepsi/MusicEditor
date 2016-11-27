package actions;

import javax.swing.ImageIcon;

import ressources.Icones;

public enum ActionType {

	// Actions - File Menu
	CreateNewSheet(Icones.newFile, "New File"),
	SaveCurrentSheet(Icones.saveFile, "Save File"),
	OpenNewSheet(Icones.openFile, "Open File"),
	ExitSoftware(Icones.defaut, "Exit"), 
	// Actions - Edition Menu
	CopyElement(Icones.copy, "Copy"), 
	PasteElement(Icones.paste, "Paste"), 
	Undo(Icones.undo, "Undo"), 
	Redo(Icones.redo, "Redo");
	
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
	
	public ImageIcon getIcone() {
		return icone.image();
	}
	public String getName() {
		return name;
	}
	
}
