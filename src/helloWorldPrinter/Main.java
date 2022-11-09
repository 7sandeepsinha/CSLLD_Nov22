package helloWorldPrinter;

import helloWorldPrinter.HelloWorldPrinter;

public class Main {
    public static void doSomething(){
        System.out.println("Hello World! Do Something, printed from : "
                           + Thread.currentThread().getName());
    }
    public static void main(String[] args) {
        System.out.println("Hello world! printed from : " +
                           Thread.currentThread().getName());
        HelloWorldPrinter hw = new HelloWorldPrinter();
        Thread t1 = new Thread(hw);
        t1.start(); // -> run() 
        doSomething();
        doSomething();
    }
}