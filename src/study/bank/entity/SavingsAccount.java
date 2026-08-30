package study.bank.entity;

//기본 이자율이 적용되는 저축 계좌를 표현하는 클래스
public class SavingsAccount extends Account {
	private double interestRate;
	
	public SavingsAccount(String accountNumber, String ownerName, double balance, double interestRate) {
		//1. Account 클래스에 private으로 선언된 필드들은 직접 건드릴 수 없으므로 super(...)를 통해 부모 생성자에게 값을 넘겨주어야 함
		//2. Account 클래스 안에서 동일하게 String, String, double 형태의 매개변수를 받는 생성자를 찾아서 호출
		super(accountNumber, ownerName, balance);
		this.interestRate = interestRate;
	}
	public double getInterestRate() {
		return interestRate;
	}
	public void applyInterest() {
		double interest = getBalance() * (interestRate/100);
		super.deposit(interest);
		System.out.println("이자 " + interest + "원이 적용되었습니다. 현재 잔액: " + getBalance() + "원");
	}
	@Override
	public String toString() {
		return "계좌번호: " + getAccountNumber() + ", 소유자: " + getOwnerName() + ", 잔액: " + getBalance() + "원, 이자율: " + interestRate + "%";
	}
}
