package xl.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import xl.gui.Editor;
import xl.model.Sheet;
import xl.model.Status;
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

	private void putNewValue() {
		status.clear();

		try {
			sheet.set(selection.address(), editable.value());
		} catch (XLException e) {
			status.set(e.getMessage());
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.putNewValue();
	}

}
