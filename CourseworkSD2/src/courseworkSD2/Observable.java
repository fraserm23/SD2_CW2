package courseworkSD2;

import java.io.Serializable;

//an interface created to help implement the Observer pattern
//used by Observables
public interface Observable extends Serializable {
	
public void addObserver(GUI theGui);
	
	public void removeObserver(GUI theGui);
	
	public void notifyObservers();
	
}
