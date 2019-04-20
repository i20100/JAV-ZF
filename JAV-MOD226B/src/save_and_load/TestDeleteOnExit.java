package save_and_load;

import java.io.File;

/**
 * Test: void java.io.File.deleteOnExit()
 * 
 * @author vinma
 *
 */
public class TestDeleteOnExit {

	public static void main(String[] args) {

		// Example from https://www.tutorialspoint.com/java/io/file_deleteonexit.htm
		File f = null;

		try {
			// creates temporary file
			f = File.createTempFile("tmp", ".txt");

			// prints absolute path
			System.out.println("File path: "+f.getAbsolutePath());

			// deletes file when the virtual machine terminate
			f.deleteOnExit();

			// creates temporary file
			f = File.createTempFile("tmp", null);

			// prints absolute path
			System.out.print("File path: "+f.getAbsolutePath());

			// deletes file when the virtual machine terminate
			f.deleteOnExit();

		} catch(Exception e) {
			// if any error occurs
			e.printStackTrace();
		}
	}

}
