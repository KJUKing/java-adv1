package thread.cas.spinlock;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class SpinLockBad {
    private volatile boolean lock = false;

    public void lock() {
        log("락 획득 시도");
        while (true) {
            if (!lock) { // 1. 락 사용 여부 확인
                sleep(100); // 문제 상황 확인용 스레드대기
                lock = true; // 2. 락의 값 변경
                break;
            } else {
                //락을 획득할때까지 스핀대기(바쁜대기)한다
                log("학 획득 실패 - 스핀 대기");

            }
        }
        log("락 획득 완료");

    }
    public void unlock() {
        lock = false;
        log("락 반납 완료");
    }
}
