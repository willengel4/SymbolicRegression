package symbolicRegression;

public class Max extends NumericalSymbol
{
	public double evaluate() 
	{
		double max = children.size() > 0 ? children.get(0).evaluate() : 0;
		for(int i = 0; i < children.size(); i++)
			if(children.get(i).evaluate() > max)
				max = children.get(i).evaluate();
		return max;
	}
	
	public Max create()
	{
		return new Max();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "max ";
	}
}
