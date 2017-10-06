package symbolicRegression;

public class CrossoverHandler 
{
	private Expression parent1, parent2;
	private Expression offspring1, offspring2;
	
	public CrossoverHandler(Expression parent1, Expression parent2)
	{
		this.parent1 = parent1;
		this.parent2 = parent2;
	}
	
	public void performCrossover()
	{
		/* Copy each parent directly into offspring */
		offspring1 = parent1.copy();
		offspring2 = parent2.copy();
		
		int crossoverPoint1 = Helper.random.nextInt(parent1.getNumSymbols());
		int crossoverPoint2 = Helper.random.nextInt(parent2.getNumSymbols());
		
		System.out.println("Crossover point 1: " + crossoverPoint1 + "  Crossover point 2: " + crossoverPoint2);
		
		Symbol subtree1 = offspring1.findSymbolWithId(offspring1.getRoot(), crossoverPoint1);
		Symbol subtree2 = offspring2.findSymbolWithId(offspring2.getRoot(), crossoverPoint2);
		
		Symbol parent1 = subtree1.getParent();
		Symbol parent2 = subtree2.getParent();
		
		if(parent1 == null && parent2 == null)
		{
			System.out.println("Both parents null!");
		}
		else if(parent1 == null)
		{
			System.out.println("Parent 1 null!");
			
			offspring1.setRoot(subtree2);
			
			int subtree2Index = -1;
			for(int i = 0; i < parent2.getChildren().size(); i++)
				if(parent2.getChildren().get(i) == subtree2)
					subtree2Index = i;
			parent2.getChildren().set(subtree2Index, subtree1);
			
			System.out.println("Subtree2 index: " + subtree2Index);
		}
		else if(parent2 == null)
		{
			System.out.println("Parent 2 null!");
			offspring2.setRoot(subtree1);
			
			int subtree1Index = -1;
			for(int i = 0; i < parent1.getChildren().size(); i++)
				if(parent1.getChildren().get(i) == subtree1)
					subtree1Index = i;
			parent1.getChildren().set(subtree1Index, subtree2);
			System.out.println("Subtree1 index: " + subtree1Index);
		}
		else
		{
			System.out.println("Both trees are sub trees!");
			
			int subtree1Index = -1;
			for(int i = 0; i < parent1.getChildren().size(); i++)
				if(parent1.getChildren().get(i) == subtree1)
					subtree1Index = i;
			
			int subtree2Index = -1;
			for(int i = 0; i < parent2.getChildren().size(); i++)
				if(parent2.getChildren().get(i) == subtree2)
					subtree2Index = i;
			
			parent1.getChildren().set(subtree1Index, subtree2);
			parent2.getChildren().set(subtree2Index, subtree1);
			
			System.out.println("Subtree1 index: " + subtree1Index);
			System.out.println("Subtree2 index: " + subtree2Index);
		}
		
		offspring1.synchIds();
		offspring2.synchIds();
	}
	
	public Expression getParent1()
	{
		return parent1;
	}
	
	public Expression getParent2()
	{
		return parent2;
	}
	
	public Expression getOffspring1()
	{
		return offspring1;
	}
	
	public Expression getOffspring2()
	{
		return offspring2;
	}
}
