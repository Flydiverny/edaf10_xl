package xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;

import xl.controller.SelectionController;

class ClearMenuItem extends JMenuItem implements ActionListener {
    private SelectionController selectionController;
	
	public ClearMenuItem(SelectionController selectionController) {
        super("Clear");
        addActionListener(this);
        
        this.selectionController = selectionController;
    }

    public void actionPerformed(ActionEvent e) {
        selectionController.clearField();
    }
}