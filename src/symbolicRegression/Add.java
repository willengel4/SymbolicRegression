package symbolicRegression;

public class Add extends NumericalSymbol
{
	public double evaluate() 
	{
		double sum = 0.0;
		for(Symbol s : getChildren())
			sum += s.evaluate();		
		return sum;
	}
	
	public Add create()
	{
		return new Add();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "add ";
	}
}