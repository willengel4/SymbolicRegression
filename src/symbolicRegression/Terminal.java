package symbolicRegression;

public class Terminal extends Symbol
{
	private double value;
	
	public Terminal(double value)
	{
		this.value = value;
	}
	
	public double evaluate()
	{
		return value;
	}
	
	/* Terminals should be shallow copied */
	public Terminal create()
	{
		return new Terminal(value);
	}
	
	public int getMinChildren()
	{
		return 0;
	}
	
	public String getSymbol()
	{
		return value +"";
	}
	
	public void setValue(double value)
	{
		this.value = value;
	}
	
	public double getValue()
	{
		return value;
	}

	public Terminal createEphemeralChild() 
	{
		return null;
	}
}