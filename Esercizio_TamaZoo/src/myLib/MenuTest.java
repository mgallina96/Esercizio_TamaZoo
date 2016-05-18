package myLib;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Manuel
 *
 */
public class MenuTest
{
	private Menu menu;
	
	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception
	{
		String[] options = {"Start", "Options", "Exit"};
		menu = new Menu("Welcome%n", "%nInsert a command here: ", options);
	}

	/**
	 * Test method for {@link my_library.Menu#toString()}.
	 */
	@Test
	public void testToString()
	{
		StringBuffer layout = new StringBuffer();
		
		layout.append(String.format("Welcome%n"));
		
		layout.append(String.format(" 1 > Start%n"));
		layout.append(String.format(" 2 > Options%n"));
		layout.append(String.format(" 3 > Exit%n"));
		
		layout.append(String.format("%nInsert a command here: "));
		
		assertEquals(layout.toString(), menu.toString());
	}
}
