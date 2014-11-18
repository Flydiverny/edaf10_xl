package xl.controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionController extends MouseAdapter
{
	private Selection selection;
	private Status status;
	
	public SelectionController(Selection selection, Status status){
		this.selection = selection;
		this.status = status;
	}

	public void setStartingSelection(Selectable sel) {
		switchSelection(sel);
	}
	
	private void switchSelection(Selectable selectable) {
		status.clear();
		
		selection.setSelection(selectable);
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof Selectable)
			switchSelection((Selectable)e.getSource());
	}
}

