package xl.slot;
import xl.model.Slot;
import expr.Environment;

/**
 * A slot representing a Comment node.
 */
public class CommentSlot implements Slot
{
	private String comment;

	public CommentSlot(String comment){
		this.comment = comment;
	}
	
	public double value(Environment env) {
		return 0d;	
	}
	
	public String toString() {
		return comment;
	}

	@Override
	public String representation(Environment env) {
		return comment.substring(1);
	}
	
}

