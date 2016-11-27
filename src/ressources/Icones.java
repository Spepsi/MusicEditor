package ressources;


import java.io.File;
import java.util.HashMap;

import javax.swing.ImageIcon;


public class Icones {
	private HashMap<String, ImageIcon> images;

	public Icones(){
		images = new HashMap<String, ImageIcon>();
		images.put("default", new ImageIcon("img/default.png"));
		this.loadRepertoire("img/icones/");
	}
	
	public ImageIcon getIcone(String name){
		if(images.containsKey(name)){
			return images.get(name);
		} else {
			return images.get("default");
		}
	}

	private void loadRepertoire(String name){
		File repertoire = new File(name);
		File[] files=repertoire.listFiles();
		String s;
		ImageIcon im;
		for(int i=0; i<files.length; i++){
			s = files[i].getName();
			if(s.contains(".png")){
				// on load l'image
				s = s.substring(0, s.length()-4);
				im = new ImageIcon(name+s+".png");
				this.images.put(s.toLowerCase(),im);
				//					f = Images.class.getField(s);
				//					f.set(this, im);
				//this.images.put(s, new Image(name+s+".png"));
			} else if(s.contains(".jpg")){
				// on load l'image
				s = s.substring(0, s.length()-4);
				im = new ImageIcon(name+s+".jpg");
				this.images.put(s,im);
				//this.images.put(s, new Image(name+s+".jpg"));
			} else if(s.contains(".svg")){
				// on load l'image
				s = s.substring(0, s.length()-4);
				im = new ImageIcon(name+s+".svg");
				this.images.put(s,im);
				//this.images.put(s, new Image(name+s+".svg"));
			} else if (!s.contains(".") && !s.equals("unit")){
				// nouveau répertoire
				this.loadRepertoire(name+s+"/");

			}
		} 
	}
}



