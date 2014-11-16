package xl.gui.menu;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.model.Sheet;
import xl.serialization.XLPrintStream;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel, Sheet sheet) {
        super(xl, statusLabel, "Save", sheet);
    }

    protected void action(String path) throws FileNotFoundException {
        XLPrintStream stream = new XLPrintStream(path);
        stream.save(sheet.entrySet());
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}