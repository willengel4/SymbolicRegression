package symbolicRegression;

public class And extends Symbol
{
	public double evaluate() 
	{
		boolean result = true;
		for(Symbol s : children)
			result = result && Helper.interpret(s.evaluate());
		return Helper.interpret(result);
	}
	
	public And create()
	{
		return new And();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "and ";
	}
}
