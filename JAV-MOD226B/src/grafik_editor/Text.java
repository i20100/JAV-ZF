package grafik_editor;

public class Text extends Figur implements Gruppe{
	private int schriftgroesse;
	private String schriftart;
	private String text;
	
	public Text(int x, int y, int schriftgroesse, String schriftart, String text) {
		super(x, y);
		this.schriftgroesse = schriftgroesse;
		this.schriftart = schriftart;
		this.text = text;
	}

	/**
	 * @return the schriftgroesse
	 */
	public int getSchriftgroesse() {
		return schriftgroesse;
	}

	/**
	 * @param schriftgroesse the schriftgroesse to set
	 */
	public void setSchriftgroesse(int schriftgroesse) {
		this.schriftgroesse = schriftgroesse;
	}

	/**
	 * @return the schriftart
	 */
	public String getSchriftart() {
		return schriftart;
	}

	/**
	 * @param schriftart the schriftart to set
	 */
	public void setSchriftart(String schriftart) {
		this.schriftart = schriftart;
	}

	/**
	 * @return the text
	 */
	public String getText() {
		return text;
	}

	/**
	 * @param text the text to set
	 */
	public void setText(String text) {
		this.text = text;
	}

	@Override
	public void gruppenCompositeAktion() {
		super.setX(x+50);
		super.setY(y+50);
	}

}
