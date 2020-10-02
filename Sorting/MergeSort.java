import java.lang.reflect.Array;
import java.util.Arrays;

public class Demo{

    static void mergeSort(int[] arr, int start, int end){
        if (start < end){
            int mid = (start+end)/2;
            mergeSort(arr, start, mid);
            mergeSort(arr, mid+1, end);
            System.out.println("Calling merge: " +start + mid + end );
            merge(arr, start, mid, end);
        }
    }

    static void merge(int[] arr, int start, int mid,int end){
        int l = mid-start+1;
        int r = end - mid;
        int[] leftArray = new int[l];
        int[] rightArray = new int[r];
        for(int i=0; i<l; i++){
            leftArray[i] = arr[start+i];
        }
        System.out.println("leftArray:" + Arrays.toString(leftArray));
        for(int j=0; j<r; j++){
            rightArray[j] = arr[mid+1+j];
        }
        System.out.println("rightArray:" + Arrays.toString(rightArray));
        int i = 0, j = 0;
        int k = start;
        while (i<l&&j<r)
        {
            if (leftArray[i] <= rightArray[j])
            {
                arr[k] = leftArray[i];
                i++;
            }
            else
            {
                arr[k] = rightArray[j];
                j++;
            }
            k++;
        }
        while (i<l)
        {
            arr[k] = leftArray[i];
            i++;
            k++;
        }

        while (j<r)
        {
            arr[k] = rightArray[j];
            j++;
            k++;
        }

        System.out.println("arr after above merge is: " + Arrays.toString(arr));
    }

    public static void main(String[] args) {
        int[] arr = {5,4,3,2,1};
        mergeSort(arr, 0, arr.length-1);
        System.out.println("Sorted Array:" + Arrays.toString(arr)); //Sorted Array:[1, 2, 3, 4, 5]
    }
}
