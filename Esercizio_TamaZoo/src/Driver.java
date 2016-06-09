import myLib.*;
import java.util.Scanner;

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

	private static final String NAME_MESSAGE = "Inserire un nome: ";

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Menu menu = new Menu(COMMAND_MESSAGE, MENU_OPTIONS);
		Menu subMenu = new Menu(SUB_COMMAND_MESSAGE, SUBMENU_OPTIONS);
		Scanner sc = new Scanner(System.in);
		TamaZoo zoo = new TamaZoo();

		boolean done = false;

		System.out.println(HEADER_MESSAGE);

		while(!done)
		{
			zoo.updateState();
			System.out.print(String.format(zoo.toString()));
			System.out.print(menu.toString());

			switch(menu.inputCommand(sc))
			{
			case 1: zoo.giveBiscuits();
				break;
			case 2: zoo.giveCares();
				break;
			case 3:{
				System.out.println(String.format(SUB_HEADER_MESSAGE));
				System.out.print(subMenu.toString());

				switch(subMenu.inputCommand(sc))
				{
				case 1: {
					System.out.print(NAME_MESSAGE);
					zoo.addTamagotchi(new Tamatriste(sc.next()));
				}
					break;
				case 2: {
					System.out.print(NAME_MESSAGE);
					zoo.addTamagotchi(new Tamagordo(sc.next()));
				}
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
