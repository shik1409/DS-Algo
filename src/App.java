import com.algorithms.recursion.Factorial;
import com.algorithms.recursion.Fibonacci;
import com.algorithms.recursion.RecursionTypes;
import com.algorithms.sorting.BubbleSort;

public class App {
    public static void main(String[] args) throws Exception {
       // recursion();
        sortingTest();
    }

    public static void sortingTest(){
        int[] testArr = {2,56,78,100,3,2,78,45,3,5,3};
        printArr(BubbleSort.performSort(testArr));


    }

    private static void printArr(int[] inputArray){
        for(int i: inputArray){
            System.out.print(i+" ");
        }
    }


    public static void recursion(){
        System.out.println("Starting Head");
        RecursionTypes.head(4);
        System.out.println("Starting Tail");
        RecursionTypes.tail(4);

        Factorial fact = new Factorial();
        System.out.println(fact.head(12));
        System.out.println(fact.tail(12,1));

        Fibonacci fib = new Fibonacci();
        System.out.println(fib.head(10));
        System.out.println(fib.tail(10,1));
    }


}
