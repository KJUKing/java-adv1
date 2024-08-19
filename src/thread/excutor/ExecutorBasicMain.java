package thread.excutor;

import util.MyLogger;
import util.ThreadUtils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import static thread.excutor.ExecutorUtils.*;
import static util.MyLogger.*;
public class ExecutorBasicMain {
    public static void main(String[] args) {
        ExecutorService es = new ThreadPoolExecutor(2, 2, 0,
                TimeUnit.MILLISECONDS, new LinkedBlockingQueue<Runnable>());
        log("== 초기 상태 ==");
        printState(es);
        es.execute(new RunnableTask("TaskA"));
        es.execute(new RunnableTask("TaskB"));
        es.execute(new RunnableTask("TaskC"));
        es.execute(new RunnableTask("TaskD"));
        log("==작성 수행 중 ==");
        printState(es);

        ThreadUtils.sleep(3000);
        log("== 작업 수행 완료 ==");
        printState(es);

        es.close();
        log("== shutdown 완료 ==");
        printState(es);

    }
}

