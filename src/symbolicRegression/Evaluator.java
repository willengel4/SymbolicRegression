package symbolicRegression;

public abstract class Evaluator 
{
	public abstract double evaluate(Expression e);
	public abstract double getVariableValue(String variableId);
}