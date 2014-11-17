package xl.model;

import expr.Environment;


public interface SlotFactory {
	public static final Slot EMPTY_SLOT = new Slot() {

		@Override
		public String representation(Environment env) {
			return null;
		}

		@Override
		public double value(Environment env) {
			return 0;
		}};
	
	public Slot build(String expr) throws XLException;
}
