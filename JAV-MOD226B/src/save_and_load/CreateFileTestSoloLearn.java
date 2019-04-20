package save_and_load;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Formatter;

public class CreateFileTestSoloLearn {

	public static void main(String[] args) {

		//		Another copy from Sololearn
		// Copy from Internet https://www.sololearn.com/Play/Java:
		// Sololearn uses the Formatter class: @see Formatter(String fileName) for specifics

		// added my own path to make it work
		// this path "C:\\sololearn\\test.txt" does not work?
		// JavaDoc of Formatter(String fileName) states:
		// Formatter(String fileName) throws SecurityException
		// *** why does file class not work? 
		// File file = new File("C:\\Users\\vinma\\Documents\\GitHub\\JAV-ZF\\JAV-MOD226B\\src\\save_and_load\\CreateFileTest.txt");

		String pathAsString = new String("C:\\Users\\vinma\\Documents\\GitHub\\JAV-ZF\\JAV-MOD226B\\src\\save_and_load\\CreateFileTestSoloLearnFormatter.txt");
		Path path = Paths.get(pathAsString);

		// Create a file using Formatter Class
		if (Files.notExists(path)) {
			// This one works!
			try {
				@SuppressWarnings({ "resource", "unused" })
//				Formatter file = new Formatter(path); // Formatter does not work with Path
				Formatter file = new Formatter(pathAsString);
			} catch (Exception e) {
				e.printStackTrace();
				System.out.println(e);
			}
		}

		// Delete file if exists
		if (Files.exists(path)) {
			try {
				Files.deleteIfExists(path);
			} catch (IOException e) {
				// *** Auto-generated catch block
				e.printStackTrace();
			}
		}

		// *** Test SecurityException
		// Since the example from Sololearn does not work, what is the problem?

		//		java.io.FileNotFoundException: C:\sololearn\test.txt (Das System kann den angegebenen Pfad nicht finden)
		// maybe because the folder sololearn does not exist?
		try {
			@SuppressWarnings({ "resource", "unused" })
			Formatter f = new Formatter("C:\\sololearn\\test.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		// java.io.FileNotFoundException: C:\CreateFileTestSoloLearn.txt (Zugriff verweigert)
		// because access denied!
		try {
			@SuppressWarnings({ "resource", "unused" })
			Formatter f = new Formatter("C:\\CreateFileTestSoloLearn.txt");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// *** FIXME add this to java.md 
		// How to add more than one Exception?
		//	The way to stack Exceptions is to add another catch method as if 
		//	the catch method can be overloaded.

		// right way
		try {
			@SuppressWarnings({ "resource", "unused" })
			Formatter f = new Formatter("C:\\test.txt");
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} 

		// wrong way, nesting them
		try {
			try {
				@SuppressWarnings({ "resource", "unused" })
				Formatter f = new Formatter("C:\\test.txt");
			} catch (SecurityException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
