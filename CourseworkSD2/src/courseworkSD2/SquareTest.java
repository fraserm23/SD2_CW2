package courseworkSD2;

import java.util.ArrayList;

import junit.framework.TestCase;

//this class is for testing the 'Square' class
public class SquareTest extends TestCase {

	Square theSquare;
	int xCoord;
	
	public SquareTest() {
		xCoord = 0;
		theSquare = new Square(xCoord);
	}
	
	public void testConstructor() {
		assertTrue(theSquare != null && theSquare.getXCoordinate() == xCoord);
	}
	
	//this method tests the getXCoord method
	public void testGetXCoord() {
		int actual = theSquare.getXCoordinate();
		int expected = xCoord;
		
		assertTrue(actual == expected);
	}
	
	//this method tests the setXCoord method
	public void testSetXCoordSet() {
		theSquare.setXCoordinate(1);
		
		int actual = theSquare.getXCoordinate();
		int expected = 1;
		
		assertTrue(actual == expected);
	}
	
	//this method tests the getTheShips method
	public void testGetTheShips() {
		MasterShip theShip = new MasterShip();
		
		theSquare.getTheShips().add(theShip);
		
		int actual = theSquare.getTheShips().size();
		int expected = 1;
		
		assertTrue(actual == expected);
	}
	
	//this method tests the setTheShips method
	public void testSetTheShips() {
		BattleCruiser enemyShipOne = new BattleCruiser();
		BattleStar enemyShipTwo = new BattleStar();
		
		ArrayList<Ship> theEnemyShips = new ArrayList<Ship>();
		
		theEnemyShips.add(enemyShipOne);
		theEnemyShips.add(enemyShipTwo);
		
		theSquare.setTheShips(theEnemyShips);
		
		assertTrue(theEnemyShips == theSquare.getTheShips());
	}

}
