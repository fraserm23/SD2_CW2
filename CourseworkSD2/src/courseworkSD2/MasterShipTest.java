package courseworkSD2;

import junit.framework.TestCase;

//this class tests the 'MasterShip' class
public class MasterShipTest extends TestCase {

	MasterShip theShip;
	
	public MasterShipTest() {
		theShip = new MasterShip();
	}
	
	public void testConstructor() {
		assertTrue(theShip != null);
	}
	
	//this tests the getEnemyCapacity method
	public void testGetEnemyCapacity() {
		int actual = theShip.getEnemyCapacity();
		int expected = 1;
		
		assertTrue(actual == expected);
	}
	
	//this tests switching the master ship's mode
	public void testSwitchMode() {
		theShip.setMasterShipMode(new OffensiveMode());
		
		int actual = theShip.getEnemyCapacity();
		int expected = 2;
		
		assertTrue(actual == expected);
	}

}
