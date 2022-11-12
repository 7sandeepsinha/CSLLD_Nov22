package semphore_producerConsumer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;
    private Semaphore semaProducer;
    private Semaphore semaConsumer;

    public Producer(Queue<Shirt> store, int maxSize, String name, Semaphore semaProducer, Semaphore semaConsumer) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
        this.semaProducer = semaProducer;
        this.semaConsumer = semaConsumer;
    }

    @Override
    public void run() {
            try {
                while(true) {
                    semaProducer.acquire(); // 5 -> 4 -> 3 -> 2 -> 1
                    System.out.println("Current store size -  " + store.size() + ",adding to store - " + name);
                    store.add(new Shirt());
                    semaConsumer.release(); // +1
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
    }
}
