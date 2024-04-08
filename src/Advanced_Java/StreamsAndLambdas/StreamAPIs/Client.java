package Advanced_Java.StreamsAndLambdas.StreamAPIs;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Client {
    public static void main(String[] args) {
        List<Integer> list=List.of(2,3,4,5,7,8);
        Stream<Integer> stream1=list.stream();
        Stream<Integer> stream2=list.stream();

        /*Filter Based on the condition//Each element if %2 == 0 then keep it in ans else don't
        long count=stream1.filter( (element) -> element % 2==0).count();
        */

        /*
        NOTE----- If a terminal method is used it closes the stream
        you have to create a new tream to operate upon then-----NOTE
         */
        long count=stream1.filter( (element) -> element % 2==0).count();
        /*
        Collect all values of stream that matches filter in
        List<Integer> ans=stream2.filter((element)-> element %2==0).collect(Collectors.toList());
         */
        List<Integer> ans=stream2.filter((element)-> element %2==0).collect(Collectors.toList());
        /*  2 types of Stream Operations
        *
        * Every Intermeditate method is followed by a terminal method if any
        * stream.filter().count()
        *
        * Intermeditate Operations
        * (a.)Filter()
        * (b.) sort()
        * (c.) map() ==> This means for every operation it will do this operation
        *
        * Terminal Operations
        * (a.) Count()  = Count return a long type
        * (b.) collect(Collectors.toList())
        * (c.) findFirst(); return first value of stream of type Optional== if i have value then only value is set to ans otherwise blank
        * */

        /*
        Example
        List<Integer> list=stream.filter((element)->element %2==0)).sorted.map((element)->element*10)
        Optional<Integer> ans=stream.filter((element)->element %2==0)).sorted.map((element)->element*10).findFirst();
        if(ans.isPresent()){
        sout(ans)l
        }
         */
        System.out.println(count);
        System.out.println(ans);

        //MY Actual List is not affected//
        System.out.println(list);
    }
}
