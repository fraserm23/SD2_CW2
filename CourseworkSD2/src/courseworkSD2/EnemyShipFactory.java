package courseworkSD2;

import java.io.Serializable;

public class EnemyShipFactory implements Serializable {
	
	//this class is used to create the enemy ship factory for the simple Factory pattern
	private static final long serialVersionUID = 3900032665608795026L;
	
	//these integers determine what type of ship will be created based on what integer is taken
	//in by the 'makeEnemyShip' method
	final private int battleCruiser = 0;
	final private int battleShooter = 1;
	final private int battleStar = 2;

	//this method takes in a random number between 0-2 and returns a new enemy ship based on what
	//number is taken in
	public EnemyShip makeEnemyShip(int randomNum) {
		
		EnemyShip newShip = null;
		
		if(randomNum == battleCruiser) {
			newShip = new BattleCruiser();
		} else 
			
		if(randomNum == battleShooter) {
			newShip = new BattleShooter();
		} else
			
		if(randomNum == battleStar) {
			newShip = new BattleStar();
		} 
		
		return newShip;
	}

}
