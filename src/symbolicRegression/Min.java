package symbolicRegression;

public class Min extends Symbol
{
	public double evaluate() 
	{
		double min = children.size() > 0 ? children.get(0).evaluate() : 0;
		for(int i = 0; i < children.size(); i++)
			if(children.get(i).evaluate() < min)
				min = children.get(i).evaluate();
		return min;
	}
	
	public Min create()
	{
		return new Min();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "min ";
	}
}
