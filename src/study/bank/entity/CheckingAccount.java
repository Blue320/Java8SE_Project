package study.bank.entity;

import study.bank.exception.InsufficientBalanceException;
import study.bank.exception.WithdrawalLimitExceededException;

//출금 한도 설정 및 관리, 출금 시 한도 초과 검사 기능을 제공하는 체킹 계좌 클래스
public class CheckingAccount extends Account {
	private double withdrawalLimit;
	
	public CheckingAccount(String accountNumber, String ownerName, double balance, double withdrawalLimit) {
		super(accountNumber, ownerName, balance);
		this.withdrawalLimit = withdrawalLimit;
	}
	public double getWithdrawalLimit() {
		return withdrawalLimit;
	}
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount > withdrawalLimit) {
			throw new WithdrawalLimitExceededException("출금 한도를 초과했습니다. 한도: " + withdrawalLimit + "원");
		}
		else {
			super.withdraw(amount);
		}
	}
	public String toString() {
		return "계좌번호: "+ getAccountNumber() +", 소유자: " + getOwnerName() + ", 잔액: " + getBalance() + "원, 출금 한도: " + withdrawalLimit +"원";
	}
}
