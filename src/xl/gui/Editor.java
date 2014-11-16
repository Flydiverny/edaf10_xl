package xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import xl.controller.Editable;
import xl.controller.Selection;

public class Editor extends JTextField implements Observer, Editable {
	private Selection selection;
	
    public Editor(Selection selection) {
        setBackground(Color.WHITE);
        
        this.selection = selection;
        selection.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		setText(selection.expr());
	}

	@Override
	public String value() {
		return this.getText();
	}
}