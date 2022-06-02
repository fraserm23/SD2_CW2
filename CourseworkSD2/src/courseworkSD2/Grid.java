package courseworkSD2;

import java.io.Serializable;
import java.util.ArrayList;

public class Grid implements Serializable {

	//class for creating the grid data model
	//it creates row objects which in turn create square objects and creates
	//a full grid
	private static final long serialVersionUID = 1274663932708189593L;

	private int gridSize;
	private int lowAxisNum;
	private int highAxisNum;
	private int squareAmount;
	private ArrayList <Row> theRows;
	
	//sets the above variables in the constructor
	public Grid() {
		gridSize = 4;
		lowAxisNum = 0;
		highAxisNum = this.gridSize - 1;
		squareAmount = this.gridSize * this.gridSize;
		theRows = new ArrayList<Row> ();
		
		//creates row objects to add to 'theRows' array list
		Row tempRow;
		for (int loop = 0; loop < gridSize; loop++) {
			tempRow = new Row(loop, gridSize);
			this.theRows.add(tempRow);
		}
	}
	
	public int getGridSize() {
		return gridSize;
	}

	public void setGridSize(int gridSize) {
		this.gridSize = gridSize;
	}

	public ArrayList<Row> getTheRows() {
		return theRows;
	}

	public void setTheRows(ArrayList<Row> theRows) {
		this.theRows = theRows;
	}

	public int getLowAxisNum() {
		return lowAxisNum;
	}

	public void setLowAxisNum(int lowAxisNum) {
		this.lowAxisNum = lowAxisNum;
	}

	public int getHighAxisNum() {
		return highAxisNum;
	}

	public void setHighAxisNum(int highAxisNum) {
		this.highAxisNum = highAxisNum;
	}

	public int getSquareAmount() {
		return squareAmount;
	}

}
