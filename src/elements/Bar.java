package elements;
import java.util.Vector;


import main.Main;


public class Bar implements Element {

	KeySignature key;
	RythmSignature rythm;
	Vector<Note> notes= new Vector<Note>();

	
	
	public void addNote(Note n){
		// By default add note at the start of the sheet
		notes.add(n);
		// Add right step for note
		
	}
	public void addNote(Note n,int startStep){
		// By default add note at the start of the sheet
		n.setStartStep(startStep);
		notes.add(n);
		// Add right step for note
	}
	
	public void addAfter(Note previousNote,Note newNote){
		newNote.setStartStep(getStepAfterNote(previousNote));
		notes.add(newNote);
	}
	public void addWith(Note previousNote,Note newNote){
		newNote.setStartStep(previousNote.getStartStep());
		notes.add(newNote);
	}
	
	public void addAllAfter(Note previousNote,Vector<Note> notes){
		for(Note n : notes){
			addAfter(previousNote,n);
		}
	}
	public void addAll(Vector<Note> notes,int startStep){
		for(Note n : notes){
			addNote(n,startStep);
		}
	}

	
	public int getStepAfterNote(Note n){
		int dot = n.getDotted()? 1:0;
		float frac = ((1f/(n.getDuration())*(1+0.5f*dot)))/(this.rythm.getFirst()/this.rythm.getSecond());
		return (int)(n.getStartStep()+(frac*Main.user.getSheet().getNbSteps()));
		
	}
	public int durationToStep(int duration,boolean dotted){
		float frac = ((1f/(duration))*(1+0.5f*(dotted?1:0)))/(this.rythm.getFirst()/this.rythm.getSecond());
		return (int)((frac*Main.user.getSheet().getNbSteps()));
	}
	
	public Bar(){
		this.key = Main.user.getSheet().getGlobalKeySignature();
		this.rythm =Main.user.getSheet().getGlobalRythmSignature();
	}
	public Bar(KeySignature key,RythmSignature rythm){
		this.key = key;
		this.rythm = rythm;
		
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		for(Note n : notes){
			n.print();
			System.out.print("-");
		}
	}

	
}
