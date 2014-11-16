package xl.slot;
import xl.model.Slot;
import xl.model.XLException;
import expr.Environment;


public class CircularSlot implements Slot
{
	public String toString() {
		throw new UnsupportedOperationException("Invalid use of Circular Slot");
	}

	public double value(Environment env) {
		throw new XLException("Circular reference");
	}

	@Override
	public String representation(Environment env) {
		throw new UnsupportedOperationException("Invalid use of Circular Slot");
	}
	
}

