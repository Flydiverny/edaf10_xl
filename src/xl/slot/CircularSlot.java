package xl.slot;
import xl.model.Slot;
import xl.model.XLException;
import expr.Environment;

/**
 * Added to sheet before a "real" new slot and if the evaluating function of expr comes into contact with it we know we have a circular expression 
 */
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

