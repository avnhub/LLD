package Lecture6_IntroToThreadsAndProcesses.Concurency2.Callable;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Client {
    public static void main(String[] args) throws Exception {
        List<Integer> list= List.of(7, 3, 4, 1, 9, 8, 2, 6);
        ExecutorService executorService= Executors.newCachedThreadPool();
        Sorter sorter=new Sorter(list);
        //List<Integer> sortedArray=sorter.call();
        Future<List<Integer>> sortedArrayFuture = executorService.submit(sorter);

        List<Integer>sortedArray=sortedArrayFuture.get();
        System.out.println(sortedArray);
    }
}
