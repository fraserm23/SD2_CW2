package courseworkSD2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.Serializable;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class MasterShip extends Ship implements Serializable {

	//this class represents the master ship and inherits from the 'Ship' class
	private static final long serialVersionUID = -5457914960039732799L;
	
	//this attribute is used for storing the master ship's current mode
	private MasterShipMode masterShipMode;
	private ImageIcon destroyedMasterShipIcon;
	
	public MasterShip() {
		BufferedImage newImage = null;
		BufferedImage explosionImage = null;
		try {
			//imports images to be used in GridLabels
			newImage = ImageIO.read(MasterShip.class.getResource("/images/MasterShip-resized.PNG"));
			explosionImage = ImageIO.read(MasterShip.class.getResource("/images/explosion.JPEG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sets the image as the Master Ship's icon
		setIcon(new ImageIcon(newImage));
		//scales the image down for when the instance of the ship is on a square with more than one ship
		Image smallExplosionImage = explosionImage.getScaledInstance(20, 25, Image.SCALE_SMOOTH);
		setSmallIcon(new ImageIcon(smallExplosionImage));
		setMasterShipMode(new DefensiveMode());
	}
	
	public int getEnemyCapacity() {
		return this.masterShipMode.enemyCapacity();
	}
	
	public MasterShipMode getMasterShipMode() {
		return masterShipMode;
	}

	public void setMasterShipMode(MasterShipMode masterShipMode) {
		this.masterShipMode = masterShipMode;
	}

	public ImageIcon getDestroyedMasterShipIcon() {
		return destroyedMasterShipIcon;
	}

	public void setDestroyedMasterShipIcon(ImageIcon destroyedMasterShipIcon) {
		this.destroyedMasterShipIcon = destroyedMasterShipIcon;
	}

	

}
