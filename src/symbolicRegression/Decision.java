package symbolicRegression;

public class Decision extends Symbol
{
	private int numOptions;
	
	public Decision(int numOptions)
	{
		super();
		this.numOptions = numOptions;
	}
	
	public double evaluate() 
	{
		int maxIndex = 0;
		
		for(int i = 0; i < children.size(); i++)
			if(children.get(i).evaluate() > children.get(maxIndex).evaluate())
				maxIndex = i;
		
		return maxIndex;
	}

	public Symbol create() 
	{
		return new Decision(numOptions);
	}

	public int getMinChildren() 
	{
		return numOptions;
	}

	public String getSymbol() 
	{
		return "decide ";
	}

}
