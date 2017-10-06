package symbolicRegression;

import java.util.Random;

public class Helper 
{
	public static boolean interpret(double d)
	{
		return d > 0;
	}
	
	public static double interpret(boolean b)
	{
		if(b)
			return 1.0;
		else
			return -1.0;
	}
	
	public static Random random = new Random();
}
