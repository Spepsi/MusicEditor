package actions;

import java.util.Vector;

import main.Main;
import main.Sheet;

public class ActionHelper {

	public static int getNumberOfNewSheet(){
		Vector<Integer> v = new Vector<Integer>();
		for(Sheet s : Main.user.getSheets()){
			if(s.getTitle().equals("New Sheet")){
				v.add(0);
			} else if(s.getTitle().startsWith("New Sheet (") &&
					s.getTitle().endsWith(")")){
				try{
					v.addElement(Integer.parseInt(s.getTitle().substring(11, s.getTitle().length()-1)));
				}catch(NumberFormatException e) {}
				}
		}
		int i=0;
		while(v.contains(i))
			i++;
		return i;
	}
}
