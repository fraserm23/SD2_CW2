package courseworkSD2;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class GridPanel extends JPanel {

	//this class is used for each square in the grid
	private static final long serialVersionUID = 1574391624282660133L;
	
	private Square square;
	private GridLabel label;
	Border border = BorderFactory.createLineBorder(Color.WHITE, 2);
	
	public GridPanel() {
		//creates a grid label to be used in the panel
		label = new GridLabel();
		this.add(label);
		setBackground(new Color(0, 0, 0));
		//makes the layout manager create a single space in the grid panel
		setLayout(new GridLayout(1,1));
		//sets the border of the panel to be white
		setBorder(border);
	}

	public Square getSquare() {
		return square;
	}
	
	public void setSquare(Square square) {
		this.square = square;
	}

	public GridLabel getLabel() {
		return label;
	}

	public void setLabel(GridLabel label) {
		this.label = label;
	}
}
