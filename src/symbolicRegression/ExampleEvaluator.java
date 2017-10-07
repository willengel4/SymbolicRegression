package symbolicRegression;

public class ExampleEvaluator extends Evaluator
{
	private Terminal x;
	private Terminal y;
	
	/* An evaluator for a 2 variable input regression problem */
	public ExampleEvaluator(Terminal x, Terminal y)
	{
		this.x = x;
		this.y = y;
	}
	
	/* An evaluator where a higher output means higher fitness
	 * obviously a bad example */
	public double evaluate(Expression e) 
	{
		x.setValue(5);
		y.setValue(10);
		
		double output = e.getRoot().evaluate();
		
		return output;
	}
}
