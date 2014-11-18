package xl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import xl.model.Sheet;
import xl.model.XLException;

public class EditorController implements ActionListener {
	private Editable editable;
	private Selection selection;
	private Sheet sheet;
	private Status status;

	public EditorController(Sheet sheet, Editable editable, Selection selection, Status status) {
		this.editable = editable;
		this.selection = selection;
		this.sheet = sheet;
		this.status = status;
	}
	
	/**
	 * Sends the text from the editable field to sheet so that the sheet can add the expression to the currently selected slot
	 * catches and sets any errors from this process 
	 */
	private void putNewValue() {
		status.clear();
		
		try {
			sheet.set(selection.identifier(), editable.value());
		} catch (XLException e) {
			status.set(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.putNewValue();
	}

}
