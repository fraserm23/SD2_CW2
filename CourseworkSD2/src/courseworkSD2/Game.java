package courseworkSD2;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;

public class Game implements Serializable, Observable {

	private static final long serialVersionUID = -4750026820342699854L;

	private Grid theGrid;
	private MasterShip masterShip;
	private ArrayList <EnemyShip> theEnemyShips;
	private ArrayList <GUI> theGUIObservers;
	private EnemyShipFactory theEnemyShipFactory;
	private boolean enemyCreated;
	private boolean masterShipDestroyed;
	private boolean enemyDestroyedThisTurn;
	private int enemiesDestroyed;
	MyIterators iterators;

	//the constructor instantiates most of the above variables for use in the game
	public Game() {
		theGrid = new Grid();
		masterShip = new MasterShip();
		theEnemyShips = new ArrayList <EnemyShip>();
		theGUIObservers = new ArrayList <GUI>();
		theEnemyShipFactory = new EnemyShipFactory();
		enemyCreated = false;
		masterShipDestroyed = false;
		enemiesDestroyed = 0;
	}

	//this method is called when the start button is pressed in the GUI
	public void Start() {
		setMasterShip();
		notifyObservers();
	}

	//this method is called when the move button is pressed in the GUI
	public void Move() {
		moveShip(masterShip);
		moveEnemyShips();
		createEnemyShip();
		checkConflicts();
		notifyObservers();
	}

	//this method sets the master ship when the Start() method is called
	public void setMasterShip() {
		int xCoord, yCoord, range;
		Random numGenerator = new Random();

		range = theGrid.getGridSize();

		//gets random coordinates for the master ship to begin with
		xCoord = numGenerator.nextInt(range);
		yCoord = numGenerator.nextInt(range);

		setShip(xCoord, yCoord, masterShip);
	}

	public void createEnemyShip() {
		Random numGenerator = new Random();
		int createEnemyNum, chanceOfEnemyRange, enemyTypesRange, choiceOfEnemyNum;
		EnemyShip newEnemyShip;
		//this range makes sure there is 1 in 3 chance of enemy being generated
		chanceOfEnemyRange = 3;
		//this range makes sure that only a number between 0-2 can be passed to the enemy ship factory
		enemyTypesRange = 3;

		enemyCreated = false;

		createEnemyNum = numGenerator.nextInt(chanceOfEnemyRange);

		//if the condition is met then an enemy ship is created, added to 'theEnemyShips' and then
		//placed on the grid
		if (createEnemyNum == 0) {
			choiceOfEnemyNum = numGenerator.nextInt(enemyTypesRange);
			newEnemyShip = theEnemyShipFactory.makeEnemyShip(choiceOfEnemyNum);
			theEnemyShips.add(newEnemyShip);
			theGrid.getTheRows().get(0).getTheSquares().get(0).getTheShips().add(newEnemyShip);
			enemyCreated = true;
		}
	}

	//takes every enemy ship in 'theEnemyShips' and sends it to the moveShip method
	public void moveEnemyShips() {
		for(EnemyShip tempEnemyShip : theEnemyShips) {
			moveShip(tempEnemyShip);
		}
	}

	//takes in a ship object as an argument, removes it from the square its currently
	//on, takes its old coordinates, gets new ones based on them and then sends those new
	//coordinates and the ship object to the setShip method
	public void moveShip(Ship theShip) {
		int oldXCoord = 0, oldYCoord = 0, newXCoord = 0, newYCoord = 0;

		for(Row tempRow : theGrid.getTheRows()) {
			for(Square tempSquare : tempRow.getTheSquares()) {
				if(tempSquare.getTheShips().contains(theShip)) {
					tempSquare.getTheShips().remove(theShip);
					oldXCoord = tempSquare.getXCoordinate();
					oldYCoord = tempRow.getYCoordinate();
				}
			}
		}
		newXCoord = getNewCoord(oldXCoord);
		newYCoord = getNewCoord(oldYCoord);

		setShip(newXCoord, newYCoord, theShip);
	}

	//takes in coordinates and a ship object, finds the square associated with those coordinates
	//and adds the ship object to the square's ships array list
	public void setShip(int xCoord, int yCoord, Ship theShip) {
		theGrid.getTheRows().get(yCoord).getTheSquares().get(xCoord).getTheShips().add(theShip);
	}

	//takes in an old coordinate and generates a new coordinate based on it
	public int getNewCoord(int oldCoord) {

		int newCoord = 0;
		Random numGenerator = new Random();

		//if the coordinate is 0, then this returns a random number between 0-1
		if(oldCoord == theGrid.getLowAxisNum()) {
			newCoord = numGenerator.nextInt(2);
		}
		else
			//if the coordinate is the highest axis number (in this case 4) then this
			//returns either that same number or one lower than it
			if(oldCoord == theGrid.getHighAxisNum()) {
				newCoord = numGenerator.nextInt(2) + (theGrid.getHighAxisNum() - 1);
			}
		//if the coordinate is between the highest and lowest axis numbers, then this returns
		//either the same number, one higher than it or one lower than it
			else {
				newCoord = numGenerator.nextInt(3) + (oldCoord - 1);
			}
		return newCoord;
	}

	//this method is for checking through each squares ships array lists and seeing if there
	//are any conflicts between the master ship and the enemy ships
	public void checkConflicts(){
		//resets this variable for the benefit of representing data in the GUI
		enemyDestroyedThisTurn = false;
		for (Row tempRow : theGrid.getTheRows()) {
			for(Square tempSquare : tempRow.getTheSquares()) {
				//checks for the condition that there is more than one ship and the master ship on
				//each square
				if(tempSquare.getTheShips().size() > 1 && tempSquare.getTheShips().contains(masterShip)) {
					//checks to see if the amount of enemies on the square are within what the master ship 
					//can handle
					if(tempSquare.getTheShips().size() <= masterShip.getEnemyCapacity() + 1){
						enemyDestroyedThisTurn = true;
						MyIterators iterators = new MyIterators();
						//sends the ship lists to the iterator class to remove the necessary ships
						theEnemyShips = iterators.enemyShipIterator(theEnemyShips, tempSquare);
						tempSquare.setTheShips(iterators.squareShipIterator(tempSquare.getTheShips(), this));
					} else {
						//checks to see if there are more enemies than the master ship can handle
						if(tempSquare.getTheShips().size() > masterShip.getEnemyCapacity() + 1) {
							for(Ship tempShip : tempSquare.getTheShips()) {
								if(tempShip == masterShip) {
									//sets the master ship to the destroyed icon
									masterShip.setIcon(masterShip.getSmallIcon());
									masterShipDestroyed = true;
								}
							}
						}
					}
				}
			}
		}
	}

	//this method is a part of the strategy pattern, it is called by the mode switch button on the GUI
	public void setMasterShipMode() {
		if(masterShip.getEnemyCapacity() == 1) {
			masterShip.setMasterShipMode(new OffensiveMode());
		} else {
			masterShip.setMasterShipMode(new DefensiveMode());
		}
	}

	//this method adds new observers to the observer list
	public void addObserver(GUI theGui) {
		this.theGUIObservers.add(theGui);
	}

	//this method removes observers from the observer list
	public void removeObserver(GUI theGui) {
		this.theGUIObservers.remove(theGui);
	}

	//this method sends the most up to date game object to the observers
	public void notifyObservers() {
		for(GUI tempGUI : this.theGUIObservers) {
			tempGUI.updateGUI(this);
		}
	}

	public MasterShip getMasterShip() {
		return masterShip;
	}

	public void setMasterShip(MasterShip masterShip) {
		this.masterShip = masterShip;
	}

	public Grid getTheGrid() {
		return theGrid;
	}

	public void setTheGrid(Grid theGrid) {
		this.theGrid = theGrid;
	}

	public ArrayList<EnemyShip> getTheEnemyShips() {
		return theEnemyShips;
	}

	public void setTheEnemyShips(ArrayList<EnemyShip> theEnemyShips) {
		this.theEnemyShips = theEnemyShips;
	}

	public ArrayList<GUI> getTheGUIObservers() {
		return theGUIObservers;
	}

	public void setTheGUIObservers(ArrayList<GUI> theGUIObservers) {
		this.theGUIObservers = theGUIObservers;
	}

	public boolean isEnemyCreated() {
		return enemyCreated;
	}

	public void setEnemyCreated(boolean enemyCreated) {
		this.enemyCreated = enemyCreated;
	}

	public boolean isMasterShipDestroyed() {
		return masterShipDestroyed;
	}

	public void setMasterShipDestroyed(boolean masterShipDestroyed) {
		this.masterShipDestroyed = masterShipDestroyed;
	}

	public int getEnemiesDestroyed() {
		return enemiesDestroyed;
	}

	public void setEnemiesDestroyed(int enemiesDestroyed) {
		this.enemiesDestroyed = enemiesDestroyed;
	}

	public boolean isEnemyDestroyedThisTurn() {
		return enemyDestroyedThisTurn;
	}

	public void setEnemyDestroyedThisTurn(boolean enemyDestroyedThisTurn) {
		this.enemyDestroyedThisTurn = enemyDestroyedThisTurn;
	}

	public EnemyShipFactory getTheEnemyShipFactory() {
		return theEnemyShipFactory;
	}

	public void setTheEnemyShipFactory(EnemyShipFactory theEnemyShipFactory) {
		this.theEnemyShipFactory = theEnemyShipFactory;
	}	

}
