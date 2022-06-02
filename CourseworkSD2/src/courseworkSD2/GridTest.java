package courseworkSD2;

import java.util.ArrayList;

import junit.framework.TestCase;

//this class is for testing the 'Grid' class
public class GridTest extends TestCase {

	Grid theGrid;
	
	public GridTest() {
		theGrid = new Grid();
	}
	
	public void testConstructor() {
		assertTrue(theGrid != null);
	}
	
	//tests the getGridSize method
	public void testGetGridSize() {
		int actual = theGrid.getGridSize();
		int expected = 4;
		
		assertTrue(actual == expected);
	}
	
	//tests the setGridSize method
	public void testSetGridSize() {
		theGrid.setGridSize(5);
		
		int actual = theGrid.getGridSize();
		int expected = 5;
		
		assertTrue(actual == expected);
	}
	
	//tests the getHighAxisNum method
	public void testGetHighAxisNum() {
		int actual = theGrid.getHighAxisNum();
		int expected = theGrid.getGridSize() - 1;
		
		assertTrue(actual == expected);
	}
	
	//tests the getSquareAmount method
	public void testGetSquareAmount() {
		int actual = theGrid.getSquareAmount();
		int expected = 16;
		
		assertTrue(actual == expected);
	}
	
	//tests the getTheRows method
	public void testGetTheRows() {
		ArrayList<Row> theRows = new ArrayList <Row>();
		
		for(int i = 0; i < theGrid.getGridSize(); i++) {
			theRows.add(new Row(i, theGrid.getGridSize()));
		}
		
		int actual = theGrid.getTheRows().size();
		int expected = theRows.size();
		
		assertTrue(actual == expected);			
	}
	
	//tests the setTheRows method
	public void testSetTheRows() {
		ArrayList<Row> theRows = new ArrayList <Row>();
		
		for(int i = 0; i < 5; i++) {
			theRows.add(new Row(i, theGrid.getGridSize()));
		}
		
		theGrid.setTheRows(theRows);
		
		assertTrue(theRows == theGrid.getTheRows());			
	}
}
