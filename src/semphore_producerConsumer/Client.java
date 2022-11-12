package semphore_producerConsumer;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.Semaphore;

public class Client {
    public static void main(String[] args) {
        Queue<Shirt> store = new ConcurrentLinkedDeque<>();
        int maxSize = 5;

        Semaphore semaProducer = new Semaphore(maxSize);
        Semaphore semaConsumer = new Semaphore(0);

        Producer p1 = new Producer(store, maxSize, "P1", semaProducer, semaConsumer);
        Producer p2 = new Producer(store, maxSize, "P2", semaProducer, semaConsumer);
        Producer p3 = new Producer(store, maxSize, "P3",semaProducer, semaConsumer );

        Consumer c1 = new Consumer(store, maxSize, "C1", semaProducer, semaConsumer);
        Consumer c2 = new Consumer(store, maxSize, "C2", semaProducer, semaConsumer);
        Consumer c3 = new Consumer(store, maxSize, "C3", semaProducer, semaConsumer);
        Consumer c4 = new Consumer(store, maxSize, "C4", semaProducer, semaConsumer);
        Consumer c5 = new Consumer(store, maxSize, "C5", semaProducer, semaConsumer);

        Thread tp1 = new Thread(p1);
        tp1.start();

        Thread tp2 = new Thread(p2);
        tp2.start();

        Thread tp3 = new Thread(p3);
        tp3.start();

        Thread tc1 = new Thread(c1);
        tc1.start();

        Thread tc2 = new Thread(c2);
        tc2.start();

        Thread tc3 = new Thread(c3);
        tc3.start();

        Thread tc4 = new Thread(c4);
        tc4.start();

        Thread tc5 = new Thread(c5);
        tc5.start();

    }
}
