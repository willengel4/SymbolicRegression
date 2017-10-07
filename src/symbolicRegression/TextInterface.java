package symbolicRegression;

public class TextInterface 
{
	public static void main(String[] args) 
	{
		Terminal x = new Terminal(0);
		Terminal y = new Terminal(0);
		
		x.setValue(12324);
		
		ExpressionGenerator generator = new ExpressionGenerator();
		generator.setMaxDepth(3);
		generator.addToFunctionSet(new Add());
		generator.addToFunctionSet(new Average());
		generator.addToFunctionSet(new Divide());
		generator.addToTerminalSet(x);
		generator.addToTerminalSet(y);
		generator.addToTerminalSet(new Terminal(-1));
		
		ExampleEvaluator evaluator = new ExampleEvaluator(x, y);
		
		Population population = new Population(evaluator, generator, 5);
	
		Population next = population.createNextGeneration();
	}
}