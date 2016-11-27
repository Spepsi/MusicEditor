package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

import main.Main;

public class SwingMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8503157207806339141L;
	private JPanel contentPane;
	private static SheetNamesPanel sheetsPane;

	
	/**
	 * Create the frame.
	 */
	public SwingMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1920, 1080);
		contentPane = new JPanel();
		setContentPane(contentPane);

		// Création de la bar de menu
		setJMenuBar(MenuBar.getMenuBar());
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(new ItemBarPanel(contentPane), BorderLayout.NORTH);
		sheetsPane = new SheetNamesPanel();
		contentPane.add(sheetsPane, BorderLayout.CENTER);
	}
	
	public static SheetNamesPanel getSheetsPane(){
		return sheetsPane;
	}

}
