package save_and_load;

import java.nio.file.FileStore;
import java.nio.file.FileSystems;

/**
 * Class to learn how to use Path
 * 
 * Goals:
 * *** **do 8.12 from the Book! This should teach you the new I/O API!**
 * see PathTest_8_17.java
 * *** 1. Learn how to find your volume / hard drive Letter in Windows.
 * *** Learn how to find a File in a Windows Directory
 * *** Learn how to set a Path to a directory in Windows
 * *** Learn how to create a File in a given Path
 * *** Learn to set the path to current project/current application
 * 
 * @author vinma
 *
 */
public class PathLearnPath {

	public static void main(String[] args) {
		
		for (FileStore store: FileSystems.getDefault().getFileStores()) {

//			DONE find all volumes or hard drive letters
//			print FileStore as String
			System.out.println(store);
			System.out.print("Class of "+store+" is: ");
			System.out.println(store.getClass());
			
			System.out.print("Filestore.name() is: ");
			System.out.println(store.name());
			}
		
	}

}
