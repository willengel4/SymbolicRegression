package symbolicRegression;

import java.util.ArrayList;

public abstract class Symbol 
{
	/* The inputs to this symbol */
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
	
	/* Returns the children */
	public ArrayList<Symbol> getChildren()
	{
		return children;
	}
	
	/* Deep copy of the Symbol */
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
	
	/* Adds s */
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