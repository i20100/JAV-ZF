package save_and_load;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Test the DELETE_ON_CLOSE option
 * 
 * DELETE_ON_CLOSE has two main ways to operate
 * - on closing the file/stream, 
 *   either manually with close() method or 
 *   automatically by surrounding with try & catch
 * - on closing the JVM
 * 
 * DONE test DELETE_ON_CLOSE -> manual test with manual (explorer) check of file creation and deletion
 * DONE Automate test -> How to Test the file exists y/n correctly and where?
 * DONE as good as I could: test all ways of DELETE_ON_CLOSE and prove they work as intended
 * test try/catch DELETE_ON_CLOSE not completed, since Test 1 and 3
 * are both using JVM best effort on DELETE_ON_CLOSE.  
 * DONE make a new file as CreateFileDelIfExists.java?
 * something like: Files.deleteIfExists(manFileT1);
 * This might actually be the best way to handle it? No?
 *	//		Files.deleteIfExists(manFileT1);
 *
 * https://stackoverflow.com/questions/18146637/delete-on-close-deletes-files-before-close-on-linux
 * 
 * @see DELETE_ON_CLOSE https://docs.oracle.com/javase/tutorial/essential/io/file.html
 * 
 * @author vinma
 *
 */
public class CreateFileDelOnClose {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Test 1: shows how DELETE_ON_CLOSE works by ending only the JVM
		{
			System.out.println("Test one, delete files on closing JVM:");
			Path manFileT1 = Paths.get("src/save_and_load/CreateFileDelOnCloseJVM.txt");

			if (Files.exists(manFileT1)) {
				System.out.printf("Test one, delete file %s first!", manFileT1.getFileName());
			}
			Files.createFile(manFileT1);
			System.out.printf("File %s exists = %b. \n\n", manFileT1.getFileName(), Files.exists(manFileT1));

			OutputStream out = Files.newOutputStream(manFileT1, StandardOpenOption.DELETE_ON_CLOSE);
			@SuppressWarnings("unused")
			ObjectOutputStream so = new ObjectOutputStream(out);
		}

		// Test 2: shows how DELETE_ON_CLOSE works by using close() method
		{
			System.out.println("Test two, closing file/stream manually:");		
			Path manFileT2 = Paths.get("src/save_and_load/CreateFileDelOnCloseMAN.txt");

			Files.createFile(manFileT2);
			System.out.printf("File %s exists = %b. \n\n", manFileT2.getFileName(), Files.exists(manFileT2));

			OutputStream out = Files.newOutputStream(manFileT2, StandardOpenOption.DELETE_ON_CLOSE);
			ObjectOutputStream so = new ObjectOutputStream(out);

			/* Question: How does manually closing work? Do you have to close 
			 * both the OutputStream and the ObjectOutputStream? Good style?
			 * Answer: Good style might be close both, but just to make the 
			 * DELETE_ON_CLOSE work. No. Only so.close() or out.close() work.
			 * 
			 * NOTE The file will be deleted even without manually closing the 
			 * InputStream and the ObjectInputStream. Because DELETE_ON_CLOSE 
			 * work with close() and on best effort without.
			 */
			out.close(); // either of those two work for DELETE_ON_CLOSE to delete the file instantly
			so.close();
		}

		// Test 3
		System.out.println("Test tree, closing file/stream automatically with try & catch:");		
		// set Path to save_and_load folder
		Path manFileT3 = Paths.get("src/save_and_load/CreateFileDelOnCloseT&C.txt");

		// Create file manually
		{
			try {
				Files.createFile(manFileT3);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		String someString = new String("Text to be saved then loaded");	

		// Serialize a String to a file.

		OutputStream out = Files.newOutputStream(manFileT3);
		ObjectOutputStream so = new ObjectOutputStream(out);

		so.writeObject(someString);
		so.flush();


		someString = "Text overwritten now";
		System.out.println(someString);

		// Deserialize a String from a file.

		// bit of code from https://stackoverflow.com/questions/18146637/delete-on-close-deletes-files-before-close-on-linux
		InputStream in = Files.newInputStream(manFileT3, StandardOpenOption.DELETE_ON_CLOSE);
		ObjectInputStream si = new ObjectInputStream(in);

		someString = (String) si.readObject();

		System.out.println("Loaded text: " + someString + "\n");


		/* Testing if File exists
		 * 
		 * 1. Checking if the file exists. Write result to console.
		 * 2. Added a wait command. Time to check the file in the folder. =) 
		 * 3. Checking if the file exists. Write result to console.
		 * 
		 * Question: Why does checking invoking the name in step 3. work even 
		 * though the file is deleted?
		 * Answer: The filename is taken from the path Object not the file Object.
		 */
		System.out.printf("File %s exists = %b. \n\n", manFileT3.getFileName(), Files.exists(manFileT3));

		/* add a wait time, to see if the file is actually created and then deleted
		 * DONE check it with your Windows file explorer */
		int time = 20_000; // time in milliseconds

		System.out.println("Waiting "+time/1000+" seconds to continue. "
				+ "Check the file in the folder if you want\n");

		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

		System.out.printf("File %s does not exist anymore = %b. \n", manFileT3.getFileName(), Files.exists(manFileT3));
	}

}
