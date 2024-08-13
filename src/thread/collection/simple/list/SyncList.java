package thread.collection.simple.list;

import java.util.Arrays;

import static util.ThreadUtils.sleep;

public class SyncList implements SimpleList {

    private static final int DEFULT_CAPACITY = 5;

    private Object[] elementData;
    private int size =0;

    public SyncList() {
        elementData = new Object[DEFULT_CAPACITY];
    }

    @Override
    public synchronized int size() {
        return size;
    }

    @Override
    public synchronized void add(Object o) {
        elementData[size] = o;
        sleep(100); //멀티스레드 문제를 쉽게 확인하는 코드
        size++;
    }

    @Override
    public synchronized Object get(int index) {
        return elementData[index];
    }

    @Override
    public synchronized String toString() {
        return Arrays.toString(Arrays.copyOf(elementData, size))
                + " size= " + size + ", capacity= " + elementData.length;
    }
}
