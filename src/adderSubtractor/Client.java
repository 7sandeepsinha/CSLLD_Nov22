package adderSubtractor;

public class Client {
    public static void main(String[] args) throws InterruptedException {
        Count c = new Count();
        Adder a = new Adder(c);
        Subtractor s = new Subtractor(c);

        Thread t1 = new Thread(a);
        Thread t2 = new Thread(s);

        t1.start();
        t2.start();

        t1.join();
        t2.join();

        System.out.println(c.value);

    }
}
