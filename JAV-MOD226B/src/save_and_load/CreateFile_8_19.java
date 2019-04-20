package save_and_load;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/**
 * Learned how to create a file via Files.createFile
 * 
 * 
 * @author vinma
 *
 */
public class CreateFile_8_19 {
	static String pathString = new String("src/save_and_load/test.txt");

	public static void main(String[] args) {

		// delete file if found, so program can run
		if (Files.exists(Paths.get(pathString))) {
			System.out.println("Previous file found, going to delet it first.");
			try {
				//			System.out.println("File exists: " + Files.exists(Paths.get(pathString);
				Files.deleteIfExists(Paths.get(pathString));
			} catch (IOException e) {
				e.printStackTrace();
			}
			System.out.println("File deleted: " + Paths.get(pathString));
			System.out.println("For demonstration purpose, this program will "
					+ "terminate now. Please rerun it to create a file.");
			return;
		}

		// create file if not exists
		try {
			Files.createFile(Paths.get(pathString));
			System.out.println("File created: " + Paths.get(pathString));
		} catch (IOException exception) {
			exception.printStackTrace();
		}

		/*
		 * how it is done in the book Program 8.19 called OpTest.java
		 * CLI program to operate files via Java?
		 * 
		 * open Questions: 
		 * operation; where does the argument come from?
		 * try it on the CMD or PowerShell
		 * 
		// args[0] where does the argument come from?
		String operation = args[0];

		try {
			switch (operation) {
			case "cf":
				Files.createDirectories(Paths.get("dir/test.txt"));
				break;
			}
		} catch (IOException e) {
			// example book: 
			//			System.err.println(e);
			e.printStackTrace();
		}
		 */

	}

}
