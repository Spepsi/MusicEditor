package elements;
import java.util.Vector;


import main.Main;


public class Bar implements Element {

	KeySignature key;
	RythmSignature rythm;
	Vector<Note> notes= new Vector<Note>();
	Vector<Note> currentAccidentals= new Vector<Note>();
	Vector<Integer> accidents = new Vector<Integer>();
	public Vector<Note> getNotes() {
		return notes;
	}
	
	public KeySignature getKeySignature(){
		return key;
	}
	
	public void calculateAccidentals(){
		
		for(Note n : notes){
			// Get y origin (where to draw)
			n.setNote(key.getAbsoluteRootTone(n));
			boolean accident = true;
			boolean forceSharp = false;
			// Check if accident has been taken into account
			Vector<Note> toRemoveAccidentals = new Vector<Note>();
			for(Note n1 : currentAccidentals){
				if(n1.equal(n)){
					System.out.println("return "+n.getPitch());
					accident=false;
					break;
				}
				// Then same root note and same octave..
				if(key.getRootTone(n1)==key.getRootTone(n) && n1.getOctave()==n.getOctave()){
					// Should we put a becarre or becarre #?
					System.out.println("becarre "+n1.getPitch()+" "+n.getPitch());
					// Differentiate the real becarre case and armature accident
					if(key.isBecarre(n)){
						n.setBecarre(true);
						n.setAccidental(0);	
					}else{
						System.out.println("forcesharp");
						forceSharp = true;
					}
					toRemoveAccidentals.addElement(n1);
				}
			}
			// Then calculate accidentals if necessary !
			int accidental = key.getRootAccidental(n);
			
			if(forceSharp){
				accidental += key.nbSharps>0 || (key.nbSharps==0 && key.nbFlats==0) ? 1 :-1;
			}
			n.setAccidental(accidental);
			if(!accident){
				n.setPrintAccident(false);
			}
			if(n.getAccidental()!=0){
				
				currentAccidentals.add(n);
			}
			
			// Clear accidents buffer to remove
			currentAccidentals.removeAll(toRemoveAccidentals);
		}
	}
	

	
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
