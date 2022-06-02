package courseworkSD2;

import java.io.Serializable;

//an interface created to help implement the Observer pattern
//used by Observers
public interface myObserver extends Serializable {

	public void updateGUI(Game theGame);
		
}
