package xl.slot;
import xl.model.Slot;
import expr.Environment;
import expr.Expr;


public class ExprSlot implements Slot
{
	private Expr expr;
	
	public ExprSlot(Expr expr){
		this.expr = expr;
	}

	public double value(Environment env) {
		return expr.value(env);	
	}
	
	public String toString() {
		return this.expr.toString();
	}
	
	@Override
	public String representation(Environment env) {
		return String.valueOf(this.value(env));
	}
	
}

