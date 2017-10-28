package symbolicRegression;

public class Cos extends NumericalSymbol
{

	public double evaluate() 
	{
		return Math.cos(children.get(0).evaluate());
	}

	public Symbol create() 
	{
		return new Cos();
	}

	public int getMinChildren() 
	{
		return 1;
	}

	public String getSymbol() 
	{
		return "cos ";
	}

}
