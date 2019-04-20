package save_and_load;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * This Code is taken from:
 * https://docs.oracle.com/javase/tutorial/essential/io/pathOps.html
 * 
 * @author vinma
 *
 */
public class FileTest {
    public static void main(String[] args) {

        if (args.length < 1) {
            System.out.println("usage: FileTest file");
            System.exit(-1);
        }

        // Converts the input string to a Path object.
        Path inputPath = Paths.get(args[0]); // Original Example
        
        // Own Example Path, Btw. does not work!
//        Path inputPath = Paths.get("/tmp/foo"); 
//        System.out.println(inputPath.toUri());

        // Converts the input Path
        // to an absolute path.
        // Generally, this means prepending
        // the current working
        // directory.  If this example
        // were called like this:
        //     java FileTest foo
        // the getRoot and getParent methods
        // would return null
        // on the original "inputPath"
        // instance.  Invoking getRoot and
        // getParent on the "fullPath"
        // instance returns expected values.
        @SuppressWarnings("unused")
		Path fullPath = inputPath.toAbsolutePath();
    }
}