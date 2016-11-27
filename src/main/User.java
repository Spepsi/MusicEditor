package main;

import elements.Bar;
import elements.KeySignature;
import elements.Note;
import elements.RythmSignature;

public class User {

	Sheet sheet = new Sheet();

	public static void createTestSheet(){
		Sheet s = Main.user.getSheet();
		// We fill the sheet
		s.setGlobalKeySignature(new KeySignature(0,0));
		s.setGlobalRythmSignature(new RythmSignature(4,4));

		// Insert a bar
		Bar b1 = new Bar();
		// Insert a note in the bar
		Note n1 = new Note(4,false,0,3,50);
		Note n2 = new Note(4,false,2,3,50);
		Note n3 = new Note(4,false,4,3,50);
		Note n4 = new Note(4,false,6,3,50);
		Note n5 = new Note(4,false,0,4,50);
		Note n6 = new Note(4,false,2,4,50);
		Note n7 = new Note(4,false,8,4,50);
		Note n8 = new Note(4,false,5,4,50);


		b1.addNote(n1);
		b1.addAfter(n1,n2);
		b1.addAfter(n2,n3);
		b1.addAfter(n3,n4);
		b1.addAfter(n4,n5);
		b1.addAfter(n5,n6);
		b1.addAfter(n6,n7);
		b1.addAfter(n7,n8);
		s.addBar(b1);
	}

	int stepTolerance = 16 ; // By default step tolerance is sixteenth note (should be parametrizable)

	public Sheet getSheet(){
		return sheet;
	}


}
