import java.util.Vector;

public class Bar {

	KeySignature key;
	RythmSignature rythm;
	Vector<Note> notes= new Vector<Note>();
	int nbsteps = 96;// Smallest step possible (for representing starts ...) // Depends on the bar
	
	public Bar(KeySignature key,RythmSignature rythm){
		this.key = key;
		this.rythm = rythm;
		this.nbsteps = rythm.getFirst()*24;
	}
	

}
