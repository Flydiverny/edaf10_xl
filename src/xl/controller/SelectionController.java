package xl.controller;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SelectionController extends MouseAdapter
{
	private Selection selection;
	private Selectable current = new Selectable() {
		@Override
		public void setActive() {
		}

		@Override
		public void setInactive() {
		}

		@Override
		public String identifier() {
			return "null-object";
		}
		
	};
	
	private Status status;
	
	public SelectionController(Selection selection, Status status){
		this.selection = selection;
		this.status = status;
	}

	public void setStartingSelection(Selectable sel) {
		switchSelection(sel);
	}
	
	private void switchSelection(Selectable newSel) {
		status.clear();
		
		current.setInactive();
		current = newSel;
		
		current.setActive();
		selection.setAddress(current.identifier());
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() instanceof Selectable)
			switchSelection((Selectable)e.getSource());
	}
}

