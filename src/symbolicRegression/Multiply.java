package symbolicRegression;

public class Multiply extends Symbol
{
	public double evaluate() 
	{
		double product = 1.0;
		for(Symbol s : children)
			product *= s.evaluate();
		return product;
	}
	
	public Multiply create()
	{
		return new Multiply();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "mult ";
	}
}
