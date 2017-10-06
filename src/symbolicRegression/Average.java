package symbolicRegression;

public class Average extends Add
{
	public double evaluate() 
	{
		return super.evaluate() / children.size();
	}
	
	public Average create()
	{
		return new Average();
	}
	
	public int getMinChildren()
	{
		return 2;
	}
	
	public String getSymbol()
	{
		return "avg ";
	}
}
