package gui;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import elements.Bar;
import elements.Note;
import main.Sheet;

public class SheetPanel extends JPanel {
	
	private static final long serialVersionUID = -8498055105407401541L;
	int offsetY = 0;
	float startX = 0.05f, startYBar = 0.4f, spaceY = 0.03f;
	float startYTitle = 0.05f, sizeYTitle = 0.2f;
	float currentPos = 0.1f;
	float startPos = currentPos, endPos;
	float sizePerNote = 0.03f;
	float ratioStep = 0.02f;
	Sheet s;
	
	Font titleFont = new Font("P22 Morris Golden", Font.PLAIN, 48);
	JTextField titleField;
	Font subtitleFont = new Font("P22 Morris Golden", Font.ITALIC, 32);
	JTextField subtitleField;
	
	Vector<Integer> currentSharps = new Vector<Integer>();
	Vector<Integer> currentFlats = new Vector<Integer>();
	
	public SheetPanel(Sheet s){
		this.s = s;
		add(createTitlePanel());
	}
	

	public void paintComponent(Graphics g){
		Graphics2D g2 = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(
	             RenderingHints.KEY_TEXT_ANTIALIASING,
	             RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
	    g2.setRenderingHints(rh);
		g2.setColor(Color.white);
		g2.fillRect(0, 0, this.getWidth(), this.getHeight());
		
		g2.setColor(Color.black);
		for(int i=0; i<5; i++){
			g2.drawLine((int)(getWidth()*startX), 
					offsetY+(int)(getHeight()*(startYBar+i*spaceY)), 
					(int)(getWidth()*(1.0-startX)), 
					offsetY+(int)(getHeight()*(startYBar+i*spaceY)));
		}
		currentPos = 0.1f;
		startPos = currentPos;
		sizePerNote = 0.03f;
		ratioStep = 0.02f;
		// draw first bar
		this.drawBar(g2, currentPos, 0);
		for(Bar b : s.getBars()){
			currentPos += ratioStep;
			startPos = currentPos;
			endPos = startPos + sizePerNote*b.getNotes().size();
			g2.setColor(Color.BLACK);
			for(Note n : b.getNotes()){
				if(n.isRest()){
					
				} else {
					this.drawNote(g2, n, b, 0);
				}
			}

		}
		
		
	}
	
	public JPanel createTitlePanel(){
		JPanel panTitle = new JPanel();
		panTitle.setBackground(Color.white);
		panTitle.setBorder(BorderFactory.createLineBorder(Color.black, 1));
		panTitle.setPreferredSize(new Dimension(500,200));
		// Creating Title
		titleField = new JTextField(s.getTitle());
		titleField.setPreferredSize(new Dimension(400,80));
		titleField.setHorizontalAlignment(JTextField.CENTER);
		Font f = titleFont;
		int i= titleFont.getSize();
		do{
			f = new Font(titleFont.getName(), titleFont.getStyle(), i);
			titleField.setFont(f);
			i--;
		} while(titleField.getFontMetrics(f).stringWidth(titleField.getText())>=400);
		titleField.setBorder(BorderFactory.createEmptyBorder());
		titleField.setBackground(Color.white);
		titleField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setTitle(titleField.getText());
				SwingMain.getSheetsPane().update();
			}
		});
		titleField.getDocument().addDocumentListener(createDocumentListener(titleField, titleFont));
		panTitle.add(titleField);
		// Creating subtitle
		subtitleField = new JTextField(s.getSubtitle());
		subtitleField.setPreferredSize(new Dimension(400,80));
		subtitleField.setHorizontalAlignment(JTextField.CENTER);
		f = subtitleFont;
		i= subtitleFont.getSize();
		do{
			f = new Font(subtitleFont.getName(), subtitleFont.getStyle(), i);
			subtitleField.setFont(f);
			i--;
		} while(subtitleField.getFontMetrics(f).stringWidth(subtitleField.getText())>=400);
		subtitleField.setBorder(BorderFactory.createEmptyBorder());
		subtitleField.setBackground(Color.white);
		subtitleField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				s.setSubtitle(subtitleField.getText());
				SwingMain.getSheetsPane().update();
			}
		});
		subtitleField.getDocument().addDocumentListener(createDocumentListener(subtitleField, subtitleFont));
		panTitle.add(subtitleField);
		return panTitle;
	}
	
	public DocumentListener createDocumentListener(JTextField textField, Font font){
		return new DocumentListener() {
			public void changedUpdate(DocumentEvent arg0) {
				performAction();
			}
			public void insertUpdate(DocumentEvent arg0) {
				performAction();
			}
			public void removeUpdate(DocumentEvent arg0) {
				performAction();
			}
			public void performAction(){
				int i = font.getSize();
				Font f = font;
				do{
					f = new Font(font.getName(), font.getStyle(), i);
					textField.setFont(f);
					i--;
				} while(textField.getFontMetrics(f).stringWidth(textField.getText())>=textField.getWidth());
			}
		};
	}
	
	
	public void drawBar(Graphics2D g, float currentPos, int numPortee){
		g.setColor(Color.DARK_GRAY);
		g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					offsetY+(int)(getHeight()*(startYBar+0*spaceY)), 
					(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
					offsetY+(int)(getHeight()*(startYBar+4*spaceY)));
	}
	
	public void drawNote(Graphics2D g, Note n,Bar b, int numPortee){
		
		currentPos = startPos + 1.0f*n.getStartStep()/s.getNbSteps()*(endPos-startPos);
		float relativeHeightTail = 2.5f;
		float relativeHeightTail16 = 2.2f;
		float relativeHeightTail32 = 1.9f;
		// Draw accident
		if(n.isPrintAccident()){
			
			if(n.getAccidental()==1){
				
				g.drawString("#",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
				(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
			}
			if(n.getAccidental()==2){
				
				g.drawString("x",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
				(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
			}
			if(n.getAccidental()==-1){
				
				g.drawString("b",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
				(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
			}
			if(n.getAccidental()==-2){
				
				g.drawString("bb",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
				(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
			}
			if(n.getBecarre()){
				g.drawString("a",-10f*getWidth()/640f+getWidth()*startX+getWidth()*(1-2*startX)*currentPos, 
				(int)(computeYNote(n, numPortee)+getHeight()*spaceY/2));
			}
		}
		// Becarre !
		//Draw duration
		switch(n.getDuration()){
		case 2 : g.setStroke(new BasicStroke(2));
				 g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)), 
							(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
		case 1 : g.drawOval((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
							(int)(computeYNote(n, numPortee)-getHeight()*spaceY/2), 
							(int)(getHeight()*spaceY), 
							(int)(getHeight()*spaceY));
		case 32 : g.setStroke(new BasicStroke(2));
				g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail32*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail32*getHeight()*spaceY));
		case 16 : g.setStroke(new BasicStroke(2));
				g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail16*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail16*getHeight()*spaceY));
		case 8 : g.setStroke(new BasicStroke(2));
				g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1+getHeight()*spaceY),
						(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY), 
						(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
						(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
		case 4 : g.setStroke(new BasicStroke(2));
				g.drawLine((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)), 
							(int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos+getHeight()*spaceY-1),
							(int)(computeYNote(n, numPortee)-relativeHeightTail*getHeight()*spaceY));
				g.fillOval((int)(getWidth()*startX+getWidth()*(1-2*startX)*currentPos), 
							(int)(computeYNote(n, numPortee)-getHeight()*spaceY/2), 
							(int)(getHeight()*spaceY), 
							(int)(getHeight()*spaceY));
		break;
		default: break;
		}
	}
	
	public float computeYNote(Note n, int numPortee){

		int octave = n.getOctave();
		if(n.getAccidental()==1 && n.getNote()==6){
			
			octave-=1;
		}
		if(n.getAccidental()==-1 && n.getNote()==0){
			
			octave+=1;
		}
		float h = 5-0.5f*(n.getNote())- (octave-3)*3.5f;
		float f = (int)(getHeight()*(startYBar+h*spaceY));
		return f;
	}
	
	public boolean shouldBeSharp(Note n,int numPortee){
		
		
		return false;
		
	}

		
		
}
	

