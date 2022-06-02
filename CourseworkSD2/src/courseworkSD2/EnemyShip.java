package courseworkSD2;

import java.io.Serializable;

public abstract class EnemyShip extends Ship implements Serializable {

	//this class is used as a superclass for enemy ships, it inherits from the 'Ship' class
	private static final long serialVersionUID = 1786390360745648352L;
	
	//this variable stores the type of enemy ship as a string
	private String type;

	public EnemyShip() {}	
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	

}
