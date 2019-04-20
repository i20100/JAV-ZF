package save_and_load;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Java Tutorial, Java SE 11
 * 
 * Covering chapters:
 * 1.2 Writing to an Object Stream
 * 1.3 Reading from an Object Stream
 * 
 * Enhanced by creating a Class, then saving the class and reloading it.
 * 
 * @see https://docs.oracle.com/en/java/javase/11/docs/specs/serialization/serial-arch.html#the-serializable-interface
 * 
 */
@SuppressWarnings("serial")
public class Write_and_read_to_ObjectStream_aClass implements Serializable {
//	List<Contact> contacts = new List<Contact>();
/* 
 * *** auto delete the file, that is written to disk!
 * -> learn about more about FileOutputStream?
 * -> changed all path to src/save_and_load/ for all 3 classes of Write_...
 * -> one solution found see CreateFileDelOnClose.java and StandardOpenOption.DELETE_ON_CLOSE
 *     this needs Files.newOutputStream!!
 */
//	DELETE_ON_CLOSE might be the solution, see https://docs.oracle.com/javase/tutorial/essential/io/file.html
//	*** well this actually fits in on the next task to learn file handling =)

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		Contact[] cL = {new Contact("Bob"), new Contact("Frank")};
		
		// Serialize today's date to a file.
		FileOutputStream f = new FileOutputStream("src/save_and_load/w_and_r_class");
		ObjectOutput so = new ObjectOutputStream(f);
		so.writeObject(cL);
		so.flush();
		
		// own added code
		so.close();
		f.close();
		
		cL[0] = new Contact("Bill");
		cL[1] = new Contact("Tom");
		
		System.out.println("Overwritten Bob with Bill:");
		System.out.println(cL[0].name);

		// Deserialize a string and date from a file.
		FileInputStream in = new FileInputStream("src/save_and_load/w_and_r_class");
		ObjectInputStream si = new ObjectInputStream(in);
		
//read back aka write back bob and frank to the Array
		cL = (Contact[]) si.readObject();
		
		// own added code
		System.out.println("Loaded old Contacts, Bob and Frank:");
		System.out.println(cL[0].name);
		System.out.println(cL[1].name);
		si.close();
		in.close();
		
		// *** attempt to delete file...
//		File tmp = File(get"src/save_and_load/w_and_r_class");
	}
}

@SuppressWarnings("serial")
class Contact implements Serializable {
	String name;
	
	public Contact(String name) {
		this.name = name;
	}
}
