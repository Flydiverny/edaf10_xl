package xl.controller;

import java.util.HashMap;
import java.util.Map;

import xl.model.Sheet;
import xl.model.XLException;
import xl.serialization.XLBufferedReader;
import xl.serialization.XLPrintStream;

public class SheetController {
	
	private Sheet sheet;
	private Selection selection;
	private Status status; 
	
	public SheetController(Sheet sheet, Selection selection, Status status) {
		this.sheet = sheet;
		this.selection = selection;
		this.status = status;
	}
	
	/**
	 * Loads the Sheet data contained in the file specified by path.
	 * @param path
	 * @throws XLException
	 */
	public void load(String path) throws XLException {
		try {
			XLBufferedReader reader = new XLBufferedReader(path);
			Map<String, String> map = new HashMap<String, String>();
    	
			reader.load(map); // Load into map.
		
			reader.close();
			
			sheet.load(map); // Load into sheet.
		} catch (Exception e) {
			sheet.clear();
			throw new XLException(e.getMessage());
		}
	}
	
	/**
	 * Saves the Sheet data in the file specified by path.
	 * @param path
	 * @throws XLException
	 */
	public void save(String path) throws XLException {
		try {
			XLPrintStream stream = new XLPrintStream(path);
        	stream.save(sheet.entrySet());
        	stream.close();
		} catch(Exception e) {
			throw new XLException(e.getMessage());
		}
	}
	
	/**
	 * Clears the sheet.
	 */
	public void clearAll() {
		sheet.clear();
	}
	
	/**
	 * Clears the selected field.
	 */
	public void clearSelectedField() {
		try {
			sheet.clear(selection.identifier());
		} catch(XLException e) {
			status.set(e.getMessage());
		}
		
	}
}
