package expr;

/**
 * An Environment can be used to lookup the value of variables specified by name. 
 */
public interface Environment {
    public double value(String name);
}