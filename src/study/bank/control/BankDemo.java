package study.bank.control;

import study.bank.entity.Bank;
import study.bank.entity.SavingsAccount;
import study.bank.exception.AccountNotFoundException;
import study.bank.exception.InsufficientBalanceException;
import study.bank.exception.WithdrawalLimitExceededException;

public class BankDemo {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // 1. 계좌 생성 테스트
        System.out.println("=== 계좌 생성 ===");
        bank.createSavingsAccount("홍길동", 10000, 3.0);
        bank.createCheckingAccount("김철수", 20000, 5000);
        bank.createSavingsAccount("이영희", 30000, 2.0);

        // 2. 전체 계좌 목록 출력
        System.out.println("");
        System.out.println("=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");
        System.out.println("");

        // 3. 입금/출금 테스트
        System.out.println("=== 입금/출금 테스트 ===");
        try {
            bank.deposit("AC1000", 5000);
            bank.withdraw("AC1001", 3000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 4. 이자 적용 테스트
        System.out.println("");
        System.out.println("=== 이자 적용 테스트 ===");
        try {
            ((SavingsAccount) bank.findAccount("AC1000")).applyInterest();
        } catch (AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 5. 계좌 이체 테스트
        System.out.println("");
        System.out.println("=== 계좌 이체 테스트 ===");
        try {
            bank.transfer("AC1002", "AC1001", 5000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
            System.out.println("");
        }

        // 6. 이체 후 계좌 목록 확인
        System.out.println("");
        System.out.println("=== 모든 계좌 목록 ===");
        bank.printAllAccounts();
        System.out.println("===================");

        // 7. 예외 처리 테스트 1: 출금 한도 초과
        try {
            bank.withdraw("AC1001", 6000);
        } catch (InsufficientBalanceException | AccountNotFoundException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
        
        // 8. 예외 처리 테스트 2: 잔액 부족
        try {
            bank.withdraw("AC1000", 50000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }

        // 9. 예외 처리 테스트 3: 미등록 계좌 조회/출금
        try {
            bank.withdraw("AC9999", 1000);
        } catch (AccountNotFoundException | InsufficientBalanceException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}