package xl.controller;

import java.util.Observable;

/**
 * ViewModel for the Status field.
 */
public class Status extends Observable {
	
	private String status;
	
	protected void set(String status) {
		this.status = status;
		
		this.setChanged();
		this.notifyObservers();
	}
	
	public String toString() {
		return status;
	}
	
	public void clear() {
		this.set("");
	}
}
