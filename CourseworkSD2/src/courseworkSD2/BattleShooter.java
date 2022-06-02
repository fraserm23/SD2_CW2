package courseworkSD2;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

public class BattleShooter extends EnemyShip {

	private static final long serialVersionUID = 6705091283127419373L;

	public BattleShooter() {
		BufferedImage newImage = null;
		try {
			//gets the 'BattleShooter' image from the images folder and adds it to the BufferedImage variable
			newImage = ImageIO.read(BattleShooter.class.getResource("/images/BattleShooter-resized.PNG"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		//sets the image as the BattleShooter's ImageIcon
		this.setIcon(new ImageIcon(newImage));
		//scales the image down for when the instance of the ship is on a square with more than one ship
		Image smallImage = this.getIcon().getImage().getScaledInstance(15, 20, Image.SCALE_SMOOTH);
		setSmallIcon(new ImageIcon(smallImage));
		this.setType("BattleShooter");
	}

}
