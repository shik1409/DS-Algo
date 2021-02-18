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

}
