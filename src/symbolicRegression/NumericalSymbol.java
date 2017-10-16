package symbolicRegression;

public abstract class NumericalSymbol extends Symbol
{
	public Terminal createEphemeralChild()
	{
		return new Terminal((Helper.random.nextDouble() * 2) - 1);
	}
}
