package symbolicRegression;

import java.util.ArrayList;

public class ExpressionGenerator 
{
	private ArrayList<Symbol> functionSet;
	private ArrayList<Terminal> terminalSet;
	private int maxDepth;
	private int currentId;
	
	public ExpressionGenerator()
	{
		functionSet = new ArrayList<Symbol>();
		terminalSet = new ArrayList<Terminal>();
		maxDepth = 10;
		currentId = 0;
	}
	
	public Expression generateSymbolicExpression()
	{
		int randomIndex = Helper.random.nextInt(functionSet.size());
		currentId = 0;
		Symbol root = functionSet.get(randomIndex).create();
		root.setId(currentId++);
		
		create(root, 1);
		
		return new Expression(root, currentId);
	}
	
	public void create(Symbol r, int depth)
	{
		for(int i = 0; i < r.getMinChildren(); i++)
		{
			int randomIndex;
			if(depth < maxDepth)
				randomIndex = Helper.random.nextInt(functionSet.size() + terminalSet.size());
			else
				randomIndex = Helper.random.nextInt(terminalSet.size()) + functionSet.size();
			
			if(randomIndex < functionSet.size() && depth < maxDepth)
			{
				Symbol child = functionSet.get(randomIndex).create();
				child.setId(currentId++);
				child.setParent(r);
				r.addSymbol(child);
				create(child, depth + 1);
			}
			else
			{
				int termIndex = randomIndex - functionSet.size();
				Terminal t = terminalSet.get(termIndex).create();
				t.setParent(r);
				t.setId(currentId++);
				r.addSymbol(t);
			}
		}
	}
	
	public void addToFunctionSet(Symbol f)
	{
		functionSet.add(f);
	}
	
	public void addToTerminalSet(Terminal t)
	{
		terminalSet.add(t);
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
