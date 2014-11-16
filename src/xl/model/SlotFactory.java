package xl.model;


public interface SlotFactory {
	public Slot build(String expr) throws XLException;
}
