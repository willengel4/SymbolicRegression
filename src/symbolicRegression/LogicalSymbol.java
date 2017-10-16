package symbolicRegression;

public abstract class LogicalSymbol extends Symbol
{
	public Terminal createEphemeralChild()
	{
		return new Terminal(Helper.interpret(Helper.random.nextInt(2) > 0));
	}
}
