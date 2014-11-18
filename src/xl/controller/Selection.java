package xl.controller;
import java.util.Observable;

import xl.model.Sheet;

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
	
	private Sheet sheet;
	
	public Selection(Sheet sheet) {
		this.sheet = sheet;
	}
	
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
	
	public String expr() {
		return sheet.toString(this.current.identifier());	
	}
}

