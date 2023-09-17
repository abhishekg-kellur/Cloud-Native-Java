package singleton;

class AccountDetails {
	private String AccountHolder;
	private int AccountNumber;
	private int balance;
	private static AccountDetails acc;
	
	public static AccountDetails getInstance(String name, int no, int bal) {
		if(acc == null) {
			synchronized (AccountDetails.class) {
				if(acc == null) {
					acc = new AccountDetails(name,no,bal);
				}
			}
		}
		return acc;
	}
	
	private AccountDetails(String name, int no, int bal) {
		this.AccountHolder = name;
		this.AccountNumber = no;
		this.balance = bal;
	}
	
	public int getAccountNumber() {
		return AccountNumber;
	}
	public String getAccountHolder() {
		return AccountHolder;
	}
	public int getBalance() {
		return balance;
	}
}

public class Singleton {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				AccountDetails acc = AccountDetails.getInstance("ramu", 65465486, 10500);
				System.out.println("T1-Name:" + acc.getAccountHolder());
				System.out.println("T1-Number:" + acc.getAccountNumber());
				System.out.println("T1-Balance:" + acc.getBalance());
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				AccountDetails acc = AccountDetails.getInstance("shamu", 89215486, 1500);
				System.out.println("T2-Name:" + acc.getAccountHolder());
				System.out.println("T2-Number:" + acc.getAccountNumber());
				System.out.println("T2-Balance:" + acc.getBalance());
			}
		});
		t1.start();
		t2.start();
	}
}
