package elements;

import java.util.Vector;

import actions.Action;

public class KeySignature implements Element {

	int nbSharps=0;
	int nbFlats=0;
	int startingNote;
	
	int[] accidents ;
	
	public static int[] NOTES = {0,2,4,5,7,9,11};
	
	
	public boolean isBecarre(Note n){
		for(Integer i : NOTES){
			if(i==n.getPitch()){
				return true;
			}
		}
		return false;
	}
	
	public int diatonicToPitch(int diatonicPitch){
		// Transform diatonic pitch in scale pitch
		diatonicPitch = (diatonicPitch+nbSharps*3+nbFlats*4)%7;
		return (startingNote+NOTES[diatonicPitch])%12;
		
	}
	public KeySignature(int nbFlats, int nbSharps ){
		this.nbFlats = nbFlats;
		this.nbSharps = nbSharps;
		startingNote = (7*nbSharps+5*nbFlats)%12;
		
		if(nbSharps>0){
			accidents = new int[nbSharps];
			for(int i =0; i<nbSharps; i++){
				accidents[i]= (7*(i+1)+11)%12;
				
			}
		}else if(nbFlats>0){
			accidents = new int[nbFlats];
			for(int i =0; i<nbFlats; i++){
				accidents[i]= (5*(i+1)+5)%12;
				
			}
		}else{
			accidents = new int[]{};
		}


		
	}

	public int getRootInterval(Note n){
		return (n.getPitch()-startingNote+12)%12;
	}


	public int getSheetNoteRoot(){ // 0 : C , 1 :D , etc..;
		
		return (4*nbSharps)%7 +(nbFlats*3)%7;
	}
	
	public int getAbsoluteRootTone(Note n){
//		System.out.println((getRootTone(n)+getSheetNoteRoot())%7);
		return (getRootTone(n)+getSheetNoteRoot())%7;
	}
	
	public int getRootTone(Note n){
		int interval = getRootInterval(n);
		if(nbSharps>0 || (nbSharps==0 && nbFlats==0)){
			switch(interval){
			case 0:
				return 0;
			case 1:
				return 0;
			case 2:
				return 1;
			case 3:
				return 1;
			case 4: 
				return 2;
			case 5:
				return 3;
			case 6:
				return 3;
			case 7:
				return 4;
			case 8:
				return 4;
			case 9:
				return 5;
			case 10:
				return 5;
			case 11:
				return 6;
			default:
				return 0;
			}	
		}
		if(nbFlats>0){
			switch(interval){
			case 0:
				return 0;
			case 1:
				return 1;
			case 2:
				return 1;
			case 3:
				return 2;
			case 4: 
				return 2;
			case 5:
				return 3;
			case 6:
				return 4;
			case 7:
				return 4;
			case 8:
				return 5;
			case 9:
				return 5;
			case 10:
				return 6;
			case 11:
				return 6;
			default:
				return 0;
			}
		}
		return 0;

	}

	public boolean isScaleAccident(Note n){
		int value = nbSharps>0 ? -1:1;
		
		for(Integer i : accidents){
//			System.out.println(i+" aha"+(n.getPitch()+value));
			if(i.intValue()==n.getPitch()+value){
				return true;
			}
		}
		return false;
	}
	public int getRootAccidental(Note n){
		int interval = getRootInterval(n);
		// Get if already bemol or sharp in the scale
		int valueBonus = isScaleAccident(n) ? 1:0;
		if(nbFlats>0){
			valueBonus=-valueBonus;
		}
		if(nbSharps>0 || (nbSharps==0 && nbFlats==0)){
			switch(interval){
			case 0:
				return 0;
			case 1:
				return 1+valueBonus;
			case 2:
				return 0;
			case 3:
				return 1+valueBonus;
			case 4: 
				return 0;
			case 5:
				return 0;
			case 6:
				return 1+valueBonus;
			case 7:
				return 0;
			case 8:
				return 1+valueBonus;
			case 9:
				return 0;
			case 10:
				return 1+valueBonus;
			case 11:
				return 0;
			default:
				return 0;
			}	
		}
		if(nbFlats>0){
			switch(interval){
			case 0:
				return 0;
			case 1:
				return -1+valueBonus;
			case 2:
				return 0;
			case 3:
				return -1+valueBonus;
			case 4: 
				return 0;
			case 5:
				return 0;
			case 6:
				return -1+valueBonus;
			case 7:
				return 0;
			case 8:
				return -1+valueBonus;
			case 9:
				return 0;
			case 10:
				return -1+valueBonus;
			case 11:
				return 0;
			default:
				return 0;
			}
		}
		return 0;
	}
	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}
	@Override
	public void print() {
		// TODO Auto-generated method stub
	}




}
