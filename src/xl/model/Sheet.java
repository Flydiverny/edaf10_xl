package xl.model;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Observable;
import java.util.Set;

import xl.slot.CircularSlot;
import xl.model.SlotFactory;
import expr.Environment;

public class Sheet extends Observable implements Environment
{
	private Map<String,Slot> slots;
	private SlotFactory slotFactory;
	
	public Sheet(SlotFactory slotFactory) {
		this.slotFactory = slotFactory;
		slots = new HashMap<String, Slot>();
	}
	
	/**
	 * Sets the specified expression at the address.
	 * @param addr
	 * @param expr
	 * @throws XLException
	 */
	public void set(String addr, String expr) throws XLException {
		// Save current slot just in case x)
		Slot old = slots.remove(addr);
		
		// Try creating slot.
		Slot slot = slotFactory.build(expr);
		
		// Empty slot 
		if(slot == SlotFactory.EMPTY_SLOT) {
			this.setChanged();
			this.notifyObservers();
			return;
		}
		
		// check circular ref.
		try {
			slots.put(addr, new CircularSlot());
			slot.value(this);
		} catch(XLException e) {
			slots.put(addr, old);
			throw e;
		}
		
		// All good save it and notify
		slots.put(addr, slot);
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Returns the visual representation for a field.
	 * @param addr
	 * @return String
	 */
	public String representation(String addr) {
		Slot slot = slots.get(addr);
		return slot == null ? "" : slot.representation(this);
	}
	
	/**
	 * Returns the actual expression for a field.
	 * @param addr
	 * @return String
	 */
	public String toString(String addr) {
		Slot slot = slots.get(addr);
		return slot == null ? "" : slot.toString();
	}
	
	/**
	 * Returns a set of all current values in the sheet.
	 * @return Set
	 */
	public Set<Entry<String,Slot>> entrySet() {
		return slots.entrySet();	
	}
	
	/**
	 * Returns the numeric value for a field.
	 */
	public double value(String addr) {
		Slot slot = slots.get(addr);
		
		if(slot == null)
			throw new XLException("Can't reference empty cell");
		
		return slot.value(this);	
	}
	
	/**
	 * Clears the Sheet and populates it with the values in the map.
	 * The maps keys should be addresses and the value expressions. 
	 * @param map
	 */
	public void load(Map<String, String> map) {
		this.slots.clear();
		
		for(Entry<String, String> entry : map.entrySet()) {
			slots.put(entry.getKey(), slotFactory.build(entry.getValue()));
		}
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Clears a field in the sheet.
	 * @param addr
	 */
	public void clear(String addr) {
		slots.remove(addr);
		
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Clears the whole sheet.
	 */
	public void clear() {
		this.slots.clear();
		
		this.setChanged();
		this.notifyObservers();
	}
}

