package symbolicRegression;

public class Divide extends NumericalSymbol
{
	public double evaluate()
	{
		if(children.get(1).evaluate() == 0)
			return 0;
		
		if(Math.abs(children.get(1).evaluate()) < 0.001)
			return 0;
		
		return children.get(0).evaluate() / children.get(1).evaluate();
	}
	
	public Divide create()
	{
		return new Divide();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "div ";
	}
}