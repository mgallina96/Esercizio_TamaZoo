package tamaZoo;

import java.util.Scanner;

import my_library.Menu;

/**
 * @author Manuel Gallina
 *
 */
public class Driver
{
	private static final String[] MENU_OPTIONS = {"Dai dei biscotti", "Dai delle carezze", "Aggiungi un tamagotchi", "Esci"};
	private static final String HEADER_MESSAGE = "Benvenuto nel tuo TamaZoo%n%n";
	private static final String COMMAND_MESSAGE = "%nInserire un comando: ";
	
	private static final String[] SUBMENU_OPTIONS = {"TamaTriste", "TamaGordo",};
	private static final String SUB_HEADER_MESSAGE = "Aggiungi nuovo tamagotchi%n%n";
	private static final String SUB_COMMAND_MESSAGE = "%nInserire un comando: ";
	
	private static final String DEATH_MESSAGE = "%n%s è morto";
	private static final String UNSATISFIED_MESSAGE = "%n%s è infelice";
	private static final String SATISFIED_MESSAGE = "%n%s è felice";
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Menu menu = new Menu(HEADER_MESSAGE, COMMAND_MESSAGE, MENU_OPTIONS);
		Menu subMenu = new Menu(SUB_HEADER_MESSAGE, SUB_COMMAND_MESSAGE, SUBMENU_OPTIONS);
		Scanner sc = new Scanner(System.in);
		TamaZoo zoo = new TamaZoo();
		
		boolean done = false;
		
		while(!done)
		{
			System.out.print(menu.toString());
			zoo.updateState();
			
			for(int i = 0; i < zoo.getTamagotchiList().size(); i++)
				switch(zoo.getTamagotchiList().get(i).state)
				{
				case Death: System.out.printf(DEATH_MESSAGE, zoo.getTamagotchiList().get(i).getName());
					break;
				case Unsatisfied: System.out.printf(UNSATISFIED_MESSAGE, zoo.getTamagotchiList().get(i).getName());
					break;
				case Satisfied: System.out.printf(SATISFIED_MESSAGE, zoo.getTamagotchiList().get(i).getName());
				}
			
			switch(menu.inputCommand(sc))
			{
			case 1: zoo.giveBiscuits();
				break;
			case 2: zoo.giveCares();
				break;
			case 3:{
				System.out.print(subMenu.toString());
								
				switch(subMenu.inputCommand(sc))
				{
				case 1: zoo.addTamagotchi(new Tamatriste());
					break;
				case 2: zoo.addTamagotchi(new Tamagordo());
					break;
				default: 
					break;
				}
			}
				break;
			case 4:done = true;
				break;
			default: 
				break;
			}
		}
	}
}
