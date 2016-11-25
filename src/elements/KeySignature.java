package elements;

import actions.Action;

public class KeySignature implements Element {

	int nbSharps=0;
	int nbFlats=0;
	
	public KeySignature(int nbFlats, int nbSharps ){
		this.nbFlats = nbFlats;
		this.nbSharps = nbSharps;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		
	}

	
	
}
