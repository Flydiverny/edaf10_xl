package xl.slot;

import java.io.IOException;

import xl.model.Slot;
import xl.model.XLException;
import expr.ExprParser;

public class SlotFactory implements xl.model.SlotFactory
{
	private ExprParser parser;
	
	public SlotFactory(){
		parser = new ExprParser();
	}

	/**
	 * Creates an appropriate Slot for the input expression.
	 */
	public Slot build(String expr) throws XLException {
		if(expr.length() == 0)
			return SlotFactory.EMPTY_SLOT;
		
		if(expr.charAt(0) == '#')
			return new CommentSlot(expr);
		
		try {
			return new ExprSlot(parser.build(expr));
		} catch (IOException e) {
			throw new XLException(e.getMessage());
		}
	}
	
}

