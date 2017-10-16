package symbolicRegression;

import java.util.ArrayList;
import java.util.Hashtable;

public class ExampleEvaluator extends Evaluator
{
	private ArrayList<Double> x1s;
	private ArrayList<Double> x2s;
	private ArrayList<Double> ys;
	private Hashtable<String, Double> currentVariables;
	
	public ExampleEvaluator()
	{
		x1s = new ArrayList<Double>();
		x2s = new ArrayList<Double>();
		ys = new ArrayList<Double>();
				
		x1s.add(new Double(4));
		x2s.add(new Double(3));
		ys.add(new Double(19));
		
		x1s.add(new Double(2));
		x2s.add(new Double(3));
		ys.add(new Double(7));
		
		x1s.add(new Double(7));
		x2s.add(new Double(10));
		ys.add(new Double(59));
		
		x1s.add(new Double(1));
		x2s.add(new Double(10));
		ys.add(new Double(11));
		
		currentVariables = new Hashtable<String, Double>();
	}
	
	public double evaluate(Expression e) 
	{		
		double totalError = 0.0;
		
		for(int i = 0; i < ys.size(); i++)
		{			
			currentVariables.put("x1", x1s.get(i));
			currentVariables.put("x2", x2s.get(i));
			
			double prediction = e.getRoot().evaluate();			
			double err = Math.abs(prediction - ys.get(i));
						
			totalError += err;
		}
				
		if(totalError > 200)
			totalError = 200;
				
		return totalError;
	}

	public double getVariableValue(String variableId) 
	{
		return currentVariables.get(variableId);
	}
}