package symbolicRegression;

import java.util.ArrayList;

public class ExampleEvaluator extends Evaluator
{
	private ArrayList<Double> x1s;
	private ArrayList<Double> x2s;
	private ArrayList<Double> ys;
	
	public ExampleEvaluator()
	{
		x1s = new ArrayList<Double>();
		x2s = new ArrayList<Double>();
		ys = new ArrayList<Double>();
		
		//y = x1^2 + x2
		
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
	}
	
	public double evaluate(Expression e) 
	{
		e.synchVariables(e.getRoot());
		
		double totalError = 0.0;
		
		for(int i = 0; i < ys.size(); i++)
		{
			for(Variable v : e.getVariables())
			{
				if(v.getVariableId().equals("x1"))
					v.setValue(x1s.get(i));
				else if(v.getVariableId().equals("x2"))
					v.setValue(x2s.get(i));
			}
			double prediction = e.getRoot().evaluate();
			double err = Math.abs(prediction - ys.get(i));
			totalError += err;
		}
		
		if(totalError > 200)
			totalError = 200;
		
		return totalError;
	}
}
