import java.util.Arrays;

/*
In this solution, we have created a list full of 0’s with size of the 
max() value of our given array. 
Now, whenever we encounter any positive value in our original array, 
we change the index value of our list to 1. 
So, after we are done, we simply iterate through our modified list, 
the first 0 we encounter, its (index value + 1) should be our answer.
 */

public class Demo{
    static int missingFirstPositiveInteger(int[] arr){
        int max = 0;
        for (int i: arr){
            max = Math.max(i, max);
        }
        System.out.println("Max is:" + max); //Max is:3
        int[] result = new int[max+1];
        for (int i: arr){
            result[i] = 1;
        }
        System.out.println("Result Array is " + Arrays.toString(result)); //Result Array is [1, 1, 0, 1]
        for (int i =0; i<max; i++){
            if (result[i] == 0)
                return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3,1,0};
        int result = missingFirstPositiveInteger(arr);
        System.out.println("Minimum first +ve Integer: " + result); //Minimum first +ve Integer: 2
    }
}
