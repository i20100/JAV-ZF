package save_and_load;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Create a File, use it, then delete it.
 * 
 * The first example creates a file then deletes it.
 * The second example shows how to use the old io API and its File.class and its
 * File.createTempFile method.
 * The third example uses the newer nio API, but does not work.
 * 
 * NOTE: There are two ways to create Temp Files, one with Files.class one with File.class
 * I was not able to use the newer nio API Temp File aka the Files.class, but 
 * able to create a temp file with the older io API and the File.class
 * 
 * NOTE: this is not using: Files.createTempFile(prefix, suffix, attrs)
 * because I can not make it to work on custom folders!
 * There is an attempt at the bottom with the createTempFile command.
 * If using the createTempFile it tries to put it in the OS? temp folder... 
 * 
 * @see Delete: https://docs.oracle.com/javase/tutorial/essential/io/delete.html
 * 
 * @author vinma
 *
 */
public class CreateFileTmpUseDel {

	public static void main(String[] args) throws IOException {

		// First example:
		// set Path to save_and_load folder
		// aka set filename, since I do not know how to do it afterwards!!!!
		Path txtFile = Paths.get("src/save_and_load/CreateFileTmpUseDel.txt");
		Path otherFile = Paths.get("src/save_and_load/CreateFileTmpUseDel.other");

		// Create file
		{
			try {
				Files.createFile(txtFile);
				Files.createFile(otherFile);
			} catch (IOException e) {
				e.printStackTrace();
			}

			// Print state and delete files again
			System.out.println("First example:");
			System.out.println("File exists:");
			System.out.format("%b %s %n", Files.exists(txtFile), txtFile.getFileName());
			System.out.format("%b %s %n", Files.exists(otherFile), otherFile.getFileName());

			try {
				System.out.println("Deleting:");
				System.out.printf("- %s \n"	+ "- %s \n", txtFile.getFileName(), otherFile.getFileName());
				Files.delete(txtFile);
				Files.delete(otherFile);
				System.out.println("Files deleted.\n");
			} catch (NoSuchFileException e) {
				e.printStackTrace();
			}
		}

		// Second example:
		File f = File.createTempFile("tmp", ".txt");
		// prints absolute path
		System.out.println("Second example:");
		System.out.println("File path: "+f.getAbsolutePath());
		// deletes file when the virtual machine terminate
		f.deleteOnExit();
		
		// Third example:
		/* Create temporary file, via createTempFile command
		 * I can't make it to work with either proposed solution from
		 *  Files.createTempFile. Both end with java.lang.NullPointerException */
		{
//			System.out.println("Third example:");
//			 // Try temporary with default folder, defined by JVM or OS?
//			
//							try {
//								// gives java.lang.NullPointerException
//								Files.createTempFile("myTempFile", ".tmp", null);
//							} catch (IOException e) {
//								e.printStackTrace();
//							}
//			
//			 // Try temporary with folder set by user
//			
//								// gives java.lang.NullPointerException
//						Files.createTempFile(tmpFile.getParent(), null, null, null);
		}

	}

}
