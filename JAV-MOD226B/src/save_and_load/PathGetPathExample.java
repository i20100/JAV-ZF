package save_and_load;

import java.nio.file.Path;
import java.nio.file.Paths;

public class PathGetPathExample {

	public static void main(String[] args) {
		
		/* sets path to current dir
		 * 
		 * NOTE: This works only if the folders are set up as this current
		 *  Eclipse Project if this code should run in a deployed program.
		 *  
		 * NOTE: Why does this work in the first place? It seems that
		 *  some Path is automatically set when launching a main method.
		 *  If a file is created, without telling the system where to create
		 *  it, it will be created in the top folder of this Eclipse Project.
		 *  If I recall correctly the JVM will have variables like a Path.
		 *  Eclipse might set variables like Path as well.
		 */
		Path path = Paths.get("src/save_and_load");
		System.out.println(path.toAbsolutePath());

	}

}
