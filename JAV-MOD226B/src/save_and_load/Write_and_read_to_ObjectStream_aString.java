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
 * Enhanced by creating a String, then saving it and reloading it.
 * 
 * @see https://docs.oracle.com/en/java/javase/11/docs/specs/serialization/serial-arch.html#the-serializable-interface
 * 
 */
@SuppressWarnings("serial")
public class Write_and_read_to_ObjectStream_aString implements Serializable {
	
	public static void main(String[] args) throws IOException, ClassNotFoundException {
		String someString = new String("Text to be saved then loaded");	
		
		// Serialize a String to a file.
		FileOutputStream f = new FileOutputStream("src/save_and_load/w_and_r_string");
		ObjectOutput so = new ObjectOutputStream(f);
		so.writeObject(someString);
		so.flush();

		// own added code
		so.close();
		f.close();
		
		someString = "Text overwritten now";
		System.out.println(someString);
		
		// Deserialize a String from a file.
		FileInputStream in = new FileInputStream("src/save_and_load/w_and_r_string");
		ObjectInputStream si = new ObjectInputStream(in);
		someString = (String) si.readObject();

		// own added code
		si.close();
		in.close();
		
		System.out.println("Loaded text: " + someString);
		
	}
}
