package ressources;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;



public class Images {
	private HashMap<String, BufferedImage> images;

	public Images(){
		images = new HashMap<String, BufferedImage>();
		try {
			images.put("default", ImageIO.read(new File("img/default.png")));
			this.loadRepertoire("img/elements/");
		} catch (IOException e) {}

	}
	
	public Image getIcone(String name){
		if(images.containsKey(name)){
			return images.get(name);
		} else {
			return images.get("default");
		}
	}

	private void loadRepertoire(String name) throws IOException{
		File repertoire = new File(name);
		File[] files=repertoire.listFiles();
		String s;
		Image im;
		for(int i=0; i<files.length; i++){
			s = files[i].getName();
			if(s.contains(".png")){
				// on load l'image
				s = s.substring(0, s.length()-4);
				this.images.put(s.toLowerCase(),ImageIO.read(new File(name+s+".png")));
				//					f = Images.class.getField(s);
				//					f.set(this, im);
				//this.images.put(s, new Image(name+s+".png"));
			} else if(s.contains(".jpg")){
				// on load l'image
				s = s.substring(0, s.length()-4);
				this.images.put(s.toLowerCase(),ImageIO.read(new File(name+s+".jpg")));
				//this.images.put(s, new Image(name+s+".jpg"));
			} else if (!s.contains(".") && !s.equals("unit")){
				// nouveau répertoire
				this.loadRepertoire(name+s+"/");

			}
		} 
	}
}



