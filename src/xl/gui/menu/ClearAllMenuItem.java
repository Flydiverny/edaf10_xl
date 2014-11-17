package xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import xl.controller.SheetController;

class ClearAllMenuItem extends JMenuItem implements ActionListener {
	private SheetController sheetController;
	
    public ClearAllMenuItem(SheetController sheetController) {
        super("Clear all");
        addActionListener(this);
        this.sheetController = sheetController;
    }

    public void actionPerformed(ActionEvent e) {
    	sheetController.clearAll();
    }
}