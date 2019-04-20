package save_and_load;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Program 8.17 from the book to learn the new Java 7 I/O API
 *
 * *** learn about static Paths.get, why is it static?
 * Is this why I have trouble to learn how this works?
 * DONE fix Errors in this file aka all uncommented code
 * *** fix error path.toRealPath() java.nio.file.NoSuchFileException
 * Look for error in those lines:
 * //		path = Paths.get("././src/../PathTest_8_17.java");
 * //		path = Paths.get("src/../PathTest_8_17.java");
 * *** learn about . and .. aka . current dir? .. dir one up?
 * 
 * *** clean up all // comments, then your are done with this file
 * 
 * @author vinma
 *
 */
public class PathTest_8_17 {

	public static void main(String[] args) throws IOException {

		// System.getProperty("user.dir") gives you current working directory
		// here this is the top folder of the current Eclipse project		
		// user.dir stands for 'User's current working directory' in JVM?
		String dir = System.getProperty("user.dir"); // @see Properties java.lang.System.getProperties()

		// Since I know the tree structure for my project I can then set the path to sub folders and a specific file: 

		Path path = Paths.get(dir, "src\\save_and_load", "PathTest_8_17.java");
		Path pathDirOnly = Paths.get(dir);

		System.out.println("Paths.get(dir, \"src\", \"PathTest_8_17.java\") is: " + path); // > C:\Users\vinma\Documents\GitHub\JAV-ZF\JAV-MOD226B\src\PathTest_8_17.java
		System.out.println("Paths.get(dir) is: " + pathDirOnly); // > C:\Users\vinma\Documents\GitHub\JAV-ZF\JAV-MOD226B

		System.out.println("fileName for path: " + path.getFileName());
		System.out.println("fileName for pathDirOnly: " + pathDirOnly.getFileName());
		System.out.println("parent: " + path.getParent());
		System.out.println("root: " + path.getRoot());

		System.out.println("exists: " + Files.exists(path));
		System.out.println("isDirectory: " + Files.isDirectory(path));
		System.out.println("isRegularFile: " + Files.isRegularFile(path));
		System.out.println("isReadable: " + Files.isReadable(path));
		System.out.println("isWritable: " + Files.isWritable(path));
		System.out.println("size: " + Files.size(path));
		System.out.println("getLastModifiedTime: " + Files.getLastModifiedTime(path));
		System.out.println("getOwner: " + Files.getOwner(path));

		int n = path.getNameCount();

		for (int i = 0; i < n; i++) {
			System.out.print(path.getName(i)+ " ");
		}
		System.out.println();

		for (Path element : path) {
			System.out.print(element + " ");
		} 
		System.out.println();

		//		path = Paths.get("././src/../PathTest_8_17.java");
		//		path = Paths.get("src/../PathTest_8_17.java");
		System.out.println("path: " + path);
		System.out.println("normalized: " + path.normalize());
		System.out.println("absolutePath: " + path.toAbsolutePath());

		// Works without the new path assignment 'path = Path.get("./....)' from Line 61-62
		System.out.println("toRealPath: " + path.toRealPath()); // XXX ??? Exception in thread "main" java.nio.file.NoSuchFileException

		// The pathDirOnly.toRealPath() works, why does path.toRealPath() not?
		System.out.println("toRealPath: " + pathDirOnly.toRealPath()); 
	}

}
