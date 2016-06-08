package myLib;

import java.util.Scanner;

/**
 * @author Manuel
 *
 */
public class Menu
{
	//Constants.

	//Attributes.
	private String[] options;
	private String commandMessage;

	//Constructors.
	/**
	 * Class constructor.
	 *
	 * @param _headerMessage the string to print on the header of this menu
	 * @param _commandMessage the string printed to request a command from the user
	 * @param _options the {@code String} array which contains all the menu options
	 */
	public Menu( String _commandMessage, String[] _options)
	{
		this.options = _options;
		this.commandMessage = _commandMessage;
	}

	//Methods.
	/**
	 * Gets the command from the user.
	 *
	 * @param sc the scanner in use
	 * @return the {@code int} command
	 */
	public int inputCommand(Scanner sc)
	{
		return (int)Utility.inputNumber(sc);
	}

	/**
	 * Returns the textual layout of this menu.
	 */
	public String toString()
	{
		StringBuffer layout = new StringBuffer();

		for(int i = 0; i < this.options.length; i++)
		{
			layout.append(String.format(" %d > %s%n", (i + 1), this.options[i]));
		}

		layout.append(String.format(this.commandMessage));

		return layout.toString();
	}
}
