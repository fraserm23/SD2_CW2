package courseworkSD2;

import java.io.Serializable;
import java.util.ArrayList;

public class Square implements Serializable {

	private static final long serialVersionUID = -827796999367267312L;
	
	private int xCoordinate;
	private ArrayList <Ship> theShips;

	//the constructor takes in an integer which is set as the x coordinate
	public Square(int number) {
		setXCoordinate(number);
		theShips = new ArrayList <Ship>();
	}

	public int getXCoordinate() {
		return xCoordinate;
	}

	public void setXCoordinate(int xCoordinate) {
		this.xCoordinate = xCoordinate;
	}

	public ArrayList<Ship> getTheShips() {
		return theShips;
	}

	public void setTheShips(ArrayList<Ship> numberOfShips) {
		this.theShips = numberOfShips;
	}
	
}