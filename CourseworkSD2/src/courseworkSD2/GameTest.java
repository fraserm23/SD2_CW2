package courseworkSD2;

import junit.framework.TestCase;

public class GameTest extends TestCase {

	Game theGame;
	
	//this class is for testing the game class
	public GameTest()  {
		theGame = new Game();
	}
	
	public void testConstructor() {
		assertTrue(theGame != null);
	}
	
	//tests the setShip method
	public void testSetShip() {
		int xCoord = 0;
		int yCoord = 0;
		MasterShip theShip = new MasterShip();
		
		theGame.setShip(xCoord, yCoord, theShip);
		
		Ship actual = theGame.getTheGrid().getTheRows().get(yCoord).getTheSquares().get(xCoord).getTheShips().get(0);
		Ship expected = theShip;
		
		assertTrue(actual == expected);
	}
	
	//tests the getNewCoord method for a 'zero' coordinate
	public void testGetNewCoordZero() {
		int oldCoord = 0;
		boolean newCoord;
		
		switch(theGame.getNewCoord(oldCoord)) {
		case 0:
			newCoord = true;
			break;
		case 1:
			newCoord = true;
			break;
		case 2:
			newCoord = false;
			break;
		case 3:
			newCoord = false;
			break;
		default:
			newCoord = false;
			break;
		}
		
		assertTrue(newCoord == true);
	}
	
	//tests the getNewCoord method for a 'one' coordinate
	public void testGetNewCoordOne() {
		int oldCoord = 1;
		boolean newCoord;
		
		switch(theGame.getNewCoord(oldCoord)) {
		case 0:
			newCoord = true;
			break;
		case 1:
			newCoord = true;
			break;
		case 2:
			newCoord = true;
			break;
		case 3:
			newCoord = false;
			break;
		default:
			newCoord = false;
			break;
		}
		
		assertTrue(newCoord == true);
	}
	
	//tests the getNewCoord method for a 'two' coordinate
	public void testGetNewCoordTwo() {
		int oldCoord = 2;
		boolean newCoord;
		
		switch(theGame.getNewCoord(oldCoord)) {
		case 0:
			newCoord = false;
			break;
		case 1:
			newCoord = true;
			break;
		case 2:
			newCoord = true;
			break;
		case 3:
			newCoord = true;
			break;
		default:
			newCoord = false;
			break;
		}
		
		assertTrue(newCoord == true);
	}
	
	//tests the getNewCoord method for a 'three' coordinate
	public void testGetNewCoordThree() {
		int oldCoord = 3;
		boolean newCoord;
		
		switch(theGame.getNewCoord(oldCoord)) {
		case 0:
			newCoord = false;
			break;
		case 1:
			newCoord = false;
			break;
		case 2:
			newCoord = true;
			break;
		case 3:
			newCoord = true;
			break;
		default:
			newCoord = false;
			break;
		}
		
		assertTrue(newCoord == true);
	}
	
	//tests the setMasterShipMode method
	public void testMasterShipModeSwitch() {
		theGame.setMasterShipMode();
		
		int actual = theGame.getMasterShip().getEnemyCapacity();
		int expected = 2;
		
		assertTrue(actual == expected);
	}
	
	//tests the setMasterShip method
	public void testSetMasterShip() {
		boolean shipCreated = false;
		theGame.setMasterShip();
		
		for(Row tempRow : theGame.getTheGrid().getTheRows()) {
			for(Square tempSquare : tempRow.getTheSquares()) {
				if(tempSquare.getTheShips().contains(theGame.getMasterShip())) {
					shipCreated = true;
				}
			}
		}
		
		assertTrue(shipCreated == true);
	}
	
	//tests the addObserver method
	public void testAddObserver() {
		GUI newGUI = new GUI(theGame);
		
		theGame.addObserver(newGUI);
		
		assertTrue(newGUI == theGame.getTheGUIObservers().get(0));
	}
	
}
