package study.bank.entity;

import java.util.ArrayList;
import java.util.List;

import study.bank.exception.AccountNotFoundException;
import study.bank.exception.InsufficientBalanceException;

//전체 계좌 목록을 List로 관리하며 계좌 신규 개설,검색,입출금,이체 및 전체 계좌 조회를 총괄하는 은행 관리 클래스
public class Bank {
	private int nextAccountNumber;
	private List<Account> accounts;
	
	public Bank() {
	    this.accounts = new ArrayList<Account>();
	    this.nextAccountNumber = 1000;
	}
	public String createSavingsAccount(String ownerName, double initialBalance, double interestRate) {
		String accName = "AC" + nextAccountNumber;
		nextAccountNumber++;
		SavingsAccount account = new SavingsAccount(accName, ownerName, initialBalance, interestRate);
		accounts.add(account);
		System.out.println("저축 계좌가 생성되었습니다: " + account.toString());
		return accName;
	}
	public String createCheckingAccount(String ownerName, double initialBalance, double withdrawalLimit) {
		String accName = "AC" + nextAccountNumber;
		nextAccountNumber++;
		CheckingAccount account = new CheckingAccount(accName, ownerName, initialBalance, withdrawalLimit);
		accounts.add(account);
		System.out.println("체킹 계좌가 생성되었습니다: " + account.toString());
		return accName;
	}
	public Account findAccount(String accountNumber) throws AccountNotFoundException {
		for (Account account : accounts) {
			if (accountNumber.equals(account.getAccountNumber())) {
				return account;
			}
		}
		throw new AccountNotFoundException("계좌번호 " + accountNumber +"에 해당하는 계좌를 찾을 수 없습니다.");
	}
	public void deposit(String accountNumber, double amount) throws AccountNotFoundException {
		Account account = findAccount(accountNumber);
		account.deposit(amount);
	}
	public void withdraw(String accountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account account = findAccount(accountNumber);
		account.withdraw(amount);
	}
	public void transfer(String fromAccountNumber, String toAccountNumber, double amount) throws AccountNotFoundException, InsufficientBalanceException {
		Account account1 = findAccount(fromAccountNumber);
		account1.withdraw(amount);
		Account account2 = findAccount(toAccountNumber);
		account2.deposit(amount);
		System.out.println(amount + "원이 " + fromAccountNumber +"에서 " + toAccountNumber + "로 송금되었습니다.");
	}
	public void printAllAccounts() {
		for (Account account : accounts) {
			System.out.println(account.toString());
		}
	}
}