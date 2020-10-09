//Ref: TECH DOSE: https://www.youtube.com/watch?v=sEQk8xgjx64
import java.util.Arrays;

public class Demo {
    static void swap(int[] arr, int pos1, int pos2){
        int temp = arr[pos1];
        arr[pos1] = arr[pos2];
        arr[pos2] = temp;
    }
    static void dutchNationalFlag(int[] arr){
        int l=0;
        int m=0;
        int h=arr.length-1;
        while (m <= h){
            if (arr[m] ==0){
                swap(arr, l, m);
                l++;
                m++;
            }
            else if (arr[m] ==1){
                m++;
            }
            else if (arr[m]==2){
                swap(arr, m, h);
                h--;
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {0,1,2,0,1,2};
        dutchNationalFlag(arr);
        System.out.println(Arrays.toString(arr)); //[0, 0, 1, 1, 2, 2]
    }
}
