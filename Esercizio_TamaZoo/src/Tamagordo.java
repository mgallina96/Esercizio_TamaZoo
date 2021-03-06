

import java.util.Random;

import myLib.Utility;

/**
 * @author Michele Franceschetti
 *
 */

public class Tamagordo extends Tamagotchi
{
	private static final float DEFAULT_SATIETY = 0;

	private static final float MIN_UNSATIETY_ATTRIBUTE_VALUE = 10;
	private static final float MAX_UNSATIETY_ATTRIBUTE_VALUE = 30;

	private static final float MAX_START_SATIETY = 90;
	private static final float MIN_START_SATIETY = 10;

	private static final float MIN_PERCENTAGE = 0.05f;
	private static final float MAX_PERCENTAGE = 10f;

	private float minValueOfSatiety;
	private float maxValueOfSatiety;

	private static double percentSatietyIncrement = 0.1;
	private static double percentSatietyDecrement = 0.1;

	private static final float SATISFACTION = MAX_VALUE;
	private float satiety;

	/**
	 * Default constructor.
	 */
	public Tamagordo()
	{
		super();
		this.satiety = DEFAULT_SATIETY;
	}

	/**
	 * Constructor.
	 * @param name The name of the Tamatriste.
	 * @param satisfaction Level of satisfaction.
	 * @param satiety Level of satiety.
	 */
	public Tamagordo(String name)
	{
		super(name);

		this.satiety = getRandomFloat(MIN_START_SATIETY, MAX_START_SATIETY);;

		updateState();
	}

	public void inizializeValues()
	{
		percentSatietyIncrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);
		percentSatietyDecrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);

		minValueOfSatiety = getRandomFloat(MIN_UNSATIETY_ATTRIBUTE_VALUE, MAX_UNSATIETY_ATTRIBUTE_VALUE);
	}

	/**
	 * Update the state of the Tamatriste.
	 */
	public void updateState()
	{
		if(satiety <= Tamagotchi.MIN_VALUE)
		{
			this.state = State.Death;
		}
		else if(satiety <= minValueOfSatiety)
		{
			this.state = State.Unsatisfied;
		}
		else
		{
			this.state = State.Satisfied;
		}

		satiety = Utility.clamp(satiety, MIN_VALUE, MAX_VALUE);
	}

	/**
	 * Gives a few biscuits to the Tamatriste.
	 * @param num The number of biscuits.
	 */
	public void giveBiscuits(int num)
	{
		for(int i = 0; i < num; i++)
		{
			satiety = satiety * (1 + (float)percentSatietyIncrement);
		}
	}

	/**
	 * Gives a few cares to the Tamatriste.
	 * @param num The number of cares.
	 */
	public void giveCares(int num)
	{
		satiety = satiety * (1 - (float)percentSatietyDecrement);
	}

	/**
	 * Returns a random value betweens min and max.
	 * @param min The min value.
	 * @param max The max value.
	 * @return The random value.
	 */
	public float getRandomFloat(float min, float max)
	{
		Random rand = new Random();

		return rand.nextFloat() * (max - min) + min;
	}

	/**
	 * @return The description of the Tamatriste.
	 */
	public String toString()
	{
		StringBuffer description = new StringBuffer(this.name);
		description.append(" Saziet�: " + Float.toString(this.satiety));
		description.append(" Soddisfazione: " + Float.toString(SATISFACTION));

		return description.toString();
	}
}
