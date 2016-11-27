package gui;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

public class SwingMain extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8503157207806339141L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			SwingMain frame = new SwingMain();
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 478);
		contentPane = new JPanel();
		setContentPane(contentPane);

		JMenuBar menuBar;

		// Création de la bar de menu
		setJMenuBar(MenuBar.getMenuBar());
		contentPane.setLayout(new BorderLayout(0, 0));

		contentPane.add(new ItemBarPanel(contentPane), BorderLayout.NORTH);
		contentPane.add(new SheetPanel(), BorderLayout.CENTER);
	}

}
