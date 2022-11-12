package producerConsumerProblem;

import java.util.Queue;

public class Producer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;

    public Producer(Queue<Shirt> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            if (store.size() < maxSize) {
                System.out.println("Current store size -  " + store.size() + ",adding to store - " + name);
                store.add(new Shirt());
            }
        }
    }
}
