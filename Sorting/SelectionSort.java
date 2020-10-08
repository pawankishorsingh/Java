// Tip: Selection sort is slightly better than Bubble sort
// We traverse full list and take a note of minIndex. At the end we just swap that.

import java.util.Arrays;

public class Demo {
    static void selectionSort(int[] arr){
        for (int i=0; i<= arr.length-1; i++){
            int minIndex = i;
            for (int j=i; j<=arr.length-1; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            //swap at last
            // System.out.println("Swapping " + arr[i] + " & " + arr[minIndex]);
            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }
    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        selectionSort(arr);
        System.out.println(Arrays.toString(arr)); //[1, 2, 3, 4, 5]
    }
}
