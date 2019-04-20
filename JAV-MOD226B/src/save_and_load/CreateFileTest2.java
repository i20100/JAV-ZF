package save_and_load;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Next Try with Example form Stackoverflow: https://stackoverflow.com/questions/2885173/how-do-i-create-a-file-and-write-to-it-in-java
 * 
 * @author vinma
 *
 */
public class CreateFileTest2 {
	public static void main(String[] args) {
		
//	Path file = Paths.get("the-file-name.txt"); // Creates the File @ Project Level! 'C:\Users\vinma\Documents\GitHub\JAV-ZF\JAV-MOD226B'
	Path file = Paths.get("C:\\Users\\vinma\\Docuents\\GitHub\\JAV-ZF\\JAV-MOD226B\\src\\save_and_load\\the-file-name.txt");
	
	
//	Files.write(file, "my Text", Charset.forName("UTF-8"));
	
	try {
		Files.writeString(file, "my Text");
	} catch (IOException e) {
		e.printStackTrace();
	}
	
	//Files.write(file, lines, Charset.forName("UTF-8"), StandardOpenOption.APPEND);
}

}