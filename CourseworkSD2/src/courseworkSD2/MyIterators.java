package courseworkSD2;

import java.util.ArrayList;

import java.util.Iterator;

//this class was created to take the iterators used by the 'Game' class out of
//a serializable class as they cannot be serialized
public class MyIterators {

	public ArrayList<EnemyShip> enemyShipIterator(ArrayList<EnemyShip> theEnemyShips, Square tempSquare) {

		//sets 'theEnemyShips' to a new instance of an Iterator
		Iterator <EnemyShip> theEnemyShipIterator = theEnemyShips.iterator();

		//loops through the iterator while it still has elements to check
		while(theEnemyShipIterator.hasNext()) {
			//sets an EnemyShip object to the next element in the list
			EnemyShip tempEnemyShip = theEnemyShipIterator.next();

			for(Ship tempShip : tempSquare.getTheShips()) {
				if (tempEnemyShip == tempShip) {
					//removes the ship from 'theEnemyShips' if it is found on the square
					theEnemyShipIterator.remove();
				}
			}
		}
		//returns the altered array list
		return theEnemyShips;
	}

	public ArrayList<Ship> squareShipIterator(ArrayList<Ship> theShips, Game theGame){

		//sets 'theShips' to a new instance of an Iterator
		Iterator <Ship> theShipIterator = theShips.iterator();

		//loops through the iterator while it still has elements to check
		while(theShipIterator.hasNext()) {
			//sets a Ship object to the next element in the list
			Ship tempShip = theShipIterator.next();

			if(tempShip != theGame.getMasterShip()) {
				//removes the ship from 'theShips' if it is not the MasterShip
				theShipIterator.remove();
				//adds one to the total number of enemies destroyed
				theGame.setEnemiesDestroyed(theGame.getEnemiesDestroyed()+1);
			}
		}
		
		return theShips;
	}

}
