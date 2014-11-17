package xl.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import xl.controller.SelectionController;
import xl.controller.SheetController;
import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.gui.XLList;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, SheetController sheetController, SelectionController selectionController) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel, sheetController));
        file.add(new LoadMenuItem(xl, statusLabel, sheetController));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem(selectionController));
        edit.add(new ClearAllMenuItem(sheetController));
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}