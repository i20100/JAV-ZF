package grafik_editor;

import java.awt.Graphics;

public class Text extends Figur implements Gruppe{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4431767579872354809L;
	private int schriftgroesse;
	private String schriftart;
	private String text;
	private double strecken;

	public Text(int x, int y, String text) {
		super(x, y);
		this.text = text;
	}

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

	@Override
	void strecken(double faktor) {
		setStrecken(faktor);
	}

	/**
	 * @return the strecken
	 */
	public double getStrecken() {
		return strecken;
	}

	/**
	 * @param strecken the strecken to set
	 */
	public void setStrecken(double strecken) {
		this.strecken = strecken;
	}

	@Override
	void spiegeln(boolean vertikal) {
		// not implemented, cause over the limit of this Lesson!		
	}

	@Override
	public void drehen() {
		// not implemented, cause over the limit of this Lesson!		
	}

	@Override
	protected void zeichne(Graphics g) {
		// TODO Text Optionen wiederherstellen wie beim alten Status
		//		{
		//		//g.setFont(new Font(null, 0, 20)); // Tester for Fontsize
		//		Text t = (Text) f;
		//		// if strecken() shall be applied do:
		//		if (t.getStrecken() != 0) {
		//			Font originalFont = g.getFont(); // save current font
		//			if (t.getSchriftgroesse() == 0) {
		//				t.setSchriftgroesse(12);
		//			}
		//			g.setFont(new Font(null, 0, (int) (t.getSchriftgroesse()*t.getStrecken())));
		//			g.drawString(t.getText(), t.x, t.y);
		//			g.setFont(originalFont); // re apply current font
		//		}
		//		// if strecken() shall not be applied do:
		//		else if (t.getStrecken() == 0) {
		//			g.drawString(t.getText(), t.x, t.y);
		//		}
		//		}
		
		
	}

}
