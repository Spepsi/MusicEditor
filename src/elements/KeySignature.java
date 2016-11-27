package elements;

import java.util.Vector;

import actions.Action;

public class KeySignature implements Element {
	
	public static int[] NATURAL = new int[]{0,2,4,5,7,9,11};
	public static int[] SHARPS  = new int[]{6,1,8,3,10,5,0};
	public static int[] TO_SHARP  = new int[]{5,0,7,2,9,4,11};
	public static int[] FLATS  = new int[]{10,3,8,1,6,11,4};
	public static int[] TO_FLAT  = new int[]{9,2,7,0,5,10,3};
	
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
	@Override
	public void print() {
		// TODO Auto-generated method stub
	}
	
	public Vector<Integer> getNotes(){
		Vector<Integer> result = new Vector<Integer>();
		
		for(Integer i : NATURAL){
			if(sharps().contains(i)){
				result.add((i+1)%12);
			}
			if(sharps().contains(i)){
				result.add((i+11)%12);
			}else{
				result.add(i);
			}
		}
		return result;
	}
	
	public Vector<Integer> sharps(){
		Vector<Integer> result = new Vector<Integer>();
		for(int i =0;i<nbSharps; i++){
			result.add(SHARPS[i]);
		}
		return result;
	}
	public Vector<Integer> to_sharp(){
		Vector<Integer> result = new Vector<Integer>();
		for(int i =0;i<nbSharps; i++){
			result.add(TO_SHARP[i]);
		}
		return result;
	}

	
	public Vector<Integer> flats(){
		Vector<Integer> result = new Vector<Integer>();
		for(int i =0;i<nbFlats; i++){
			result.add(FLATS[i]);
		}
		return result;
	}
	public Vector<Integer> to_flat(){
		Vector<Integer> result = new Vector<Integer>();
		for(int i =0;i<nbFlats; i++){
			result.add(TO_FLAT[i]);
		}
		return result;
	}
	
	
}
