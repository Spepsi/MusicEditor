package gui;

import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import actions.Action;
import actions.ActionType;
import main.Main;
import main.Sheet;

public class SheetNamesPanel extends JTabbedPane{

	private static final long serialVersionUID = 3626557882076837933L;
	public static Dimension buttonDimension = new Dimension(24,24);

	public SheetNamesPanel(){
		super();
		update();
		this.setTabPlacement(BOTTOM);
		// Adding external actions bar

	}

	private class TabComponent extends JPanel{
		private static final long serialVersionUID = -5602079827923957403L;

		public TabComponent(String title, int index){
			super();
			add(new JLabel(title));
			TabButton bouton = new TabButton(index, Main.icones.getIcone("default"));
			add(bouton);
		}
	}

	private class TabButton extends JButton {
		private static final long serialVersionUID = 3028111188486384972L;
		public int index = 0;
		public TabButton(int index, ImageIcon icone) {
			super( new ImageIcon(icone.getImage().getScaledInstance(buttonDimension.width, buttonDimension.height, Image.SCALE_SMOOTH)));
			this.index = index;
			int size = 24;
			setPreferredSize(new Dimension(size, size));
			setToolTipText("close this tab");
			//Make it transparent
			setContentAreaFilled(false);
			//No need to be focusable
			setFocusable(false);
			setBorder(BorderFactory.createEtchedBorder());
			setBorderPainted(false);
			//Making nice rollover effect
			setRolloverEnabled(true);
			//Close the proper tab by clicking the button
			addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Action.delete_sheet_id = index;
					Action.redoAction(ActionType.DeleteSheet);
				}
			});
		}

	}

	public void update(){
		removeAll();
		int i = 0;
		for(Sheet s : Main.user.getSheets()){
			addTab(s.getTitle(), new SheetPanel(s));
			setTabComponentAt(i, new TabComponent(s.getTitle(),i));

			i++;
		}
		removeChangeListener(changeListener);
		addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(getSelectedIndex()>=0){
					Action.switch_to_sheet_id = getSelectedIndex();
					Action.redoAction(ActionType.SwitchSheet);
				}
			}
		});
	}

}
