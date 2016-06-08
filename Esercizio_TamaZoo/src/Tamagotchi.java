

/**
 * @author Michele Franceschetti
 */

public abstract class Tamagotchi {

	protected static final int MIN_VALUE = 0;					//Range of internal variables
	protected static final int MAX_VALUE = 100;

	private static final String DEFAULT_NAME = "Default";

	protected int minBiscuits;				//Range of Biscuits
	protected int maxBiscuits;
	protected int minCares;					//Range of Cares
	protected int maxCares;

	protected float minValueOfSatisfaction;
	protected float minValueOfSatiety;
	protected float maxValueOfSatiety;

	protected float percentSatietyIncrement;
	protected float percentSatisfactionIncrement;
	protected float percentSatietyDecrement;
	protected float percentSatisfactionDecrement;

	protected float startSatisfaction;
	protected float startSatiety;

	/**
	 * Stati possibili del tamagotchi.
	 */
	public enum State
	{
		Satisfied,
		Unsatisfied,
		Death
	}

	public String name;
	public State state;

	public String getName()
	{
		return name;
	}

	/**
	 * Default constructor.
	 */
	public Tamagotchi()
	{
		this.name = DEFAULT_NAME;

		updateState();
	}

	/**
	 * Constructor.
	 * @param name The name.
	 * @param satisfaction Level of satisfaction.
	 * @param satiety Level of satiety.
	 */
	public Tamagotchi(String name)
	{
		this.name = name;

		updateState();
	}

	/**
	 * Update the state of the Tamagotchi.
	 */
	public abstract void updateState();

	/**
	 * Gives a few biscuits to the Tamagotchi.
	 */
	public abstract void giveBiscuits(int num);

	/**
	 * Gives a few cares to the Tamagotchi.
	 */
	public abstract void giveCares(int num);
}
