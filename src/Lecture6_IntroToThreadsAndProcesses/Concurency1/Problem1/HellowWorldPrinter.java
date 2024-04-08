package Lecture6_IntroToThreadsAndProcesses.Concurency1.Problem1;

public class HellowWorldPrinter implements Runnable{

    @Override
    public void run() {
        System.out.println("Hello World Print by Thread "+ Thread.currentThread().getName());
    }
}
