package Lecture6_IntroToThreadsAndProcesses.Concurency1.Problem2;

public class PrintNumber implements Runnable{
    int num;
    PrintNumber(int num){
        this.num=num;
    }

    @Override
    public void run() {
        System.out.println("Printed num = "+this.num+" by thread "+Thread.currentThread().getName());
    }
}
