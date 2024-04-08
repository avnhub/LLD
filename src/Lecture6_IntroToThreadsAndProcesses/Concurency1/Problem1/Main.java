package Lecture6_IntroToThreadsAndProcesses.Concurency1.Problem1;

public class Main {
    public static void main(String[] args) {
//        System.out.println("hello world done by Thread "+ Thread.currentThread().getName());
//        doSomething();
//    }
//    static void doSomething(){
//        System.out.println("print doSomething Method by Thread"+ Thread.currentThread().getName());
//    }
        System.out.println("Hello Avneesh "+ Thread.currentThread().getName());
        HellowWorldPrinter obj1 = new HellowWorldPrinter();
        Thread t1 = new Thread(obj1);
        t1.start();
        System.out.println("Hello Navya "+ Thread.currentThread().getName());

        // Note: Thread 0 and Thread main are running in parallel so any order it can come

    }
}
