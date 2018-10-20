package grafik_editor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Compositeklasse = Behaehlter fuer die Gruppenobjekte.
 * 
 * @author Vincent
 *
 */
public class CompositeGruppe implements Gruppe {
	private List<Gruppe> childGruppe = new ArrayList<Gruppe>();

	@Override
	public void gruppenCompositeAktion() {
		for (Gruppe gruppe : childGruppe) {
			// do something for each 'gruppe' element
			gruppe.gruppenCompositeAktion(); // this is the method taken from the Interface
		}
	}


	public void add(Gruppe gruppenElement) {
		childGruppe.add(gruppenElement);
	}
}

