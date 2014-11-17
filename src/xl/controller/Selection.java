package xl.controller;
import java.util.Observable;

import xl.model.Sheet;

public class Selection extends Observable
{
	private String addr;
	private Sheet sheet;
	
	public Selection(Sheet sheet) {
		this.sheet = sheet;
	}
	
	public String address() {
		return addr;	
	}
	
	protected void setAddress(String addr) {
		this.addr = addr;
		this.setChanged();
		this.notifyObservers();
	}
	
	protected void clearField() {
		sheet.clear(addr);
	}
	
	public String expr() {
		return sheet.toString(this.addr);	
	}
}

