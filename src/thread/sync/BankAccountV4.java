package thread.sync;

import util.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import static util.MyLogger.log;

public class BankAccountV4 implements BankAccount {

    private int balance;

    private final Lock lock = new ReentrantLock();


    public BankAccountV4(int initialBalance) {
        this.balance = initialBalance;
    }

    @Override
    public int getBalance() {
        lock.lock(); // ReentrantLock 이용하여 lock을 걸기
        try{
            return balance;
        }finally {
            lock.unlock();
        }


    }


    @Override
    public boolean withdraw(int amount) {
        log("거래시작 : " + getClass().getSimpleName());

        lock.lock(); //ReentrantLock 이용하여 lock을 걸기

        try{
            log("[검증 시작] 출금액: " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                log("[검증 실패] 출금액 : " + amount + ", 잔액 : " + balance);
                return false;
            }
            // 잔고가 출금액보다 많으면 진행
            log("[검증 완료] 출금액: " + amount + ", 잔액 : " + balance);

            ThreadUtils.sleep(1000); //출금에 걸리는 시간으로 가정
            balance = balance - amount;
            log("[출금 완료] 출금액: " + amount + ", 잔액 : " + balance);
        }finally {
            lock.unlock();
        }
        log("거래 종료");

        return true;
    }
}
