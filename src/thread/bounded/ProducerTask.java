package thread.bounded;

import util.MyLogger;

import static util.MyLogger.*;

public class ProducerTask implements Runnable {

    private BoundedQueue queue;
    private String request;

    public ProducerTask(BoundedQueue queue, String request) {
        this.queue = queue;
        this.request = request;
    }

    @Override
    public void run() {
        log("[생산시도] " + request + " -> " + queue);
        queue.put(request);
        log("[생산완료] " + request + " -> " + queue);
    }
}
