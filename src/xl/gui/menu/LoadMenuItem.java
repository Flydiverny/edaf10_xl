package xl.gui.menu;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFileChooser;

import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.model.Sheet;
import xl.model.Slot;
import xl.serialization.XLBufferedReader;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Load", sheet);
    }

    protected void action(String path) throws FileNotFoundException {
    	XLBufferedReader reader = new XLBufferedReader(path);
    	Map<String, String> map = new HashMap<String, String>();
    	
    	reader.load(map);
    	sheet.load(map);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}