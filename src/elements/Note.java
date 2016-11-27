package elements;

import actions.Action;

public class Note implements Element{

public boolean isRest() {
		return rest;
	}

	public boolean isDot() {
		return dot;
	}

	public int getPitch() {
		return pitch;
	}

	public int getOctave() {
		return octave;
	}

	public int getVelocity() {
		return velocity;
	}

	public int getStyle() {
		return style;
	}

private int duration; //1 whole , 2 half , etc ...
private boolean rest;// Rest or real note ?
private boolean dot; // If rythm is dotted or not
private int startStep; // Step where it starts
private int pitch; // From 0 to 12
private int octave; // Octave value
private int velocity; // From ppp to fff 
private int style; // If legato staccato etc ...

private int accidental;
private boolean becarre; // If we have to print a becarre
private int note;// From 0 to 6
private int octaveOffset;
private boolean printAccident =true;

public Note(int duration,boolean dot,int pitch,int octave,int velocity){
	this.duration = duration;
	this.rest = false;
	this.dot = dot;
	this.pitch = pitch;
	this.octave = octave;
	this.velocity = velocity;
}


public Note(int duration,boolean dot,int diatonicPitch, int octave,int velocity, KeySignature key){
	this.duration = duration;
	this.rest = false;
	this.dot = dot;
	this.pitch = key.diatonicToPitch(diatonicPitch);
	this.octave = octave;
	this.velocity = velocity;
}

public void transpose(int change){
	this.pitch += change;
	if(this.pitch==12){
		this.pitch=0;
		this.octave++;
	}else if(this.pitch==-1){
		this.pitch = 11;
		this.octave--;
	}
}

public void diatonicTranspose(int change,KeySignature key){
	// If it is not in key get the nearest toward change;
	
	this.pitch += change;

	pitch += (KeySignature.NOTES[key.getRootTone(this)]-KeySignature.NOTES[(key.getRootTone(this)+change+7)%7]+12)%12;
	
	if(this.pitch==12){
		this.pitch=0;
		this.octave++;
		
	}else if(this.pitch==-1){
		this.pitch = 11;
		
		this.octave--;
	}
	
}

public void setAccidental(int accident){
	accidental = accident;
}
public int getAccidental(){
	return accidental;
}
public void setNote(int note){
	this.note = note;
}
public int getNote(){
	return note;
}


public Note(Note n){
	this.duration = n.duration;
	this.rest = n.rest;
	this.dot = n.dot;
	this.pitch = n.pitch;
	this.octave = n.octave;
	this.velocity = n.velocity;
}
public int getDuration(){
	return duration;
}
public boolean getDotted(){
	return dot;
}

public Note(int duration,boolean dot){
	this.duration = duration;
	this.dot  = dot;
	this.rest = true;
}
public void setStartStep(int startStep){
	this.startStep = startStep;	
}


public boolean equal(Note n){
	return this.pitch==n.pitch && this.octave==n.octave;
}

@Override
public void draw() {
	// TODO Auto-generated method stub	
}


@Override
public void print() {
	// TODO Auto-generated method stub
	System.out.print("pitch:"+pitch+" octave:"+octave+" duration:"+duration+"startstep:"+startStep+"");
}

public int getStartStep() {
	// TODO Auto-generated method stub
	return startStep;
}

public boolean getBecarre() {
	return becarre;
}

public void setBecarre(boolean becarre) {
	this.becarre = becarre;
}

public int getOctaveOffset() {
	return octaveOffset;
}

public void setOctaveOffset(int octaveOffset) {
	this.octaveOffset = octaveOffset;
}

public boolean isPrintAccident() {
	return printAccident;
}

public void setPrintAccident(boolean printAccident) {
	this.printAccident = printAccident;
}


}
