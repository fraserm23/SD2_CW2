package courseworkSD2;

import java.io.Serializable;

public class OffensiveMode implements MasterShipMode, Serializable {

	//this class represents one type of 'mode' the master ship can have
	private static final long serialVersionUID = -93767352255509301L;
	//this is the enemy capacity associated with this mode
	final private int enemyCount = 2;
	
	//returns the enemy capacity
	public int enemyCapacity() {
		return enemyCount;
	}

}
