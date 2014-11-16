package xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import xl.controller.SelectionController;
import xl.model.Sheet;

public class SheetPanel extends BorderPanel {
    public SheetPanel(int rows, int columns, Sheet sheet, SelectionController selectionController) {
        add(WEST, new RowLabels(rows));
        add(CENTER, new SlotLabels(rows, columns, sheet, selectionController));
    }
}