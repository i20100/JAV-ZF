package save_and_load;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Test Class to learn how to create Files
 * 
 * Starting Code was from: https://docs.oracle.com/javase/tutorial/essential/io/file.html
 * 
 * @author vinma
 *
 */
public class CreateFileTest {
	public static void main(String[] args) {
		
		Path path = Paths.get("C:\\Users\\vinma\\Documents\\GitHub\\JAV-ZF\\JAV-MOD226B\\src\\save_and_load");
		System.out.printf("%s to uri: \r\n", path.toString());
		System.out.println(path.toUri());

//			File file = new File(uri); // How would that work? If end of uri is not a folder? 

		// This example is also in Sololearn: try to get the code from there to run.
		@SuppressWarnings("unused")
		File doesNotWork = new File("DoesNotWork.txt"); // This does not work because the given Name is not valid

		// This not create a file neither 
		File file = new File("C:\\Users\\vinma\\Documents\\GitHub\\JAV-ZF\\JAV-MOD226B\\src\\save_and_load\\CreateFileTest.txt");
		
		System.out.printf("File %s exists?: ", file.getName());  
		System.out.printf(file.exists() + "\r\n");
//		path = Paths.get(URI.create("..\\uricreatetest.txt"));
		
		System.out.println("path to uri:");
		System.out.println(path.toUri());
		
		// Code to read
//		byte[] fileArray; 
//		fileArray = Files.readAllBytes(file);
	}

}