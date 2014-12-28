package com.sdzee.bdd;

public class Checks
{
	Checks()
	{
		
	}
	
	boolean isAlphanumeric(String str)
	{
		int counter = 0;
		while (counter < str.length())
		{
			if (str.charAt(counter) < 'A' || (str.charAt(counter) > 'Z' && str.charAt(counter) < 'a')
					|| str.charAt(counter) > 'z')
					if (str.charAt(counter) < '0' || str.charAt(counter) > '9')
						return (false);
			++counter;
		}
		return (true);
	}
	
	boolean isFloat(String str)
	{
		int counter = 0;
		int dotCounter = 0;
		while (counter < str.length())
		{
			if (str.charAt(counter) < '0' || str.charAt(counter) > '9')
			{
				if (dotCounter == 0)
					++dotCounter;
				else if (dotCounter > 0)
					return (false);
			}
			++counter;
		}
		return (true);
	}
	
	boolean isNumeric(String str)
	{
		int counter = 0;
		while (counter < str.length())
		{
			if (str.charAt(counter) < '0' || str.charAt(counter) > '9')
				return (false);
			++counter;
		}
		return (true);
	}
	
	boolean isAlphabetic(String str)
	{
		int counter = 0;
		while (counter < str.length())
		{
			if (str.charAt(counter) < 'A' || (str.charAt(counter) > 'Z' && str.charAt(counter) < 'a')
					|| str.charAt(counter) > 'z')
				return (false);
			++counter;
		}
		return (true);
	}
	
	boolean isAlphanumericWithPointsAt(String str)
	{
		int counter = 0;
		while (counter < str.length())
		{
			if (str.charAt(counter) < 'A' || (str.charAt(counter) > 'Z' && str.charAt(counter) < 'a')
					|| str.charAt(counter) > 'z')
				if (str.charAt(counter) < '0' || str.charAt(counter) > '9')
					if (str.charAt(counter) != '.' && str.charAt(counter) != '@')
						return (false);
			++counter;
		}
		return (true);
	}
}
