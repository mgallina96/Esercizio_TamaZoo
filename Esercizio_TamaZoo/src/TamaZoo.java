import java.util.ArrayList;

import myLib.Utility;

/**
 * @author Manuel Gallina
 */
public class TamaZoo
{
	//Constants
	private static final int MIN_RANDOM_BISCUITS = 1;
	private static final int MAX_RANDOM_BISCUITS = 10;
	private static final int MIN_RANDOM_CARES = 1;
	private static final int MAX_RANDOM_CARES = 10;

	//Attributes
	private ArrayList <Tamagotchi> tamagotchiList;

	//Getters and Setters
	/**
	 * @return The tamagotchiList.
	 */
	public ArrayList <Tamagotchi> getTamagotchiList()
	{
		return tamagotchiList;
	}

	/**
	 * @param tamagotchiList The tamagotchiList to set.
	 */
	public void setTamagotchiList(ArrayList <Tamagotchi> tamagotchiList)
	{
		this.tamagotchiList = tamagotchiList;
	}

	//Constructors
	/**
	 * Default constructor.
	 */
	public TamaZoo()
	{
		this.setTamagotchiList(new ArrayList <Tamagotchi>());
	}

	//Methods
	/**
	 * Updates the states of all the tamagotchis in this tamazoo.
	 */
	public void updateState()
	{
		for(int i = 0; i < getTamagotchiList().size(); i++)
		{
			this.getTamagotchiList().get(i).updateState();
		}
	}

	/**
	 * Gives all the tamgotchis in this tamaZoo a random amount of biscuits.
	 */
	public void giveBiscuits()
	{
		for(int i = 0; i < tamagotchiList.size(); i++)
		{
			tamagotchiList.get(i).giveBiscuits(Utility.rand(MIN_RANDOM_BISCUITS, MAX_RANDOM_BISCUITS));
		}
	}

	/**
	 * Gives all the tamgotchis in this tamaZoo a random amount of cares.
	 */
	public void giveCares()
	{
		for(int i = 0; i < tamagotchiList.size(); i++)
		{
			tamagotchiList.get(i).giveBiscuits(Utility.rand(MIN_RANDOM_CARES, MAX_RANDOM_CARES));
		}
	}

	/**
	 * Adds the given tamagotchi to this tamaZoo.
	 *
	 * @param tama the tamagotchi to add
	 */
	public void addTamagotchi(Tamagotchi tama)
	{
		this.getTamagotchiList().add(tama);
	}

	/**
	 * Removes the given tamagotchi to this tamaZoo.
	 *
	 * @param tama the tamagotchi to remove
	 */
	public void removeTamagotchi(Tamagotchi tama)
	{
		int i = 0;

		for(i = 0; i < getTamagotchiList().size(); i++)
			if(getTamagotchiList().get(i).getName().equals(tama.getName()))
				break;

		this.getTamagotchiList().remove(i);
	}

	@Override
	public String toString()
	{
		StringBuffer description = new StringBuffer();

		for(int i = 0; i < tamagotchiList.size(); i++)
		{
			description.append(tamagotchiList.get(i).toString() + " Stato: "+ tamagotchiList.get(i).state +"%n");
		}

		return description.toString();
	}
}
