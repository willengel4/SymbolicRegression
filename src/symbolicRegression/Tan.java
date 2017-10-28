package symbolicRegression;

public class Tan extends NumericalSymbol
{
	public double evaluate() 
	{
		return Math.tan(children.get(0).evaluate());
	}

	public Symbol create() 
	{
		return new Tan();
	}

	public int getMinChildren() 
	{
		return 1;
	}

	public String getSymbol() 
	{
		return "tan ";
	}
}
