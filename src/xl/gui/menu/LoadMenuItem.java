package xl.gui.menu;

import javax.swing.JFileChooser;

import xl.controller.SheetController;
import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.model.XLException;

class LoadMenuItem extends OpenMenuItem {
 
    public LoadMenuItem(XL xl, StatusLabel statusLabel, SheetController sheetController) {
        super(xl, statusLabel, "Load", sheetController);
    }

    protected void action(String path) throws XLException {
    	sheetController.load(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showOpenDialog(xl);
    }
}