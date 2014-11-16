package xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import xl.controller.Selection;

public class CurrentLabel extends ColoredLabel implements Observer {
	private Selection selection;
	
    public CurrentLabel(Selection selection) {
        super("A1", Color.WHITE);
        
        this.selection = selection;
        selection.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		this.setText(selection.address());
	}
}