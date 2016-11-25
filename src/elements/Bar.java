package elements;
import java.util.Vector;

import actions.Action;


public class Bar implements Element {

	KeySignature key;
	RythmSignature rythm;
	Vector<Note> notes= new Vector<Note>();
	int nbsteps = 96;// Smallest step possible (for representing starts ...) // Depends on the bar
	
	
	public Bar(){

		this.rythm = rythm;
		this.nbsteps = rythm.getFirst()*24;
	}
	public Bar(KeySignature key,RythmSignature rythm){
		this.key = key;
		this.rythm = rythm;
		this.nbsteps = rythm.getFirst()*24;
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

}
