package xl.gui.menu;

import java.io.FileNotFoundException;
import javax.swing.JFileChooser;

import xl.controller.SheetController;
import xl.gui.StatusLabel;
import xl.gui.XL;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel, SheetController sheetController) {
        super(xl, statusLabel, "Load", sheetController);
    }

    protected void action(String path) throws FileNotFoundException {
    	sheetController.load(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}