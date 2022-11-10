package adderSubstractor_syncBlock;

import java.util.concurrent.locks.Lock;

public class Adder implements Runnable{

    private Count count;


    public Adder(Count count) {
        this.count = count;
    }

    @Override
    public void run() {
        for(int i=0;i<10000;i++) {
            synchronized (count) {
                count.value = count.value + 1;
            }
        }
    }
}
