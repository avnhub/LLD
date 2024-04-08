package Lecture6_IntroToThreadsAndProcesses.Concurency2.Callable;

import OOPs4.Inheritance.A;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Sorter implements Callable<List<Integer>> {
    List<Integer> arrayToSort;
    Sorter(List<Integer> arrayToSort){
        this.arrayToSort=arrayToSort;

    }
    public List<Integer> call() throws Exception{
        //base case
        if(arrayToSort.size()<=1){
            return arrayToSort;
        }
        //divide array into 2 parts
        int mid=arrayToSort.size()/2;
        List<Integer> leftArray=new ArrayList<>();
        for(int i=0;i<mid;i++){
            leftArray.add(arrayToSort.get(i));
        }

        List<Integer> rightArray=new ArrayList<>();
        for(int i=mid;i<arrayToSort.size();i++){
            rightArray.add(arrayToSort.get(i));
        }
        //Sort Each Half
        Sorter leftSorter=new Sorter(leftArray);
        Sorter rightSorter=new Sorter(rightArray);

        /*List<Integer> leftSortedArray=leftSorter.call();//AFTER SORTING THE ARRAY CALL CALL() FUNCTION
        List<Integer> rightSortedArray=rightSorter.call();*/
        ExecutorService executorService= Executors.newCachedThreadPool();
        Future<List<Integer>> leftSortedArrayFuture=executorService.submit(leftSorter);//AFTER SORTING THE ARRAY CALL CALL() FUNCTION
        Future<List<Integer>> rightSortedArrayFuture=executorService.submit(rightSorter);

        List<Integer> leftSortedArray=leftSortedArrayFuture.get();//AFTER SORTING THE ARRAY CALL CALL() FUNCTION
        List<Integer> rightSortedArray=rightSortedArrayFuture.get();
        //Merger Each Half
        List<Integer> sortedArray =new ArrayList<>();
        int leftPtr=0;
        int rightPtr=0;

        while(leftPtr<leftSortedArray.size() && rightPtr<rightSortedArray.size()) {
            if (leftSortedArray.get(leftPtr) < rightSortedArray.get(rightPtr)) {
                sortedArray.add(leftSortedArray.get(leftPtr));
                leftPtr++;
            } else {
                sortedArray.add(rightSortedArray.get(rightPtr));
                rightPtr++;
            }
        }
        while (leftPtr<leftSortedArray.size()){
           sortedArray.add(leftSortedArray.get(leftPtr));
        }
        while (rightPtr<rightSortedArray.size()){
            sortedArray.add(rightSortedArray.get(rightPtr));
        }
        //Return Result
        return sortedArray;
    }
}
