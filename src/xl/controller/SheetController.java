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
	
	public SheetController(Sheet sheet, Selection selection) {
		this.sheet = sheet;
		this.selection = selection;
	}
	
	public void load(String path) throws XLException {
		try {
			XLBufferedReader reader = new XLBufferedReader(path);
			Map<String, String> map = new HashMap<String, String>();
    	
			reader.load(map); // Load into map.
		
			reader.close();
			
			sheet.load(map); // Load into sheet.
		} catch (Exception e) {
			throw new XLException(e.getMessage());
		}
	}
	
	public void save(String path) throws XLException {
		try {
			XLPrintStream stream = new XLPrintStream(path);
        	stream.save(sheet.entrySet());
        	stream.close();
		} catch(Exception e) {
			throw new XLException(e.getMessage());
		}
	}
	
	public void clearAll() {
		sheet.clear();
	}
	public void clearSelectedField() {
		sheet.clear(selection.identifier());
	}
}
