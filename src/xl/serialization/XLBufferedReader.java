package xl.serialization;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Map;

import xl.model.Slot;
import xl.model.XLException;
import xl.slot.SlotFactory;

public class XLBufferedReader extends BufferedReader {
    public XLBufferedReader(String name) throws FileNotFoundException {
        super(new FileReader(name));
    }

    public void load(Map<String, String> map) {
        try {
            while (ready()) {
                String string = readLine();
                int i = string.indexOf('=');
                
                String addr = string.substring(0, i);
                String expr = string.substring(i+1);
                
                map.put(addr, expr);
            }
        } catch (Exception e) {
            throw new XLException(e.getMessage());
        }
    }
}
