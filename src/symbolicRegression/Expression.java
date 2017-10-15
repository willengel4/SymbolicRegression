package symbolicRegression;

import java.util.ArrayList;

public class Expression 
{
	private Symbol root;
	private int numSymbols;
	
	public Expression(Symbol root, int numSymbols)
	{
		this.root = root;
		this.numSymbols = numSymbols;
	}
	
	
	private void iterateAndCount(Symbol node)
	{
		node.setId(numSymbols++);
		for(Symbol c : node.getChildren())
			iterateAndCount(c);
	}
	
	public void synchIds()
	{
		numSymbols = 0;
		iterateAndCount(root);
	}
	
	public Symbol getRoot()
	{
		return root;
	}
	
	public int getNumSymbols()
	{
		return numSymbols;
	}
	
	public Expression copy()
	{
		Symbol copyRoot = root.copy();
		
		return new Expression(copyRoot, numSymbols);
	}
	
	public void setRoot(Symbol r)
	{
		this.root = r;
	}
	
	public Symbol findSymbolWithId(Symbol r, int id)
	{
		if(r.getId() == id)
			return r;
		
		if(r.getChildren().size() > 0)
		{
			for(Symbol s : r.getChildren())
			{
				Symbol searchResult = findSymbolWithId(s, id);
				
				if(searchResult != null)
					return searchResult;
			}
		}
		
		return null;
	}
}
