package elements;

import actions.Action;

public class Note implements Element{

private int duration; //1 whole , 2 half , etc ...
private boolean rest;// Rest or real note ?
private boolean dot; // If rythm is dotted or not
private int startStep; // Step where it starts
private int pitch; // From 0 to 12
private int octave; // Octave value
private int velocity; // From ppp to fff 
private int style; // If legato staccato etc ...


public Note(int duration,boolean dot,int pitch,int octave,int velocity){
	this.duration = duration;
	this.rest = false;
	this.dot = dot;
	this.pitch = pitch;
	this.octave = octave;
	this.velocity = velocity;
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


}
