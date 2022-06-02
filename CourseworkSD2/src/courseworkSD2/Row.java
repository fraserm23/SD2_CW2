package courseworkSD2;

import java.io.Serializable;
import java.util.ArrayList;

public class Row implements Serializable {

	//this class represents each row of squares on the grid
	private static final long serialVersionUID = 8528392448768097100L;
	
	private int yCoordinate;
	private int rowSize;
	private ArrayList <Square> theSquares;
	
	//this constructor takes in two integers that are used to set the size of the
	//row and the y coordinate of the row
	public Row(int number, int gridSize) {
		rowSize = gridSize;
		theSquares = new ArrayList <Square> ();
		Square tempSquare;
		setYCoordinate(number);
		//creates square objects and adds them to 'theSquares' array list
		for (int loop = 0; loop < rowSize; loop++) {
			tempSquare = new Square(loop);
			this.theSquares.add(tempSquare);
		}
	}

	public int getYCoordinate() {
		return yCoordinate;
	}

	public void setYCoordinate(int yCoordinate) {
		this.yCoordinate = yCoordinate;
	}

	public int getRowSize() {
		return rowSize;
	}

	public void setRowSize(int rowSize) {
		this.rowSize = rowSize;
	}

	public ArrayList<Square> getTheSquares() {
		return theSquares;
	}

	public void setTheSquares(ArrayList<Square> theSquares) {
		this.theSquares = theSquares;
	}

}
