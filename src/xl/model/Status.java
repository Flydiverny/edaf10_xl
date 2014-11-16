package xl.model;

import java.util.Observable;

public class Status extends Observable {
	
	private String status;
	
	public void set(String status) {
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
