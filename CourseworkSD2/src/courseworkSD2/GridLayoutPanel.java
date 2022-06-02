package courseworkSD2;

import java.awt.Color;

import javax.swing.JPanel;

public class GridLayoutPanel extends JPanel {

	//this class is used to define the panel that the grid is represented in on the GUI
	private static final long serialVersionUID = -5279249020609083069L;

	//the constructor sets the background colour, the size and the position of the panel
	//in the main window
	public GridLayoutPanel() {
		setBackground(new Color(0, 0, 0));
		setBounds(25, 12, 250, 250);
	}
}
