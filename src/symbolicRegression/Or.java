package symbolicRegression;

public class Or extends LogicalSymbol
{
	public double evaluate() 
	{
		boolean result = false;
		for(Symbol s : children)
			result = result || Helper.interpret(s.evaluate());
		return Helper.interpret(result);
	}
	
	public Or create()
	{
		return new Or();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "or ";
	}
}
