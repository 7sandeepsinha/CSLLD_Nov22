package adderSubtractor_Mutex;

import java.util.concurrent.locks.Lock;

public class Subtractor implements Runnable{

    private Count count;
    private Lock lock;

    public Subtractor(Count count, Lock lock) {
        this.count = count;
        this.lock = lock;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            lock.lock();
            count.value = count.value - 1;
            lock.unlock();
        }
    }
}
