package symbolicRegression;

public class Decision extends Symbol
{
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
		return new Decision();
	}

	public int getMinChildren() 
	{
		return 2;
	}

	public String getSymbol() 
	{
		return "decide ";
	}

}
