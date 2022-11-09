package helloWorldPrinter;

public class HelloWorldPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World from other class, printed from : " +
                           Thread.currentThread().getName());
    }
}
