package main;
import elements.Bar;
import elements.KeySignature;
import elements.Note;
import elements.RythmSignature;

public class Main {
	public static User user = new User();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sheet s = user.getSheet();
		// We fill the sheet
		s.setGlobalKeySignature(new KeySignature(0,0));
		s.setGlobalRythmSignature(new RythmSignature(4,4));
		
		// Insert a bar
		Bar b1 = new Bar();
		// Insert a note in the bar
		Note n1 = new Note(2,false,1,0,50);
		Note n2 = new Note(4,true,2,0,50);
		Note n3 = new Note(8,false,3,0,50);
		Note n4 = new Note(8,false,4,0,50);
		
		b1.addNote(n1);
		b1.addAfter(n1,n2);
		b1.addAfter(n2,n3);
		b1.addWith(n3,n4);
		s.addBar(b1);
		
		s.print();
		
	}

}
