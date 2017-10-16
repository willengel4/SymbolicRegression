package symbolicRegression;

import java.util.ArrayList;

public abstract class Symbol 
{
	protected ArrayList<Symbol> children;
	protected int id;
	protected Symbol parent;
	
	public Symbol()
	{
		children = new ArrayList<Symbol>();
		parent = null;
	}
	
	public abstract double evaluate();
	public abstract Symbol create();
	public abstract int getMinChildren();
	public abstract String getSymbol();
	public abstract Terminal createEphemeralChild();
	
	public ArrayList<Symbol> getChildren()
	{
		return children;
	}
	
	public Symbol copy()
	{
		Symbol cpy = create();
		cpy.setId(id);
		
		for(int i = 0; i < children.size(); i++)
		{
			Symbol newChild = children.get(i).copy();
			cpy.addSymbol(newChild);
			newChild.setParent(cpy);
		}
		
		return cpy;
	}
	
	public void addSymbol(Symbol s)
	{
		children.add(s);
	}
	
	public String getExpression()
	{
		String expression = getSymbol();
		if(children.size() > 0)
		{
			expression = "(" + expression;
			for(int i = 0; i < children.size(); i++)
			{
				expression += children.get(i).getExpression();
				
				if(i != children.size() - 1)
					expression += " ";
			}
			expression = expression + ")";
		}
		
		return expression;
	}
	
	public void setId(int id)
	{
		this.id = id;
	}
	
	public int getId()
	{
		return id;
	}
	
	public Symbol getParent()
	{
		return parent;
	}
	
	public void setParent(Symbol p)
	{
		this.parent = p;
	}
}