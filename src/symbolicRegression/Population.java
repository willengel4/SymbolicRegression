package symbolicRegression;

import java.util.ArrayList;

public class Population 
{
	private Evaluator evaluator;
	private int numGenomes;
	private ExpressionGenerator generator;
	private ArrayList<Genome> genomes;
	private int pCopy = 1;
	private int pCrossover = 9;
	private Genome populationBest;
	
	public Population(Evaluator evaluator, ExpressionGenerator expGen, int numGenomes)
	{
		this.evaluator = evaluator;
		this.generator = expGen;
		this.numGenomes = numGenomes;
		this.genomes = new ArrayList<Genome>();
		createPopulation();
	}
	
	public void createPopulation()
	{
		for(int i = 0; i < numGenomes; i++)
			genomes.add(new Genome(generator.generateSymbolicExpression()));
	}
	
	public void evaluatePopulation()
	{
		double maxFitness = -1;
		
		for(Genome g : genomes)
		{
			g.setFitness(evaluator.evaluate(g.getExpression()));
			
			if(g.getFitness() > maxFitness)
				maxFitness = g.getFitness();
			

		}
		
		for(Genome g : genomes)
		{
			g.setFitness(maxFitness - g.getFitness());

			if(populationBest == null || g.getFitness() > populationBest.getFitness())
				populationBest = g;
		}
	}
	
	public Population createNextGeneration()
	{
		evaluatePopulation();
		
		Population nextGeneration = new Population(evaluator, generator, numGenomes);
		
		for(int i = 0; i < numGenomes; i++)
		{
			int lotto = Helper.random.nextInt(pCopy + pCrossover);
			
			if(lotto < pCopy)
			{
				nextGeneration.addGenome(selectGenome().copy());
			}
			else
			{
				Genome g1 = selectGenome();
				Genome g2 = selectGenome();
				
				CrossoverHandler crossoverHandler = new CrossoverHandler(g1.getExpression(), g2.getExpression());
				crossoverHandler.performCrossover();
				
				nextGeneration.addGenome(new Genome(crossoverHandler.getOffspring1()));
				nextGeneration.addGenome(new Genome(crossoverHandler.getOffspring2()));

				i++;	
			}			
		}
		
		return nextGeneration;
	}
	
	private Genome selectGenome()
	{
		double fitnessSum = 0.0;
		for(int i = 0; i < genomes.size(); i++)
			fitnessSum += genomes.get(i).getFitness();
		
		double lotto = Helper.random.nextDouble() * fitnessSum;
		double lo = 0.0, hi = 0.0;
				
		for(int i = 0; i < genomes.size(); i++)
		{
			hi = lo + genomes.get(i).getFitness();
						
			if(lotto <= hi)
				return genomes.get(i);
			
			lo = hi;
		}
		
		return null;
	}
	
	public Genome getBestGenome()
	{
		return populationBest;
	}
	
	public void addGenome(Genome g)
	{
		genomes.add(g);
	}
}
