package ressources;


import javax.swing.ImageIcon;

public enum Icones {
		newFile("new_file.png"),
		openFile("open_file.png"),
		saveFile("save_file.png"),
		copy("copy.png"),
		paste("paste.png"),
		redo("redo.png"),
		undo("undo.png"),
		defaut("default.png");
		private ImageIcon i;
		private Icones (String p_fichier_image){
			i = new ImageIcon("img/icones/"+p_fichier_image);
		}
		public ImageIcon image(){return i;}
	}
