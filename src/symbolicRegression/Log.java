package symbolicRegression;

public class Log extends NumericalSymbol
{
	public double evaluate() 
	{
		if(children.get(0).evaluate() == 0)
			return 0;
		
		return Math.log(children.get(0).evaluate());
	}

	public Symbol create() 
	{
		return new Log();
	}

	public int getMinChildren() 
	{
		return 1;
	}

	public String getSymbol() 
	{
		return "log ";
	}
}
