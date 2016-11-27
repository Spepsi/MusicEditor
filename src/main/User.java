package main ;

import java.util.Vector;

import elements.Bar;
import elements.KeySignature;
import elements.Note;
import elements.RythmSignature;

public class User {

	
	Vector<Sheet> sheets;
	int idCurrentSheet;
	
	
	public boolean isRest() {
		return rest;
	}

	public void setRest(boolean rest) {
		this.rest = rest;
	}

	private int rythmMode = 1;
	int[] rythmModes = {1,2,4,8,16};
	public int[] getRythmModes() {
		return rythmModes;
	}

	boolean dotted ;
	Mode mode = Mode.INPUT;
	Vector<Note> selection;
	boolean rest;
	
	public User(){
		sheets = new Vector<Sheet>();
		Sheet s = new Sheet();
		idCurrentSheet = 0;
		sheets.add(s);
	}
	
	// TODO IN GRAPHIC PART
	public void setMode(Mode mode){
		this.mode = mode;
	}
	public void transpose(int change,Note n,Bar b){
		n.transpose(change);
		b.calculateAccidentals();
	}
	public void diatonicTranspose(int change,Note n,Bar b){
		n.diatonicTranspose(change,b.getKeySignature());
		b.calculateAccidentals();
	}
	public void changeRythm(int rythm){
		this.setRythmMode(rythm);
	}
	public void setDotted(boolean dotted){
		this.dotted = dotted;
	}
	public boolean isDotted(){
		return this.dotted;
	}
	public void changeRest(){
		this.rest =!rest;
	}
	public void select(Vector<Note> n){
		selection = n;
	}
	public void inputNote(int diatonicNote,int octave,Bar b){
		// Input a note after the last one by default !
		Note lastNote = b.getNotes().size()>0 ?b.getNotes().lastElement() : null;
		Note newNote;
		if(this.rest){
			newNote = new Note(this.rythmMode,this.dotted,diatonicNote,octave,50,b.getKeySignature());
		}else{
			newNote = new Note(this.rythmMode,this.dotted);
		}
		if(lastNote!=null){
			b.addAfter(lastNote,newNote);
		}else{
			b.addNote(newNote);
		}
		b.calculateAccidentals();
	}
	public void deleteNote(Note n,Bar b){
		b.getNotes().remove(n);
		
		b.calculateAccidentals();
	}
	// STOP TODO IN GRAPHIC MODE
	
	public void createTestSheet(){
		Sheet s = getSheet();
		// We fill the sheet
		s.setGlobalKeySignature(new KeySignature(4,0));
		s.setGlobalRythmSignature(new RythmSignature(4,4));

		// Insert a bar
		Bar b1 = new Bar();
		// Insert a note in the bar
		Note n1 = new Note(4,false,10,3,50);
		Note n2 = new Note(4,false,10,3,50);
		Note n3 = new Note(4,false,9,3,50);
		
		Note n4 = new Note(4,false,9,3,50);
		Note n5 = new Note(4,false,10,3,50);
		Note n6 = new Note(4,false,10,3,50);
//		Note n7 = new Note(4,false,6,3,50);
//		Note n8 = new Note(4,false,6,3,50);

		b1.addNote(n1);
		b1.addAfter(n1,n2);
		b1.addAfter(n2,n3);
		b1.addAfter(n3,n4);
		b1.addAfter(n4,n5);
		b1.addAfter(n5,n6);
//		b1.addAfter(n6,n7);
//		b1.addAfter(n7,n8);
		b1.calculateAccidentals();
		s.addBar(b1);
	}

	int stepTolerance = 16 ; // By default step tolerance is sixteenth note (should be parametrizable)

	public Sheet getSheet(){
		return sheets.get(idCurrentSheet);
	}

	public void switch_sheet(int switch_to_sheet_id) {
		this.idCurrentSheet = switch_to_sheet_id;
	}

	public Vector<Sheet> getSheets() {
		return sheets;
	}

	public void createNewSheet(String title) {
		sheets.add(new Sheet(title));
	}

	public void deleteSheet(int delete_sheet_id) {
		if(delete_sheet_id<sheets.size()){
			sheets.remove(delete_sheet_id);
		}
	}

	public int getRythmMode() {
		return rythmMode;
	}

	public void setRythmMode(int rythmMode) {
		this.rythmMode = rythmMode;
	}

	public Mode getMode() {
		// TODO Auto-generated method stub
		return mode;
	}
	
	


}
