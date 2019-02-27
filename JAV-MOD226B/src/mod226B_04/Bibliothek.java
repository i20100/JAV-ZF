package mod226B_04;

/**
 * Example of task 2 from chapter 4, module 226-B, exercise: apply polymorphism
 * 
 * This is the initial start code given by the module.
 * 
 * @see https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
 * 
 * @author vinma
 *
 */
public class Bibliothek {
	@SuppressWarnings("unused")
	private Medium[] katalog;

	public void showSample(Medium m) {
		if (m instanceof Buch) {
			System.out.println(((Buch) m).sample);
		} else if (m instanceof CD) {
			Player p = new Player();
			p.playSound(((CD) m).sample);
		} else if (m instanceof DVD) {
			Player p = new Player();
			p.playVideo(((DVD) m).sample);
		}
	}
}

abstract class Medium { }

class Buch extends Medium {
	String sample;
}

class CD extends Medium {
	Sound sample;
}

class DVD extends Medium {
	Video sample;
}

class Sound { } // ... 

class Video { } // ... 

class Player {
	public void playVideo(Video v) {
		// Video anzeigen ...
	}
	public void playSound(Sound s) {
		// Sound spielen ...
	}
}
