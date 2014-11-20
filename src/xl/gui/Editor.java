package xl.gui;

import java.awt.Color;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JTextField;

import xl.controller.Editable;
import xl.controller.Selection;
import xl.model.Sheet;

public class Editor extends JTextField implements Observer, Editable {
	private Selection selection;
	private Sheet sheet;
	
    public Editor(Selection selection, Sheet sheet) {
        setBackground(Color.WHITE);
        
        this.selection = selection;
        this.sheet = sheet;
        selection.addObserver(this);
    }

	@Override
	public void update(Observable o, Object arg) {
		setText(sheet.toString(selection.identifier()));
	}

	@Override
	public String value() {
		return this.getText();
	}
}