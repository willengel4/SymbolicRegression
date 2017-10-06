package symbolicRegression;

public class TextInterface 
{
	public static void main(String[] args) 
	{
		ExpressionGenerator generator = new ExpressionGenerator();
		generator.setMaxDepth(3);
		generator.addToFunctionSet(new Add());
		generator.addToFunctionSet(new Average());
		generator.addToFunctionSet(new Divide());
		generator.addToTerminalSet(new Terminal(2));
		generator.addToTerminalSet(new Terminal(5));
		generator.addToTerminalSet(new Terminal(10));
		
		Expression ex1 = generator.generateSymbolicExpression();
		Expression ex2 = generator.generateSymbolicExpression();
		
		System.out.println("Parent1: " + ex1.getRoot().getExpression());
		System.out.println("Parent2: " + ex2.getRoot().getExpression());
		
		CrossoverHandler c = new CrossoverHandler(ex1, ex2);
		
		c.performCrossover();
		
		Expression offspring1 = c.getOffspring1();
		Expression offspring2 = c.getOffspring2();
		
		System.out.println("Offspring1: " + offspring1.getRoot().getExpression());
		System.out.println("Offspring2: " + offspring2.getRoot().getExpression());
	}
}