package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import elements.Bar;
import elements.Note;
import main.Main;
import main.Sheet;

public class SheetPanel extends JPanel {
	
	public SheetPanel(){
		
	}

	float startX = 0.05f, startY = 0.1f, spaceY = 0.03f;
	float currentPos = 0.1f;
	float startPos = currentPos, endPos;
	float sizePerNote = 0.03f;
	float ratioStep = 0.02f;
	Sheet s = Main.user.getSheet();

	public void paintComponent(Graphics g){
		g.setColor(Color.white);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g.setColor(Color.black);
		for(int i=0; i<5; i++){
			g.drawLine((int)(getWidth()*startX), 
					(int)(getHeight()*(startY+i*spaceY)), 
					(int)(getWidth()*(1.0-startX)), 
					(int)(getHeight()*(startY+i*spaceY)));
		}
		currentPos = 0.1f;
		startPos = currentPos;
		sizePerNote = 0.03f;
		ratioStep = 0.02f;
		// draw first bar
		this.drawBar(g, currentPos, 0);
		for(Bar b : s.getBars()){
			currentPos += ratioStep;
			startPos = currentPos;
			endPos = startPos + sizePerNote*b.getNotes().size();
			g.setColor(Color.BLACK);
			for(Note n : b.getNotes()){
				if(n.isRest()){
					
				} else {
					this.drawNote(g, n, 0);
				}
			}
		}
		
		
	}
	
	public void drawBar(Graphics g, float currentPos, int numPortee){
		g.setColor(Color.DARK_GRAY);
		g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					(int)(getHeight()*(startY+0*spaceY)), 
					(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					(int)(getHeight()*(startY+4*spaceY)));
	}
	
	public void drawNote(Graphics g, Note n, int numPortee){
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
		currentPos = startPos + 1.0f*n.getStartStep()/s.getNbSteps()*(endPos-startPos);
		float relativeHeightTail = 2.5f;
		float relativeHeightTail16 = 2.2f;
		float relativeHeightTail32 = 1.9f;
		switch(n.getDuration()){
		case 2 : g2.setStroke(new BasicStroke(2));
				 g2.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)), 
							(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
		case 1 : g2.drawOval((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
							(int)(computeYNote(n, numPortee)-getHeight()*spaceY/2), 
							(int)(getHeight()*spaceY), 
							(int)(getHeight()*spaceY));
		case 32 : g2.setStroke(new BasicStroke(2));
				g2.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail32*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail32*getHeight()*spaceY));
		case 16 : g2.setStroke(new BasicStroke(2));
				g2.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail16*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail16*getHeight()*spaceY));
		case 8 : g2.setStroke(new BasicStroke(2));
				g2.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
		case 4 : g2.setStroke(new BasicStroke(2));
				g2.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)), 
							(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
				g2.fillOval((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
							(int)(computeYNote(n, numPortee)-getHeight()*spaceY/2), 
							(int)(getHeight()*spaceY), 
							(int)(getHeight()*spaceY));
		break;
		default: break;
		}
	}
	
	public float computeYNote(Note n, int numPortee){
		int h = 5-n.getPitch() + ((n.getOctave()-3)*12);
		float f = (int)(getHeight()*(startY+h*spaceY));
		return f;
	}
}
