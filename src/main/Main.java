package main;
import elements.Bar;
import elements.KeySignature;
import elements.RythmSignature;

public class Main {
	public static User user = new User();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sheet s = user.getSheet();
		// We fill the sheet
		s.setGlobalKeySignature(new KeySignature(0,0));
		s.setGlobalRythmSignature(new RythmSignature(4,4));
		
		// Insert a bar
		Bar b1 = new Bar();
	}

}
