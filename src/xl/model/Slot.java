package xl.model;

import expr.Environment;

public interface Slot 
{
	public String representation(Environment env);
	public double value(Environment env);
}

