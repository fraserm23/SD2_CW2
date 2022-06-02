package courseworkSD2;

import java.util.ArrayList;

import junit.framework.TestCase;

//this class tests the 'Row' class
public class RowTest extends TestCase {

	Row theRow;
	int yCoord, gridSize;
	
	public RowTest() {
		yCoord = 0;
		gridSize = 4;
		theRow = new Row(yCoord, gridSize);
	}
	
	public void testConstructor() {
		assertTrue(theRow != null && theRow.getYCoordinate() == yCoord);
	}
	
	//tests the getYCoord method
	public void testGetYCoord() {
		int actual = theRow.getYCoordinate();
		int expected = yCoord;
		
		assertTrue(actual == expected);
	}
	
	//tests the setYCoord method
	public void testSetYCoord() {
		theRow.setYCoordinate(1);
		
		int actual = theRow.getYCoordinate();
		int expected = 1;
		
		assertTrue(actual == expected);
	}
	
	//tests the getRowSize method
	public void testGetRowSize() {
		int actual = theRow.getRowSize();
		int expected = 4;
		
		assertTrue(actual == expected);
	}
	
	//tests the setRowSize method
	public void testSetRowSize() {
		theRow.setRowSize(5);
		
		int actual = theRow.getRowSize();
		int expected = 5;
		
		assertTrue(actual == expected);
	}
	
	//tests the getTheSquares method
	public void testGetTheSquares() {
		ArrayList<Square> theSquares = new ArrayList <Square>();
		
		for(int i = 0; i < theRow.getRowSize(); i++) {
			theSquares.add(new Square(i));
		}
		
		int actual = theRow.getTheSquares().size();
		int expected = theSquares.size();
		
		assertTrue(actual == expected);
				
	}
	
	//tests the setTheSquares method
	public void testSetTheSquares() {
		ArrayList<Square> theSquares = new ArrayList <Square>();
		
		for(int i = 0; i < theRow.getRowSize(); i++) {
			theSquares.add(new Square(i));
		}
		
		theRow.setTheSquares(theSquares);
		
		assertTrue(theSquares == theRow.getTheSquares());
				
	}

}
