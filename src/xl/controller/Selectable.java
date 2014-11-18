package xl.controller;

/**
 * Model for something that can be selected.
 */
public interface Selectable {
	/**
	 * Called when selected.
	 */
	public void setActive();
	
	/**
	 * Called when no longer selected.
	 */
	public void setInactive();
	
	/**
	 * Unique identifier representing the Selectable.
	 * @return String
	 */
	public String identifier();
}
