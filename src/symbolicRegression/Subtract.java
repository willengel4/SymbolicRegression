package symbolicRegression;

public class Subtract extends Symbol
{
	public double evaluate()
	{
		return children.get(0).evaluate() - children.get(1).evaluate();
	}
	
	public Subtract create()
	{
		return new Subtract();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "sub ";
	}
}