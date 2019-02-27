package mod226B_02.aufgabenausbuch;

/**
 * Example to demonstrate the local Class one of the inner Classes possible.
 * 
 * The local Class in this example is the IteratorImpl Class.
 * 
 * @author vinma
 *
 */
public interface Iterator_3_22 {
	boolean hasNext();

	Object next();
}

class List {
	private Element head, end;

	private static class Element {
		private Object obj;
		private Element next;
	}

	public void add(Object obj) {
		if (obj == null) {
			return;
		}

		Element newE = new Element();
		newE.obj = obj;

		if (head == null) {
			head = end = newE;
		}
		else {
			end.next = newE;
			end = newE;
		}
	}

	public Iterator_3_22 iterator() {
		class IteratorImpl implements Iterator_3_22 {
			private Element e = head;

			public boolean hasNext() {
				return e != null;
			}
			public Object next() {
				if (e == null) {
					return null;
				}
				Object obj = e.obj;
				e = e.next;
				return obj;
			}
		}
		return new IteratorImpl();
	}
}

class TestIterator_3_22 {
	public static void main(String[] args) {
		List list = new List();

		list.add("Element 1");
		list.add("Element 2");
		list.add("Element 3");
		list.add("TestIterator_3_22");

		Iterator_3_22 it = list.iterator();

		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}