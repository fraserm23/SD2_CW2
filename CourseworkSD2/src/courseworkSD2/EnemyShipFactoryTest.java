package courseworkSD2;

import junit.framework.TestCase;

//this test class if for testing the EnemeyShipFactory class
public class EnemyShipFactoryTest extends TestCase {

	EnemyShipFactory theFactory;
	
	public EnemyShipFactoryTest() {
		theFactory = new EnemyShipFactory();
	}
	
	public void testConstructor() {
		assertTrue(theFactory != null);
	}
	
	//this tests the creation of a battle cruiser enemy ship
	public void testBattleCruiser() {
		int cruiserNum = 0;
				
		EnemyShip actual = theFactory.makeEnemyShip(cruiserNum);
		EnemyShip expected = new BattleCruiser();
		
		assertTrue(actual.getType() == expected.getType());
	}
	
	//this tests the creation of a battle shooter enemy ship
	public void testBattleShooter() {
		int shooterNum = 1;
				
		EnemyShip actual = theFactory.makeEnemyShip(shooterNum);
		EnemyShip expected = new BattleShooter();
		
		assertTrue(actual.getType() == expected.getType());
	}
	
	//this tests the creation of a battle star enemy ship
	public void testBattleStar() {
		int starNum = 2;
				
		EnemyShip actual = theFactory.makeEnemyShip(starNum);
		EnemyShip expected = new BattleStar();
		
		assertTrue(actual.getType() == expected.getType());
	}

}
