import java.util.Random;

public class Tamagotchi {
	/**
	 * Minimo dei biscotti.
	 */
	public static final int MIN_BISCUITS = 1;				//Range of Biscuits
	/**
	 * Massimo dei biscotti.
	 */
	public static final int MAX_BISCUITS = 5;
	
	/**
	 * Minimo delle carezze.
	 */
	public static final int MIN_CARES = 1;					//Range of Cares
	/**
	 * Massimo delle carezze.
	 */
	public static final int MAX_CARES = 5;
	
	/**
	 * Valore minimo degli attributi "satisfaction" e "satiety".
	 */
	public static final int MIN_VALUE = 0;					//Range of internal variables
	/**
	 * Valore massimo degli attributi "satisfaction" e "satiety".
	 */
	public static final int MAX_VALUE = 100;
	
	/**
	 * Valore minimo di soddisfazione oltre il quale il tamgotchi è insoddisfatto. 
	 */
	public static final float MIN_VALUE_OF_SATISFACTION = 30;
	/**
	 * Valore minimo di sazietà oltre il quale il tamgotchi è insoddisfatto. 
	 */
	public static final float MIN_VALUE_OF_SATIETY = 30;
	/**
	 * Valore massimo di sazietà oltre il quale il tamgotchi è insoddisfatto. 
	 */
	public static final float MAX_VALUE_OF_SATIETY = 90;
	
	/**
	 * Incremento della sazietà per ogni biscotto.
	 */
	public static final float PERCENTAGE_SATIETY_INCREMENT = 0.1f;
	/**
	 * Incremento della soddisfazione per ogni carezza.
	 */
	public static final float PERCENTAGE_SATISFACTION_INCREMENT = 0.1f;
	/**
	 * Percentuale di decremento della sazietà per ogni carezza. 
	 */
	public static final float PERCENTAGE_SATIETY_DECREMENT = 0.1f;
	/**
	 * Percentuale di decremento della soddisfazione per ogni biscotto. 
	 */
	public static final float PERCENTAGE_SATISFACTION_DECREMENT = 0.1f;
	
	/**
	 * Valore di defalut del nome.
	 */
	public static final String DEFAULT_NAME = "Default";
	/**
	 * Valore di defalut della soddisfazione.
	 */
	public static final int DEFAULT_SATISFACTION = MAX_VALUE;
	/**
	 * Valore di defalut della sazietà.
	 */
	public static final int DEFAULT_SATIETY = 80;
	
	/**
	 * Stati possibili del tamagotchi.
	 */
	public enum State
	{
		Satisfied,
		Unsatisfied,
		Death
	};
	
	private String name;
	private float satisfaction;
	private float satiety;
	/**
	 * Stato del tamagotchi.
	 */
	public State state; 
	
	/**
	 * @return il nome.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * @param name Il nome.
	 */
	public void setName(String name) 
	{
		this.name = name;
	}
	/**
	 * @return la soddisfazione.
	 */
	public float getSatisfaction() 
	{
		return satisfaction;
	}
	
	/**
	 * @param satisfaction La soddisfazione.
	 */
	public void setSatisfaction(float satisfaction) 
	{
		this.satisfaction = satisfaction;
	}
	/**
	 * @return la sazietà.
	 */
	public float getSatiety() 
	{
		return satiety;
	}
	/**
	 * @param satiety La sazietà.
	 */
	public void setSatiety(float satiety) 
	{
		this.satiety = satiety;
	}
	/**
	 * Costruttore di default.
	 */
	public Tamagotchi()
	{
		this.name = DEFAULT_NAME;
		this.satisfaction = DEFAULT_SATISFACTION;
		this.satiety = DEFAULT_SATIETY;
		
		updateState();
	}
	
	/**
	 * Costruttore.
	 * @param name Nome.
	 * @param satisfaction Soddisfazione.
	 * @param satiety Sazietà.
	 */
	public Tamagotchi(String name, int satisfaction, int satiety)
	{
		this.name = name;
		this.satisfaction = satisfaction;
		this.satiety = satiety;
		
		updateState();
	}
	
	/**
	 * Aggiorna lo stato del tamagotchi in funzione dei parametri.
	 */
	public void updateState()
	{
		if((satiety * satisfaction <= MIN_VALUE) || satiety >= MAX_VALUE)
		{
			this.state = State.Death;
		}
		else if(satisfaction < MIN_VALUE_OF_SATISFACTION || satiety < MIN_VALUE_OF_SATIETY || satiety > MAX_VALUE_OF_SATIETY)
		{
			this.state = State.Unsatisfied;
		}
		else
		{
			this.state = State.Satisfied;
		}
		
		satiety = clamp(satiety, MIN_VALUE, MAX_VALUE);
		satisfaction = clamp(satisfaction, MIN_VALUE, MAX_VALUE);
	}
	
	/**
	 * Da un numero casuale di biscotti al tamagotchi.
	 */
	public void giveBiscuits()
	{
		Random rand = new Random();
		
		int numBiscuits = rand.nextInt(MAX_BISCUITS - MIN_BISCUITS) + MIN_BISCUITS;
		
		for(int i = 0; i < numBiscuits; i++)
		{
			satiety =  satiety * (1 + PERCENTAGE_SATIETY_INCREMENT);
		}
		
		satisfaction = satisfaction * (1 - PERCENTAGE_SATISFACTION_DECREMENT * (2 + (int)MAX_BISCUITS/3));
	}
	
	/**
	 * Da un numero casuale di biscotti al tamagotchi.
	 */
	public void giveCares()
	{
		Random rand = new Random();
		
		int numCares = rand.nextInt(MAX_CARES - MIN_CARES) + MIN_CARES;
		
		for(int i = 0; i < numCares; i++)
		{
			satisfaction =  satisfaction * (1 + PERCENTAGE_SATISFACTION_INCREMENT);
		}
		
		satiety = satiety * (1 - PERCENTAGE_SATIETY_DECREMENT * (1 +(int)MAX_CARES/2));
	}
	
	/**
	 * @return La descrizione del tamagotchi.
	 */
	public String toString()
	{
		StringBuffer description = new StringBuffer(this.name);
		description.append(" Sazietà: " + Float.toString(this.satiety));
		description.append(" Soddisfazione: " + Float.toString(this.satisfaction));
		
		return description.toString(); 
	}
	
	/**
	 * Costringe il valore entro i limiti.
	 * @param value Il valore.
	 * @param min Il limite minimo.
	 * @param max Il limite massimo.
	 * @return Il valore entro i limiti.
	 */
	static public float clamp(float value, float min, float max)
	{
		if(value > max)
			value = max;
		if(value < min)
			value = min;
		
		return value;
	}
}
