package courseworkSD2;

import java.io.Serializable;

//this interface is implemented on the OffensiveMode and DefensiveMode classes to
//help implement the strategy pattern
public interface MasterShipMode extends Serializable {
	
	public int enemyCapacity();

}
