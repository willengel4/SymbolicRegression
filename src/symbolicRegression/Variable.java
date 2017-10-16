package symbolicRegression;

public class Variable extends Terminal
{
	private String variableId;
	private Evaluator evaluator;
	
	public Variable(double value, String variableId, Evaluator evaluator) 
	{
		super(value);
		this.variableId = variableId;
		this.evaluator = evaluator;
	}
	
	public void setVariableId(String variableId)
	{
		this.variableId = variableId;
	}
	
	public double evaluate()
	{
		return evaluator.getVariableValue(variableId);
	}
	
	public String getVariableId()
	{
		return variableId;
	}
	
	public Variable create()
	{
		return new Variable(getValue(), variableId, evaluator);
	}
	
	public String getSymbol()
	{
		return variableId +"";
	}
}
