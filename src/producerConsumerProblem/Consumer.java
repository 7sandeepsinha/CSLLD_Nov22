package producerConsumerProblem;

import java.util.Queue;

public class Consumer implements Runnable{
    private Queue<Shirt> store;
    private int maxSize;
    private String name;

    public Consumer(Queue<Shirt> store, int maxSize, String name) {
        this.store = store;
        this.maxSize = maxSize;
        this.name = name;
    }

    @Override
    public void run() {
        while(true) {
            if (store.size() > 0) {
                System.out.println("Current store size -  " + store.size() + ",removing from store - " + name);
                store.remove();
            }
        }
    }
}
