package symbolicRegression;

public class Variable extends Terminal
{
	private String variableId;
	
	public Variable(double value, String variableId) 
	{
		super(value);
		this.variableId = variableId;
	}
	
	public void setVariableId(String variableId)
	{
		this.variableId = variableId;
	}
	
	public String getVariableId()
	{
		return variableId;
	}
	
	/* Terminals should be shallow copied */
	public Variable create()
	{
		return new Variable(getValue(), variableId);
	}
	
	public String getSymbol()
	{
		return variableId +"";
	}
}
