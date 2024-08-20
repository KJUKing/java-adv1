package thread.excutor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.Random;
import java.util.concurrent.*;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class CallableMainV1 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService es = Executors.newFixedThreadPool(1);
        Future<Integer> future = es.submit(new MyCallable());
        Integer result = future.get();
        log("result: " + result);
        es.close();
    }

    static class MyCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 시작");
            sleep(2000);
            int value = new Random().nextInt(10);
            log("Callable 완료");
            return value;
        }
    }
}
