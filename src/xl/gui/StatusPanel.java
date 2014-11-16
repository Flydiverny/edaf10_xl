package xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.WEST;
import xl.controller.Selection;

public class StatusPanel extends BorderPanel {
    protected StatusPanel(StatusLabel statusLabel, Selection selection) {
        add(WEST, new CurrentLabel(selection));
        add(CENTER, statusLabel);
    }
}