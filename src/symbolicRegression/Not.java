package symbolicRegression;

public class Not extends Symbol
{
	public double evaluate() 
	{
		return Helper.interpret(!Helper.interpret(children.get(0).evaluate()));
	}

	public Symbol create() 
	{
		return new Not();
	}

	public int getMinChildren() 
	{
		return 1;
	}

	public String getSymbol() 
	{
		return "not ";
	}
}
