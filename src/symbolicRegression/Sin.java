package symbolicRegression;

public class Sin extends NumericalSymbol
{
	public double evaluate() 
	{
		return Math.sin(children.get(0).evaluate());
	}

	public Symbol create() 
	{
		return new Sin();
	}

	public int getMinChildren() 
	{
		return 1;
	}

	public String getSymbol() 
	{
		return "sin ";
	}
}
