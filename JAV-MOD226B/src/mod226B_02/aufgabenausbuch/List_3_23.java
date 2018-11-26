package mod226B_02.aufgabenausbuch;

public class List_3_23 {
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

	public Iterator iterator() {
		return new Iterator() {
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
		};
	}

}

class TestList_3_23 {
	public static void main(String[] args) {
		List list = new List();

		list.add("Element 1");
		list.add("Element 2");
		list.add("Element 3");

		Iterator it = list.iterator();

		while (it.hasNext()) {
			String s = (String) it.next();
			System.out.println(s);
		}
	}
}