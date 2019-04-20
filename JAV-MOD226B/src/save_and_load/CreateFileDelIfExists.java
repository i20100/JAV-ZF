package save_and_load;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Test setup to learn about Files.deleteIfExists(String name)
 * 
 * CreateFileDelIfExists.java is designed to be run at least twice.
 * 1. Run should create a file and inform about its creation.
 * 2. Run should inform the file already exists and will now be deleted with 
 * the Files.deleteIfExists() method.
 * 
 * @author vinma
 *
 */
public class CreateFileDelIfExists {

	public static void main(String[] args) throws IOException {

		System.out.println("Test CreateFile then delete it if it exists.");
		Path file = Paths.get("src/save_and_load/TestFileDelIfExists.txt");

		if (Files.exists(file)) {
			System.out.printf("Test aborted/finished. Found file %s and deleted it: ", file.getFileName());
			System.out.println(Files.deleteIfExists(file));
			System.out.println("\nTest run two of two completed.");
			return;
		}

		try {
			Files.createFile(file);
			System.out.printf("File %s created.\n", file.getFileName());
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.printf("File %s exists = %b. \n\n", file.getFileName(), Files.exists(file));
		System.out.println("Test run one of two completed. Rerun this test please.");

	}

}
