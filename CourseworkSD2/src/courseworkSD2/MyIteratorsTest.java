package courseworkSD2;

import java.util.ArrayList;

import junit.framework.TestCase;

//tests the 'MyIterators' class
public class MyIteratorsTest extends TestCase {
	
	MyIterators itr = new MyIterators();
	Game theGame;
	ArrayList <EnemyShip> theEnemyShips;
	ArrayList <Ship> theShips;
	Square theSquare;

	public MyIteratorsTest() {
		theGame = new Game();
		theEnemyShips = new ArrayList <EnemyShip>();
		theShips = new ArrayList <Ship>();
		theSquare = new Square(0);
	}
	
	public void testConstructor() {
		assertTrue(itr != null);
	}
	
	//tests the EnemyShip iterator
	public void testEnemyShipIterator() {
		BattleCruiser bcShip = new BattleCruiser();
		BattleStar bsShip = new BattleStar();
		theEnemyShips.add(bsShip);
		theEnemyShips.add(bcShip);
		
		theSquare.getTheShips().add(bsShip);
		theSquare.getTheShips().add(bcShip);
		
		itr.enemyShipIterator(theEnemyShips, theSquare);
		
		assertTrue(theEnemyShips.size() == 0);
	}
	
	//tests the Ship iterator
	public void testSquareShipIterator() {
		MasterShip masterShip = theGame.getMasterShip();
		BattleCruiser bcShip = new BattleCruiser();
		BattleStar bsShip = new BattleStar();
		theShips.add(masterShip);
		theEnemyShips.add(bsShip);
		theEnemyShips.add(bcShip);
		
		itr.squareShipIterator(theShips, theGame);
		
		assertTrue(theShips.get(0) == masterShip);
	}
	
	

}
