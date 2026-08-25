package workshop.account.entity;

public class Account {
	private string custID;
	private string acctID;
	private int balance;
	
	//getter method
	public string getCustID() {
		return custID;
	}
	//setter
	public void setCustID(string custID) {
		this.custID = custID;
	}

	public string getAcctID() {
		return acctID;
	}

	public void setAcctID(string acctID) {
		this.acctID = acctID;
	}

	public int getBalance() {
		return balance;
	}
	
	//입금
	public void deposit(int amount) {
		this.balance += amount;
	}
	
	//출금
	public void withdraw(int amount) {
		this.balance -= amount;
	}
}
