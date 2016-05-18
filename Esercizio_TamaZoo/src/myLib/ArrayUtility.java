package myLib;

/**
 * @author Manuel Gallina
 * Metodi per la gestione degli array.
 */
public class ArrayUtility 
{
	/**
	 * Initializes an array of <code>double</code> with a default value.
	 * 
	 * @param array the array to initialize 
	 * @param defaultValue the default <code>double</code> value
	 */
	public static void setArrayDefault(double array[], double defaultValue)
	{
		for(int i = 0; i < array.length; i++)
		{
			array[i] = defaultValue;
		}
	}
	
	/**
	 * Calculates the average value of an array of <code>double</code>.
	 * 
	 * @param array the array to calculate average value
	 * @return the average value of the array
	 * @throws IllegalArgumentException If the array contains no elements.
	 */
	public static double arrayAvg(double array[]) throws IllegalArgumentException
	{
		double sum = 0.0;
		
		for(int i = 0; i < array.length; i++)
		{
			sum += array[i];
		}
		
		return sum/array.length;
	}
}
