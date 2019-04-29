package grafik_editor;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

public class FigurLoader {

	/**
	 * Enables loading of saved Figur objects
	 * 
	 * Deletes the saved Figur File when loading is done.
	 * 
	 * @param display
	 * @param file 
	 * @return
	 * @throws FileNotFoundException
	 * @throws IOException
	 */
	public static Zeichnung load(Display display, File file) throws FileNotFoundException, IOException {
		
		// Deserialize from a file.
		FileInputStream in = new FileInputStream(file);
		ObjectInputStream si = new ObjectInputStream(in);
		
		// Revert Stream into object
		try {
			display = (Display) si.readObject();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		si.close();
		in.close();
		
		// Delete File? "src/grafik_editor/figurObjekte.m226"
//		File f = File("src/grafik_editor/figurObjekte.m226"); ??
		// best way with File f.deleteOnExit(); method?
		file.deleteOnExit();

		return display.zeichnung;
	}

}
