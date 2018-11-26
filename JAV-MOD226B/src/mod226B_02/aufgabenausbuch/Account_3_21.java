package mod226B_02.aufgabenausbuch;

/**
 * Example to demonstrate the instance Class one of the inner Classes possible.
 * 
 * The instance Class in this example is the Transaction Class.
 * 
 * @author vinma
 *
 */
public class Account_3_21 {
	private int accountNumber;
	private double balance;
	private Transaction last;

	public Account_3_21(int accountNumber, double balance) {
		super();
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

	public class Transaction {
		private String name;
		private double amount;

		public Transaction(String name, double amount) {
			this.name = name;
			this.amount = amount;
		}

		/* (non-Javadoc)
		 * @see java.lang.Object#toString()
		 * 
		 * Convert Transaction information into a readable String.
		 * 
		 * @return the current Transaction
		 */
		public String toString() {
			return accountNumber + ": " + name + " " + amount + ", balance "
					+ balance;
		}
	}

	/**
	 * Method to receive the last transaction as an object.
	 * 
	 * @return the last transaction
	 */
	public Transaction getLast() {
		return last;
	}

	public void deposit(double amount) {
		balance += amount;
		last = new Transaction("deposit", amount);
	}

	public void withdraw(double amount) {
		balance -= amount;
		last = new Transaction("withdraw", amount);
	}
}

class TestAccount_3_21 {
	public static void main(String[] args) {
		Account_3_21 a = new Account_3_21(4771, 1000.);

		a.deposit(500.);
		a.withdraw(700.); // This will create a new instance of Transaction and overwrite the old Instance.
		
		Account_3_21.Transaction t = a.getLast();
		System.out.println(t.toString());
	}
}
