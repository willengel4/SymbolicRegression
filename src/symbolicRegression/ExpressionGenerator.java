package symbolicRegression;

import java.util.ArrayList;

public class ExpressionGenerator 
{
	private ArrayList<Symbol> functionSet;
	private ArrayList<Terminal> terminalSet;
	private ArrayList<Symbol> combinedSet;
	private int maxDepth;
	private int currentId;
	
	public ExpressionGenerator()
	{
		functionSet = new ArrayList<Symbol>();
		terminalSet = new ArrayList<Terminal>();
		combinedSet = new ArrayList<Symbol>();
		maxDepth = 10;
		currentId = 0;
	}
	
	public Expression generateSymbolicExpression(Symbol specificRoot)
	{
		currentId = 0;
		specificRoot.setId(currentId++);
		create(specificRoot, 1);
		return new Expression(specificRoot, currentId);
	}
	
	public Expression generateSymbolicExpression()
	{
		int randomIndex = Helper.random.nextInt(functionSet.size());
		Symbol root = functionSet.get(randomIndex).create();				
		return generateSymbolicExpression(root);
	}
	
	public void create(Symbol r, int depth)
	{
		if(r instanceof Terminal || depth > maxDepth)
			return;
		
		for(int i = 0; i < r.getMinChildren(); i++)
		{
			Symbol newSymbol = chooseASymbol(r, depth);
			newSymbol.setId(currentId++);
			newSymbol.setParent(r);
			r.addSymbol(newSymbol);
			create(newSymbol, depth + 1);
		}
	}
	
	private Symbol chooseASymbol(Symbol r, int depth)
	{
		if(depth == maxDepth)
		{
			int randomIndex = Helper.random.nextInt(terminalSet.size() + 1);
			Symbol newSymbol = randomIndex < terminalSet.size() ? terminalSet.get(randomIndex).create() : r.createEphemeralChild();
			return newSymbol;
		}
		else
		{
			int randomIndex = Helper.random.nextInt(combinedSet.size() + 1);
			Symbol newSymbol = randomIndex < combinedSet.size() ? combinedSet.get(randomIndex).create() : r.createEphemeralChild();
			return newSymbol;
		}		
	}
		
	private void synchCombinedSet()
	{
		combinedSet.clear();
		for(Symbol s : functionSet)
			combinedSet.add(s);
		for(Terminal s : terminalSet)
			combinedSet.add(s);
	}
	
	public void addToFunctionSet(Symbol f)
	{
		functionSet.add(f);
		synchCombinedSet();
	}
	
	public void addToTerminalSet(Terminal t)
	{
		terminalSet.add(t);
		synchCombinedSet();
	}
	
	public void setMaxDepth(int m)
	{
		maxDepth = m;
	}
	
	public int getMaxDepth()
	{
		return maxDepth;
	}
	
	public int getNumSymbols()
	{
		return currentId;
	}
}
