package symbolicRegression;

public class TextInterface 
{
	public static void main(String[] args) 
	{
		Variable x1 = new Variable(4, "x1");
		Variable x2 = new Variable(10, "x2");
				
		ExpressionGenerator generator = new ExpressionGenerator();
		generator.setMaxDepth(5);
		generator.addToFunctionSet(new Add());
		generator.addToFunctionSet(new Multiply());
		generator.addToFunctionSet(new Average());
		generator.addToFunctionSet(new Decision(4));
		generator.addToFunctionSet(new Max());

		generator.addToTerminalSet(x1);
		generator.addToTerminalSet(x2);
		
		ExampleEvaluator evaluator = new ExampleEvaluator();
		
		Genome bestGenome = null;
		Population currentPopulation = new Population(evaluator, generator, 50);
	
		for(int i = 0; i < 100; i++)
		{
			Population next = currentPopulation.createNextGeneration();

			if(bestGenome == null || currentPopulation.getBestGenome().getFitness() > bestGenome.getFitness())
				bestGenome = currentPopulation.getBestGenome();
			
			System.out.println("Best Fitness: " + bestGenome.getFitness());
			
			currentPopulation = next;
		}
		
		System.out.println(bestGenome.getExpression().getRoot().getExpression());
		
		System.out.println("Best Error: " + evaluator.evaluate(bestGenome.getExpression()));
	}
}