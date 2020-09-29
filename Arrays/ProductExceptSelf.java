import java.util.*;

public class Demo {
    static int[] productExceptSelf(int[] arr){
        int[] leftProduct = new int[arr.length];
        int[] rightProduct = new int[arr.length];
        int[] result = new int[arr.length];
        
        //Left product array
        for(int i=0; i< arr.length; i++){
            if (i==0){
                leftProduct[i] =1;
            } else {
                leftProduct[i] = leftProduct[i-1] * arr[i-1];
            }
        }
        System.out.println("Left:" + Arrays.toString(leftProduct)); //Left:[1, 1, 2, 6, 24]
        
        //Right product array
        for(int j=arr.length-1; j>=0; j--){
            if (j==arr.length-1){
                rightProduct[j] =1;
            } else {
                rightProduct[j] = rightProduct[j+1] * arr[j+1];
            }
        }
        System.out.println("Right:" + Arrays.toString(rightProduct)); //Right:[120, 60, 20, 5, 1]
        
        // Finally create result array using above tow left & right arrays
        for(int k=0; k< arr.length; k++){
            result[k] = leftProduct[k] * rightProduct[k];
        }
        return result;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int[] result = productExceptSelf(arr);
        System.out.println("Resultant:" + Arrays.toString(result)); //Resultant:[120, 60, 40, 30, 24]
    }
}
