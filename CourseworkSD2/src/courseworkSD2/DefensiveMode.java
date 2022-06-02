package courseworkSD2;

import java.io.Serializable;

public class DefensiveMode implements MasterShipMode, Serializable {

	//this class represents one type of 'mode' the master ship can have
	private static final long serialVersionUID = -7605479943185009414L;
	//this is the enemy capacity associated with this mode
	final private int enemyCount = 1;
	
	//returns the enemy capacity
	public int enemyCapacity() {
		return enemyCount;
	}

}
