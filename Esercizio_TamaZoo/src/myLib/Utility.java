package myLib;

import java.util.Random;
import java.util.Scanner;

/**
 * @author Manuel
 *
 */
public class Utility
{
	//Constants.
	private static final String DEFAULT_INPUT_NUMBER_MESSAGE = "%nInserire un numero: ";

	//Methods.
	/**
	 * Gets a <code>double</code> number as input from the keyboard.
	 * 
	 * The <code>inputMessage</code> should be a request for the user to input the number.
	 * If the message equals to <code>"default"</code> the default message is printed.
	 * 
	 * @param inputMessage a string to use as an interface with the user
	 * @param sc the scanner that reads from the keyboard
	 * @return the <code>double</code> number read from the keyboard.
	 * @throws IllegalArgumentException If the input cannot be translated into a valid <code>double</code> value.
	 */
	public static double inputNumber(String inputMessage, Scanner sc) throws IllegalArgumentException
	{
		double input = 0.0;
		
		if(inputMessage.equals("default"))
			inputMessage = String.format(DEFAULT_INPUT_NUMBER_MESSAGE);
		
		System.out.print(inputMessage);
		
		if(sc.hasNextDouble())
			input = sc.nextDouble();
		else
			throw new IllegalArgumentException("Non è stato inserito un numero.");
		
		while(sc.hasNext())
			sc.next();
		
		return input;
	}
	
	/**
	 * Generates a random <code>int</code> number between two given values.
	 * 
	 * @param min the minimum value
	 * @param max the maximum value
	 * @return a random <code>int</code> number between <code>min</code> and <code>max</code>
	 */
	public static int rand(int min, int max)
	{
		int tmp;
		
		Random randomGenerator = new Random();
		
		tmp = min + randomGenerator.nextInt(max - min);
		
		return tmp;
	}
}