package main;

import javax.swing.JFrame;

import gui.SwingMain;
import ressources.Icones;
import ressources.Images;

public class Main {
	
	public static User user = new User();
	public static Icones icones = new Icones();
	public static Images images = new Images();
	public static SwingMain frame;
	
	public static void main(String[] args) {
		user.createTestSheet();
		try {
			frame = new SwingMain();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
