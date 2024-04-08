package Lecture6_IntroToThreadsAndProcesses.Concurency1.Problem2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String [] args){
        //Only care about task in run() not how many threads to create
        ExecutorService executorService= Executors.newFixedThreadPool(10);
        for(int i=1;i<=100;i++){
            PrintNumber pnObj=new PrintNumber(i);
            /*Thread t=new Thread(pnObj);
            t.start();*/ //this is not required if using executor service we are giving our task to executor service,
            //Note Strt=create new thread + run()
            executorService.execute(pnObj);
        }
        executorService.shutdown();
    }
}
