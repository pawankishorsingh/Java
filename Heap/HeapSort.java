import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Demo {
    static PriorityQueue<Integer> createPriorityQueue(int[] arr, int order){
        PriorityQueue<Integer> priorityQueue;
        if (order == 0){
            priorityQueue = new PriorityQueue<>();
        } else {
            priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        }
        for (int i=0; i<arr.length; i++){
            priorityQueue.add(arr[i]);
        }
        return priorityQueue;
    }
    static void printSortedArray(PriorityQueue<Integer> priorityQueue){
        System.out.print("\nSorted Items: ");
        while(!priorityQueue.isEmpty()){
            System.out.print(priorityQueue.poll() + " ");
        }
    }
    static void performHeapSortAndPrint(int[] arr, int order){
        PriorityQueue<Integer> priorityQueue = createPriorityQueue(arr, order);
        printSortedArray(priorityQueue);
    }
    public static void main(String[] args) {
        int[] arr = {5,3,4,2,1};
        System.out.print("Input Array: " + Arrays.toString(arr)); //Input Array: [5, 3, 4, 2, 1]
        performHeapSortAndPrint(arr, 0); //Sorted Items: 1 2 3 4 5
        performHeapSortAndPrint(arr, 1); //Sorted Items: 5 4 3 2 1
    }
}
