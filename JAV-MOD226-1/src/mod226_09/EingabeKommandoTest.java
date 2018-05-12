package mod226_09;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Scanner;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class EingabeKommandoTest {

	@Test
	@DisplayName("testLiesBenutzerEingabe")
	void testLiesBenutzerEingabe() {
		String benutzerEingabe = "M25";
		Scanner scanner = new Scanner(benutzerEingabe);
		EingabeKommando ek = new EingabeKommando();
		ek.liesBenutzerEingabe();
		assertEquals(benutzerEingabe, ek.getBenutzerEingabe());
		scanner.close();
	}
	
	@AfterAll
    public static void teardown() {
		System.exit(0);
	}
	
	
	
}
