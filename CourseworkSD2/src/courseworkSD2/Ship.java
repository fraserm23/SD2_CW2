package courseworkSD2;

import java.io.Serializable;

import javax.swing.ImageIcon;

//this abstract superclass was used for both the 'MasterShip' and 'EnemyShip' classes
public abstract class Ship implements Serializable {
	
	private static final long serialVersionUID = -8321540932358601158L;
	
	//these ImageIcon variables are used for displaying images of the ship
	private ImageIcon icon;
	private ImageIcon smallIcon;

	public Ship() {}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}
	
	public ImageIcon getSmallIcon() {
		return smallIcon;
	}

	public void setSmallIcon(ImageIcon smallIcon) {
		this.smallIcon = smallIcon;
	}
}
