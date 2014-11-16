package xl.gui;

import java.awt.Color;

import xl.controller.Selectable;

public class SlotLabel extends ColoredLabel implements Selectable {
	private String addr;
	
    public SlotLabel(String addr) {
    	super("                    ", Color.WHITE, RIGHT);
    	
    	this.addr = addr;
    }
    
    public String address() {
    	return addr;
    }

	@Override
	public void setActive() {
		setBackground(Color.YELLOW);
	}

	@Override
	public void setInactive() {
		setBackground(Color.WHITE);
	}

	@Override
	public String identifier() {
		return addr;
	}
}