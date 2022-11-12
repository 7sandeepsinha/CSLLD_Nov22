package semphore_producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Consumer(Queue<Shirt> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
        try {
            while (true) {
                semaConsumer.acquire();
                System.out.println("Current store size -  " + store.size() + ",removing from store - " + name);
                store.remove();
                semaProducer.release();
            }
        }catch (InterruptedException e){

        }
    }
}
