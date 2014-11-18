package xl.model;

import expr.Environment;

/**
 * Model used to represent a Slot in the Sheet.
 */
public interface Slot 
{
	/**
	 * Returns a representation of the value in string format.
	 * @param env
	 * @return
	 */
	public String representation(Environment env);
	
	/**
	 * Numerical value of the slot.
	 * @param env
	 * @return
	 */
	public double value(Environment env);
}

