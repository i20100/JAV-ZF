package grafik_editor;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 * Enables saving of Figur objects
 * 
 * @author vinma
 *
 */
@SuppressWarnings("serial")
public class FigurSaver implements Serializable {
	
	public static void save(Display display, File file) throws IOException {
		// DONE change the path of this file to current dir
//		FileOutputStream fo = new FileOutputStream("src/grafik_editor/figurObjekte.m226");
//		Take the file from a final global path variable located FigurFile class?
		
		FileOutputStream fo = new FileOutputStream(file);
		ObjectOutput so = new ObjectOutputStream(fo);
		
		// TODO play around, learn to save single Figur-object or retrieve single object
//		Display d = display;
//		Zeichnung z = d.zeichnung;
//		z.?
		
		so.writeObject(display);
		so.flush();

		// close the Streams
		so.close();
		fo.close();		
	}

}
