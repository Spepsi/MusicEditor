package main;
import java.util.Vector;

import actions.Action;
import elements.Bar;
import elements.Element;
import elements.KeySignature;
import elements.RythmSignature;

public class Sheet implements Element{
	private KeySignature globalKeySignature = new KeySignature(0,0); // By default at the start of the song
	private RythmSignature globalRythmSignature = new RythmSignature(4,4); // By default at the start of the song
	private Vector<Bar> bars = new Vector<Bar>();
	private String title;
	private String subtitle;
	private String date;
	int nbsteps = 96;// Smallest step possible (for representing starts ...) // Depends on the bar
	
	public Sheet(){
		this.title = "New Sheet";
		this.subtitle = "";
	}
	
	public Sheet(String title){
		this.title = title;
		this.subtitle = "";
	}
	
	public int getNbSteps(){
		return nbsteps;
	}
	public void addBar(Bar b){
		bars.addElement(b);
		
	}
	public KeySignature getGlobalKeySignature() {
		return globalKeySignature;
	}


	public void setGlobalKeySignature(KeySignature globalKeySignature) {
		this.globalKeySignature = globalKeySignature;
	}


	public RythmSignature getGlobalRythmSignature() {
		return globalRythmSignature;
	}


	public void setGlobalRythmSignature(RythmSignature globalRythmSignature) {
		this.globalRythmSignature = globalRythmSignature;
	}


	public Vector<Bar> getBars() {
		return bars;
	}


	public void setBars(Vector<Bar> bars) {
		this.bars = bars;
	}


	public String getTitle() {
		return title;
	}


	public String getSubtitle() {
		return subtitle;
	}


	public String getDate() {
		return date;
	}

	
	
	
	
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}
	
	
	public void setTitle(String title){
		this.title = title;
	}
	public void setSubtitle(String title){
		this.subtitle = title;
	}
	public void setDate(String date){
		this.date = date;
	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
		for(Bar b : bars){
			b.print();
			System.out.println();
		}
	}
	
	
	
}
