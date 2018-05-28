package test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.Console;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ConsoleReadLineTest {

	private ConsoleReadLine crl;

	@BeforeEach
	void setUp() throws Exception {
		crl = new ConsoleReadLine();
		crl.setUserInput(""); // This is better done via Consturktor? no?
//		crl = new ConsoleReadLine("UserInput");
		}

	@AfterEach
	void tearDown() throws Exception {
		System.exit(0); // Does this prevent the test case from not ending?
//		crl.close();
	}

/* TODO test if it is possible to work with System.console to test the Console input via JUnit,
	since Console input this way can't be run in Eclipse IDE. */
	@SuppressWarnings("static-access")
	@Test
	@DisplayName("testUseSystemConsole: although not possible to use Console class in IDE with JUnit testable?")
	void testUseSystemConsole() {
		//FIXME this test should fail but it hangs in a loop, maybe the other test does not end properly
		assertEquals("Test", crl.getUserInput());
		
	}
	
	@Test
	@DisplayName("testUseSystemConsoleOLD: learn NullPointerExecption has to be handeld with System.console.readLine()!")
	void testUseSystemConsoleOLD() {

		// Console console = System.console(); // without 'if (console == null)' -> NullPointerExecption

		Console console = System.console();
		if (console == null) {
			System.out.println("No console: non-interactive mode!");
			System.exit(0);
		}

		System.out.print("Enter your username: ");
		String username = console.readLine("TestUserName"); // This is where the readLine would actually get the User input

		assertEquals("TestUserName", username);
	}

}
