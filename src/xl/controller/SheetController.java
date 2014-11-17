package xl.controller;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import xl.model.Sheet;
import xl.serialization.XLBufferedReader;
import xl.serialization.XLPrintStream;

public class SheetController {
	
	private Sheet sheet;
	
	public SheetController(Sheet sheet) {
		this.sheet = sheet;
	}
	
	public void load(String path) throws FileNotFoundException {
		XLBufferedReader reader = new XLBufferedReader(path);
    	Map<String, String> map = new HashMap<String, String>();
    	
    	reader.load(map); // Load into map.
    	sheet.load(map); // Load into sheet.
	}
	
	public void save(String path) throws FileNotFoundException {
		XLPrintStream stream = new XLPrintStream(path);
        stream.save(sheet.entrySet());
	}
	
	public void clearAll() {
		sheet.clear();
	}
}
