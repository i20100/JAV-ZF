package save_and_load;

import java.net.URI;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * PathExample is a Class to learn about the Path Class.
 * 
 * Most Examples used here are taken from: https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * 
 * @author vinma
 *
 */
public class PathExample {

	public static void main(String[] args) {

		@SuppressWarnings("unused")
		URI[] args1 = null; // *** see p2

		Path p1 = Paths.get("/tmp/foo");
//		Path p2 = Paths.get(args1[0]); // *** What would args1[0] be like ???
		@SuppressWarnings("unused")
		Path p3 = Paths.get(URI.create("file:///Users/joe/FileTest.java"));

		System.out.println("P1 as toUri():");
		System.out.format("%s%n", p1.toUri());

		//	The Paths.get method is shorthand for the following code:
		@SuppressWarnings("unused")
		Path p4 = FileSystems.getDefault().getPath("/users/sally");

		//	The following example creates /u/joe/logs/foo.log assuming your home directory is /u/joe, or C:\joe\logs\foo.log if you are on Windows.
		@SuppressWarnings("unused")
		Path p5 = Paths.get(System.getProperty("user.home"),"logs", "foo.log");

		// None of these methods requires that the file corresponding
		// to the Path exists.
		// Microsoft Windows syntax
//		Path pathWin = Paths.get("C:\\home\\joe\\foo");
		Path pathWin = Paths.get("C:/home/joe/foo");
		
		// Solaris syntax
		//	Path pathUnix = Paths.get("/home/joe/foo");


		System.out.format("toString: %s%n", pathWin.toString());
		System.out.format("getFileName: %s%n", pathWin.getFileName());
		System.out.format("getName(0): %s%n", pathWin.getName(0));
		System.out.format("getNameCount: %d%n", pathWin.getNameCount());
		System.out.format("subpath(0,2): %s%n", pathWin.subpath(0,2));
		System.out.format("getParent: %s%n", pathWin.getParent());
		System.out.format("getRoot: %s%n", pathWin.getRoot());


	}

}
