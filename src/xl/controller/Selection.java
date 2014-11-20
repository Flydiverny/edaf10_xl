package xl.controller;
import java.util.Observable;


/**
 * ViewModel for the Current Selection.
 */
public class Selection extends Observable
{
	// Initialized with a null object to avoid null check in setSelection
	private Selectable current = new Selectable() {
		@Override
		public void setActive() {
		}

		@Override
		public void setInactive() {
		}

		@Override
		public String identifier() {
			return "null-object";
		}
		
	};
	
	public String identifier() {
		return current.identifier();	
	}
	
	protected void setSelection(Selectable selectable) {
		// Rotate selection
		this.current.setInactive();
		this.current = selectable;
		this.current.setActive();
		
		// Notify obs
		this.setChanged();
		this.notifyObservers();
	}

}

