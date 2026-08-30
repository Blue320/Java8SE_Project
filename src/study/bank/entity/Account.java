package study.bank.entity;

import study.bank.exception.InsufficientBalanceException;

public class Account {
	private String accountNumber;
	private String ownerName;
	private double balance;
	
	public Account(String accountNumber, String ownerName, double balance) {
		this.accountNumber = accountNumber;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public String getAccountNumber() {
		return accountNumber;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public double getBalance() {
		return balance;
	}
	
	// 입금
	public void deposit(double amount) {
		this.balance += amount;
		System.out.println(amount + "원이 입금되었습니다. 현재 잔액: " + this.balance + "원");
	}
	// 출금
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (balance < amount) {
			throw new InsufficientBalanceException("출금 한도를 초과했습니다." + balance + "원");
		}
		this.balance -= amount;
		System.out.println(amount + "원이 출금되었습니다. 현재 잔액: " + this.balance + "원");
		}
	
	@Override
	public String toString() {
		return "계좌번호: " + accountNumber + "소유자: " + ownerName + "잔액: " + balance;
	}
}
