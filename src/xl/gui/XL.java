package xl.gui;

import static java.awt.BorderLayout.CENTER;
import static java.awt.BorderLayout.NORTH;
import static java.awt.BorderLayout.SOUTH;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.print.PageFormat;
import java.awt.print.Printable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import xl.controller.EditorController;
import xl.controller.Selection;
import xl.controller.SelectionController;
import xl.controller.Status;
import xl.gui.menu.XLMenuBar;
import xl.model.Sheet;
import xl.slot.SlotFactory;

public class XL extends JFrame implements Printable {
    private static final int ROWS = 10, COLUMNS = 8;
    private XLCounter counter;
    private XLList xlList;
    
    public XL(XL oldXL) {
        this(oldXL.xlList, oldXL.counter);
    }

    public XL(XLList xlList, XLCounter counter) {
        super("Untitled-" + counter);
        this.xlList = xlList;
        this.counter = counter;
        xlList.add(this);
        counter.increment();

        Sheet sheet = new Sheet(new SlotFactory());
        Status status = new Status();
        Selection selection = new Selection(sheet);
        SelectionController selectionController = new SelectionController(selection, status);
        
        StatusLabel statusLabel = new StatusLabel(status);
        JPanel statusPanel = new StatusPanel(statusLabel, selection);
        JPanel sheetPanel = new SheetPanel(ROWS, COLUMNS, sheet, selectionController);
        Editor editor = new Editor(selection);
        
        EditorController editorController = new EditorController(sheet, editor, selection, status);
        editor.addActionListener(editorController);
        
        add(NORTH, statusPanel);
        add(CENTER, editor);
        add(SOUTH, sheetPanel);
        setJMenuBar(new XLMenuBar(this, xlList, statusLabel, sheet));
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setVisible(true);
    }
    
    public int print(Graphics g, PageFormat pageFormat, int page) {
        if (page > 0)
            return NO_SUCH_PAGE;
        Graphics2D g2d = (Graphics2D) g;
        g2d.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        printAll(g2d);
        return PAGE_EXISTS;
    }

    public void rename(String title) {
        setTitle(title);
        xlList.setChanged();
    }

    public static void main(String[] args) {
        new XL(new XLList(), new XLCounter());
    }
}