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

	public Slot build(String str) throws XLException {
		if(str.length() == 0)
			return SlotFactory.EMPTY_SLOT;
		
		if(str.charAt(0) == '#')
			return new CommentSlot(str);
		
		try {
			return new ExprSlot(parser.build(str));
		} catch (IOException e) {
			throw new XLException(e.getMessage());
		}
	}
	
}

