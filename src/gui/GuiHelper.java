package gui;

import java.awt.Graphics;

public class GuiHelper {

	public static void drawCenteredString(Graphics g, String str, int x, int y){
		int sizeX = g.getFontMetrics().stringWidth(str);
		int sizeY = g.getFontMetrics().getHeight();
		System.out.println(sizeY);
		g.drawString(str, x-sizeX/2, y-sizeY/2);
	}
}
