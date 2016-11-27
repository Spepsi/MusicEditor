package main;

import java.awt.Dimension;

import javax.swing.JFrame;

import gui.SheetPanel;

public class Main {
	public static User user = new User();
	public static void main(String[] args) {
		User.createTestSheet();
		try {
			JFrame frame = new JFrame("Vaneau");
			frame.setBounds(200, 200, 640, 480);
			frame.setContentPane(new SheetPanel());
			frame.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
