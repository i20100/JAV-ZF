package save_and_load;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Date;

/**
 * Java Tutorial, Java SE 11
 * 
 * Covering chapters:
 * 1.2 Writing to an Object Stream
 * 1.3 Reading from an Object Stream
 * 
 * @see https://docs.oracle.com/en/java/javase/11/docs/specs/serialization/serial-arch.html#the-serializable-interface
 * 
 */
@SuppressWarnings("serial")
public class Write_and_read_to_ObjectStream implements Serializable {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

		// Serialize today's date to a file.
		FileOutputStream f = new FileOutputStream("src/save_and_load/date");
		ObjectOutput so = new ObjectOutputStream(f);
		so.writeObject("Today");
		so.writeObject(new Date());
		so.flush();

		// own added code
		so.close();
		f.close();
		

		// Deserialize a string and date from a file.
//		InputStream in = Files.newInputStream(manFileT3, StandardOpenOption.DELETE_ON_CLOSE);

		FileInputStream in = new FileInputStream("src/save_and_load/date");
		ObjectInputStream si = new ObjectInputStream(in);
		String today = (String)si.readObject();
		Date date = (Date)si.readObject();

		// own added code
		System.out.println(today);
		System.out.println(date);
		si.close();
		in.close();
	}
}
