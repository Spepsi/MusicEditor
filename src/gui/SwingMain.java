package gui;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.border.EmptyBorder;
import java.awt.BorderLayout;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingMain frame = new SwingMain();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public SwingMain() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 691, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		JMenuBar menuBar;

		// Création de la bar de menu
		menuBar = MenuBar.getMenuBar();
		setJMenuBar(menuBar);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = ItemBarPanel.getItemBarPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		
	}

}
