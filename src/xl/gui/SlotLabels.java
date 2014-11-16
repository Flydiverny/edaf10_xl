package xl.gui;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;

import javax.swing.SwingConstants;

import xl.controller.SelectionController;
import xl.model.Sheet;

public class SlotLabels extends GridPanel implements Observer {
    private List<SlotLabel> labelList;
    private Sheet sheet;

    public SlotLabels(int rows, int cols, Sheet sheet, SelectionController selectionController) {
        super(rows + 1, cols);
        
        this.sheet = sheet;
        sheet.addObserver(this);
        
        labelList = new ArrayList<SlotLabel>(rows * cols);
        for (char ch = 'A'; ch < 'A' + cols; ch++) {
            add(new ColoredLabel(Character.toString(ch), Color.LIGHT_GRAY,
                    SwingConstants.CENTER));
        }
        for (int row = 1; row <= rows; row++) {
            for (char ch = 'A'; ch < 'A' + cols; ch++) {
                SlotLabel label = new SlotLabel("" + ch + row);
                label.addMouseListener(selectionController);
                add(label);
                labelList.add(label);
            }
        }

        selectionController.setStartingSelection(labelList.get(0));
    }

	@Override
	public void update(Observable o, Object arg) {
		for(SlotLabel lbl : labelList) {
			lbl.setText(sheet.representation(lbl.address()));
		}
	}
}
