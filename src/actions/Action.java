package actions;

import elements.Element;

public abstract class Action {
	
	ActionType type;
	Element targetedElement;
	
	public abstract void undo();
	public abstract void redo();
	
	public static void redoAction(ActionType type){
		switch(type){
		
		default : System.out.println("redo action : "+type+"\n   Pour ne plus voir ce message s'afficher,\n    overridez la fonction redo de cette action");
		
			
		}
	}
	
	public static void undoAction(ActionType type){
		switch(type){
		
		default : System.out.println("undo action : "+type+"\n   Pour ne plus voir ce message s'afficher,\n    overridez la fonction undo de cette action");
		
		}
	}
	
	
}
