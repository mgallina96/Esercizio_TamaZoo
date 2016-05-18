package tamaZoo;

import java.util.ArrayList;

/**
 * @author Manuel Gallina
 *
 */
public class TamaZoo
{
	//Constants.

	//Attributes.
	private ArrayList <Tamagotchi> tamagotchiList; 
	
	//Getters and setters.

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

	//Constructors.
	/**
	 * Default constructor.
	 */
	public TamaZoo()
	{
		this.setTamagotchiList(new ArrayList <Tamagotchi>()); 
	}
	
	//Methods.
	/**
	 * Udates the states of all the tamagotchis in this tamazoo.
	 */
	public void updateState()
	{
		for(int i = 0; i < getTamagotchiList().size(); i++)
		{
			this.getTamagotchiList().get(i).updateState();
		}
	}
	
	/**
	 * Adds the given tamagotchi to this tamazoo.
	 * 
	 * @param tama the tamagotchi to add
	 */
	public void addTamagotchi(Tamagotchi tama)
	{
		this.getTamagotchiList().add(tama);
	}
	
	/**
	 * Removes the given tamagotchi to this tamazoo.
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
}
