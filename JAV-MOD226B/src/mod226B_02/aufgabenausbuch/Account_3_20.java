package mod226B_02.aufgabenausbuch;

/**
 * Example to demonstrate the static Class one of the inner Classes possible.
 * 
 * The static class in this example is the Permissions Class.
 * 
 * @author vinma
 *
 */
public class Account_3_20 {
	private int userId;
	private Permissions perm;

	public Account_3_20(int userId) {
		this.userId = userId;
		perm = new Permissions();
	}

	public int getUserId() {
		return userId;
	}

	public static class Permissions {
		public boolean canRead;
		public boolean canWrite;
		public boolean canDelete;
	}

	public Permissions getPermissions() {
		return perm;
	}
}

class TestAccount_3_20 {
	public static void main(String[] args) {
		Account_3_20 account = new Account_3_20(4711);

		Account_3_20.Permissions perm = account.getPermissions();
		perm.canRead = true;

		System.out.println(perm.canRead);
		System.out.println(perm.canWrite);
		System.out.println(perm.canDelete);
	}
}
