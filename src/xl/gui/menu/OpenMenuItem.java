package xl.gui.menu;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import xl.controller.SheetController;
import xl.gui.StatusLabel;
import xl.gui.XL;
import xl.model.XLException;

public abstract class OpenMenuItem extends JMenuItem implements ActionListener {
    protected StatusLabel statusLabel;
    protected XL xl;
    protected SheetController sheetController;

    protected OpenMenuItem(XL xl, StatusLabel statusLabel, String title, SheetController sheetController) {
        super(title);
        this.xl = xl;
        this.statusLabel = statusLabel;
        this.sheetController = sheetController;
        addActionListener(this);
    }

    protected abstract void action(String path) throws XLException;

    public void actionPerformed(ActionEvent event) {
        JFileChooser fileChooser = new JFileChooser(".");
        FileFilter filter = new FileNameExtensionFilter("XL files", "xl");
        fileChooser.setFileFilter(filter);
        int option = openDialog(fileChooser);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                action(file.toString());
                xl.rename(file.getName());
            } catch (XLException e) {
                statusLabel.setText(e.getMessage());
            }
        }
    }

    protected abstract int openDialog(JFileChooser fileChooser);
}