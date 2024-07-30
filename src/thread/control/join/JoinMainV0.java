package thread.control.join;

import util.MyLogger;
import util.ThreadUtils;

import static util.MyLogger.*;

public class JoinMainV0 {
    public static void main(String[] args) {
        log("start");
        Thread thread1 = new Thread(new Job(), "thread-1");
        Thread thread2 = new Thread(new Job(), "thread-2");
        log("End");

        thread1.start();
        thread2.start();
    }

    static class Job implements Runnable {

        @Override
        public void run() {
            log("작업 시작");
            ThreadUtils.sleep(2000);
            log("작업 끝");
        }
    }
}
