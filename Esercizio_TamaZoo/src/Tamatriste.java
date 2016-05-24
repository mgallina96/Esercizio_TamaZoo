

import java.util.Random;

import myLib.Utility;

/** 
 * @author Michele Franceschetti
 * 
 */

public class Tamatriste extends Tamagotchi
{
	private static final float DEFAULT_SATISFACTION = 0;
	private static final float DEFAULT_SATIETY = 0;
	
	private static final float MIN_UNSATISFIED_ATTRIBUTE_VALUE = 10;
	private static final float MAX_UNSATISFIED_ATTRIBUTE_VALUE = 30;
	
	private static final float MAX_START_SATISFACTION = 90;
	private static final float MIN_START_SATISFACTION = 10;
    private static final float MAX_START_SATIETY = 90;
	private static final float MIN_START_SATIETY = 10; 
	
	private static final float MIN_PERCENTAGE = 0.05f;
	private static final float MAX_PERCENTAGE = 10f;
	
	private float minValueOfSatisfaction;
	private float minValueOfSatiety;
	private float maxValueOfSatiety;
	
	private float percentSatietyIncrement;
	private float percentSatisfactionIncrement;
	private float percentSatietyDecrement;
	private float percentSatisfactionDecrement;
	
	private float satisfaction;
	private float satiety;
	
	//private String name;
	//protected float satisfaction;
	//protected float satiety;
	
	/**
	 * Default constructor.
	 */
	public Tamatriste()
	{
		super();
		this.satisfaction = DEFAULT_SATISFACTION;
		this.satiety = DEFAULT_SATIETY;
	}
	
	/**
	 * Constructor.
	 * @param name The name of the Tamatriste.
	 * @param satisfaction Level of satisfaction.
	 * @param satiety Level of satiety.
	 */
	public Tamatriste(String name)
	{
		super(name);
		
		this.satisfaction = getRandomFloat(MIN_START_SATISFACTION, MAX_START_SATISFACTION);
		this.satiety = getRandomFloat(MIN_START_SATIETY, MAX_START_SATIETY);;
		
		updateState();
	}
	
	public void inizializeValues()
	{
		percentSatietyIncrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);
		percentSatisfactionIncrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);
		percentSatietyDecrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);
		percentSatisfactionDecrement = getRandomFloat(MIN_PERCENTAGE, MAX_PERCENTAGE);
		
		
	}
	
	/**
	 * Update the state of the Tamatriste.
	 */
	public void updateState()
	{
		if((satiety * satisfaction <= Tamagotchi.MIN_VALUE) || satiety >= Tamagotchi.MAX_VALUE)
		{
			this.state = State.Death;
		}
		else if(satisfaction < minValueOfSatisfaction || satiety < minValueOfSatiety || satiety > maxValueOfSatiety)
		{
			this.state = State.Unsatisfied;
		}
		else
		{
			this.state = State.Satisfied;
		}
		
		satiety = Utility.clamp(satiety, MIN_VALUE, MAX_VALUE);
		satisfaction = Utility.clamp(satisfaction, MIN_VALUE, MAX_VALUE);
	}
	
	/**
	 * Gives a few biscuits to the Tamatriste.
	 * @param num The number of biscuits.
	 */
	public void giveBiscuits(int num)
	{
		for(int i = 0; i < num; i++)
		{
			satiety =  satiety * (1 + percentSatietyIncrement);
		}
		
		satisfaction = satisfaction * (1 - percentSatisfactionDecrement);
	}

	/**
	 * Gives a few cares to the Tamatriste.
	 * @param num The number of cares.
	 */
	public void giveCares(int num)
	{
		for(int i = 0; i < num; i++)
		{
			satisfaction =  satisfaction * (1 + percentSatisfactionIncrement);
		}
		
		satiety = satiety * (1 - percentSatietyDecrement);
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
		description.append(" Sazietà: " + Float.toString(this.satiety));
		description.append(" Soddisfazione: " + Float.toString(this.satisfaction));
		
		return description.toString(); 
	}
}
