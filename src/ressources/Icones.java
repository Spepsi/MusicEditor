package ressources;

import javax.swing.Icon;
import javax.swing.ImageIcon;

public enum Icones {
		newFile("new_file.png"),
		openFile("open_file.png"),
		saveFile("save_file.png"),
		defaut("default.png");
		private Icon i;
		private Icones (String p_fichier_image){
			i = new ImageIcon("img/icones/"+p_fichier_image);
		}
		public Icon image(){return i;}
	}
