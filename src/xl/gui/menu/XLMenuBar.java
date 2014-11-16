package xl.gui.menu;

import javax.swing.JMenu;
import javax.swing.JMenuBar;

import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.gui.XLList;
import xl.model.Sheet;

public class XLMenuBar extends JMenuBar {
    public XLMenuBar(XL xl, XLList xlList, StatusLabel statusLabel, Sheet sheet) {
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        file.add(new PrintMenuItem(xl, statusLabel));
        file.add(new SaveMenuItem(xl, statusLabel, sheet));
        file.add(new LoadMenuItem(xl, statusLabel, sheet));
        file.add(new NewMenuItem(xl));
        file.add(new CloseMenuItem(xl, xlList));
        edit.add(new ClearMenuItem());
        edit.add(new ClearAllMenuItem());
        add(file);
        add(edit);
        add(new WindowMenu(xlList));
    }
}