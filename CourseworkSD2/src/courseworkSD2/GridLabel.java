package courseworkSD2;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class GridLabel extends JLabel {

	//this class is used to create labels to be used on the GUI grid
	private static final long serialVersionUID = 2022341718389457159L;
	
	//the constructor sets some alignment attributes and an empty ImageIcon
	public GridLabel() {
		setHorizontalAlignment(CENTER);
		setVerticalAlignment(CENTER);
		setIcon(new ImageIcon());
	}
}
