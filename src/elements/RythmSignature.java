package elements;

import actions.Action;

public class RythmSignature implements Element{
	
	
	
	private int first=4;
	private int second=4;
	
	
	public RythmSignature(int first,int second){
		this.first = first;
		this.second = second;
	}
	public int getFirst(){
		return first;
	}
	public int getSecond(){
		return second;
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
