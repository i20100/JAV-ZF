package mod226B_04;

/**
 * Example of task 2 from chapter 4, module 226-B, exercise: apply polymorphism
 * 
 * This is the modified code, applied polymorphism, on the original file Bibliothek.java.
 * 
 * @see https://docs.oracle.com/javase/tutorial/java/IandI/polymorphism.html
 * 
 * @author vinma
 *
 */
public class Bibliothek_pm {
	@SuppressWarnings("unused")
	private Medium_pm[] katalog;

	public void showSample(Medium_pm m) {
		m.showSample();
	}
}

abstract class Medium_pm { 
	protected abstract void showSample();

}

class Buch_pm extends Medium_pm {
	String sample;

	@Override
	protected void showSample() {
		System.out.println(sample);
	}
}

class CD_pm extends Medium_pm {
	Sound_pm sample;

	@Override
	protected void showSample() {
		Player_pm p = new Player_pm();
		p.playSound(sample);

	}
}

class DVD_pm extends Medium_pm {
	Video_pm sample;

	@Override
	protected void showSample() {
		Player_pm p = new Player_pm();
		p.playVideo(sample);
	}
}

class Sound_pm { } // ... 

class Video_pm { } // ... 

class Player_pm {
	public void playVideo(Video_pm v) {
		// Video anzeigen ...
	}
	public void playSound(Sound_pm s) {
		// Sound spielen ...
	}
}
