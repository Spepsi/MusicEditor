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
	// Actions - Switch Sheet
	SwitchSheet("", "Switch Sheet"),
	DeleteSheet("", "Delete Sheet"),
	// Actions - Set Rythm Mode
	RythmMode1("rythm_1", "Rythm 1",2),
	RythmMode2("rythm_2", "Rythm 2",2),
	RythmMode4("rythm_4", "Rythm 4",2),
	RythmMode8("rythm_8", "Rythm 8",2),
	RythmMode16("rythm_16", "Rythm 16",2),
	// Actions - Switch Input Mode
	EnterInputMode("input_mode","Input Mode",1),
	EnterSelectMode("select_mode","Select Mode",1),
	// Actions - Switch Dotted Mode
	EnterDottedMode("dotted_true","Dotted Mode",3),
	EnterNondottedMode("dotted_false","Non-dotted Mode",3);
	
	private ActionType(String iconname, String name){
		this.icone = Main.icones.getIcone(iconname);
		this.name = name;
	}
	private ActionType(String iconname, String name, int mode){
		this.icone = Main.icones.getIcone(iconname);
		this.name = name;
		this.selectionMode = mode;
	}
	private ActionType(){
		this.name= this.name();
		this.icone = Main.icones.getIcone("default");
	}
	

	public static int RYTHM_CHOICE = 2;
	public static int MODE_CHOICE = 1;
	public static int DOTTED_CHOICE = 3;
	
	
	ImageIcon icone = null;	
	String name = null;
	int selectionMode = 0;
	
	public ImageIcon getIcone() {
		return icone;
	}
	public String getName() {
		return name;
	}
	
}
