package xl.model;

import expr.Environment;

public interface SlotFactory {
	/**
	 * Null object for an empty slot.
	 */
	public static final Slot EMPTY_SLOT = new Slot() {

		@Override
		public String representation(Environment env) {
			return null;
		}

		@Override
		public double value(Environment env) {
			return 0;
		}
	};

	/**
	 * Creates a new Slot or returns an SlotFactory.EMPTY_SLOT 
	 * 
	 * @param expr
	 * @return
	 * @throws XLException
	 */
	public Slot build(String expr) throws XLException;
}
