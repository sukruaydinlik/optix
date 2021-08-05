package controller;

public class Foo {
    public static void main(String[] args)
            throws InterruptedException {
        Bar t = new Bar();
        t.run();
        System.out.println("Foo");
    }
}
class Bar implements Runnable {
    public void start() {
    }

    @Override
    public void run() {
        System.out.println("Bar");
     
    }
}
