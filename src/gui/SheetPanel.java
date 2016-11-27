package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Vector;

import javax.swing.JPanel;

import elements.Bar;
import elements.Note;
import main.Main;
import main.Sheet;

public class SheetPanel extends JPanel {
	

	float startX = 0.05f, startY = 0.1f, spaceY = 0.03f;
	float currentPos = 0.1f;
	float startPos = currentPos, endPos;
	float sizePerNote = 0.03f;
	float ratioStep = 0.02f;
	Sheet s;
	
	Vector<Integer> currentSharps = new Vector<Integer>();
	Vector<Integer> currentFlats = new Vector<Integer>();
	
	public SheetPanel(Sheet s){
		this.s = s;
	}
	

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
					this.drawNote(g, n, b, 0);
				}
			}
			this.currentFlats.clear();
			this.currentSharps.clear();
		}
		
		
	}
	
	public void drawBar(Graphics g, float currentPos, int numPortee){
		g.setColor(Color.DARK_GRAY);
		g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					(int)(getHeight()*(startY+0*spaceY)), 
					(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					(int)(getHeight()*(startY+4*spaceY)));
	}
	
	public void drawNote(Graphics g, Note n,Bar b, int numPortee){
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
		currentPos = startPos + 1.0f*n.getStartStep()/s.getNbSteps()*(endPos-startPos);
		float relativeHeightTail = 2.5f;
		float relativeHeightTail16 = 2.2f;
		float relativeHeightTail32 = 1.9f;
		// Draw accident
		if(!b.getKeyNotes().contains(n.getPitch())){
			g2.drawString("#",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
			(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
		}
		//Draw duration
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
		float h = 5-0.5f*convertPitchToNote(n.getPitch())- (n.getOctave()-3)*3.5f;
		float f = (int)(getHeight()*(startY+h*spaceY));
		return f;
	}
	
	public boolean shouldBeSharp(Note n,int numPortee){
		
		
		return false;
		
	}
	public int convertPitchToNote(int pitch){
		switch(pitch){
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
	
}
