package xl.gui.menu;

import java.io.FileNotFoundException;

import javax.swing.JFileChooser;

import xl.controller.SheetController;
import xl.gui.StatusLabel;
import xl.gui.XL;

class SaveMenuItem extends OpenMenuItem {
    public SaveMenuItem(XL xl, StatusLabel statusLabel, SheetController sheetController) {
        super(xl, statusLabel, "Save", sheetController);
    }

    protected void action(String path) throws FileNotFoundException {
        sheetController.save(path);
    }

    protected int openDialog(JFileChooser fileChooser) {
        return fileChooser.showSaveDialog(xl);
    }
}