package xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import xl.controller.SelectionController;
import xl.controller.SheetController;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private SheetController sheetController;
	
	public ClearMenuItem(SheetController sheetController) {
        super("Clear");
        addActionListener(this);
        
        this.sheetController = sheetController;
    }

    public void actionPerformed(ActionEvent e) {
        sheetController.clearSelectedField();
    }
}