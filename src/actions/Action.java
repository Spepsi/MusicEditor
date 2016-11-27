package actions;

import elements.Element;
import gui.SwingMain;
import main.Main;
import main.Mode;

public abstract class Action {
	
	ActionType type;
	Element targetedElement;
	
	// Action parameters
	public static int switch_to_sheet_id;
	public static int delete_sheet_id;
	
	public abstract void undo();
	public abstract void redo();
	
	public static void redoAction(ActionType type){
		switch(type){
		case EnterInputMode:
			Main.user.setMode(Mode.INPUT);
			SwingMain.getItemBarPanel().update();
			break;
		case EnterSelectMode:
			Main.user.setMode(Mode.SELECTION);
			SwingMain.getItemBarPanel().update();
			break;
		case EnterDottedMode:
			Main.user.setDotted(true);
			SwingMain.getItemBarPanel().update();
			break;
		case EnterNondottedMode:
			Main.user.setDotted(false);
			SwingMain.getItemBarPanel().update();
			break;
		case EnterRestMode:
			Main.user.setRest(true);
			SwingMain.getItemBarPanel().update();
			break;
		case EnterNonrestMode:
			Main.user.setRest(false);
			SwingMain.getItemBarPanel().update();
			break;
		case RythmMode1:
			Main.user.setRythmMode(1);
			SwingMain.getItemBarPanel().update();
			break;
		case RythmMode2:
			Main.user.setRythmMode(2);
			SwingMain.getItemBarPanel().update();
			break;
		case RythmMode4:
			Main.user.setRythmMode(4);
			SwingMain.getItemBarPanel().update();
			break;
		case RythmMode8:
			Main.user.setRythmMode(8);
			SwingMain.getItemBarPanel().update();
			break;
		case RythmMode16:
			Main.user.setRythmMode(16);
			SwingMain.getItemBarPanel().update();
			break;
		case CreateNewSheet:
			int i = ActionHelper.getNumberOfNewSheet();
			if(i==0){
				Main.user.createNewSheet("New Sheet");
			} else {
				Main.user.createNewSheet("New Sheet ("+i+")");				
			}
			SwingMain.getSheetsPane().update();
			break;
		case DeleteSheet:
			Main.user.deleteSheet(delete_sheet_id);
			if(Main.user.getSheets().size()==0){
				Main.user.createNewSheet("New Sheet");
			}
			SwingMain.getSheetsPane().update();
			switch_to_sheet_id = 0;
			redoAction(ActionType.SwitchSheet);
			break;
		case SwitchSheet:
			Main.user.switch_sheet(switch_to_sheet_id);
			Main.frame.setTitle("Music Editor - "+Main.user.getSheet().getTitle());
			break;
		case ExitSoftware:
			Main.frame.setVisible(false); //you can't see me!
			Main.frame.dispose();
			break;
		default : System.out.println("redo action : "+type+"\n   Pour ne plus voir ce message s'afficher,\n    overridez la fonction redo de cette action");

			
		}
	}
	
	public static void undoAction(ActionType type){
		switch(type){
		
		default : System.out.println("undo action : "+type+"\n   Pour ne plus voir ce message s'afficher,\n    overridez la fonction undo de cette action");
		
		}
	}
	
	
}
