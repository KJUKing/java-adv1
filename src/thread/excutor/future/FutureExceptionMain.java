package thread.excutor.future;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.*;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class FutureExceptionMain {
    public static void main(String[] args) {
        ExecutorService es = Executors.newFixedThreadPool(1);
        log("작업 전달");
        Future<Integer> future = es.submit(new ExCallable());
        sleep(1000);


        try {
            log("future.get() 호출 시도, future.state(): " + future.state());
            Integer result = future.get();
            log("result value = " + result);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } catch (ExecutionException e) {
            log("e = " + e);
            Throwable cause = e.getCause(); //원본예외
            log("cause = " + cause);

        }

    }

    static class ExCallable implements Callable<Integer> {
        @Override
        public Integer call() throws Exception {
            log("Callable 실행, 예외 발생");
            throw new IllegalStateException("ex!");
        }

    }
}
