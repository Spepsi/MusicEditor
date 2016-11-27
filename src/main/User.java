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
		Note n1 = new Note(32,false,0,3,50);
		Note n2 = new Note(16,false,2,3,50);
		Note n3 = new Note(8,false,3,3,50);
		Note n4 = new Note(8,false,4,3,50);

		b1.addNote(n1);
		b1.addAfter(n1,n2);
		b1.addAfter(n2,n3);
		b1.addWith(n3,n4);
		s.addBar(b1);
	}

	int stepTolerance = 16 ; // By default step tolerance is sixteenth note (should be parametrizable)

	public Sheet getSheet(){
		return sheet;
	}


}