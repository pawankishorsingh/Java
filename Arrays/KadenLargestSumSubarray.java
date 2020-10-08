//Kaden's Algorithm: largest Sum Subarray
//Ref: https://www.youtube.com/watch?v=fJAP2tj16mE&list=PLKKfKV1b9e8rtK9qwJWmjoCYeV5tNC52h

public class Demo {
    static int largestSumSubarrayUsing3Loops(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int i=0; i<=arr.length-1; i++){
            for (int j=i; j<=arr.length-1; j++){
                int sum = 0;
                for (int k=i; k<=j; k++){
                    sum += arr[k];
                }
                max = Math.max(max,sum);
            }
        }
        return max;
    }
    static int largestSumSubarrayUsingAnExtraLeftSumArray(int[] arr){
        int[] leftSum = new int[arr.length];
        int max = Integer.MIN_VALUE;
        for (int i=0; i<=arr.length-1; i++){
            if (i==0)
                leftSum[i] = arr[i];
            else {
                leftSum[i] = leftSum[i-1] + arr[i];
            }
        }
        for (int i=0; i<=arr.length-1; i++){
            int sum =0;
            for (int j=i; j<arr.length-1; j++){
                sum = leftSum[j] - leftSum[i] + arr[i];
            }
            max = Math.max(max,sum);
        }
        return max;
    }
    static int largestSumSubarrayUsingKadanesAlgorithm(int[] arr){
        int pastSubArraySum = 0;
        int max = Integer.MIN_VALUE;
        for (int i=0; i<= arr.length-1; i++){
            pastSubArraySum += arr[i];
            if (pastSubArraySum <0){ //Lets discard old window
                pastSubArraySum = 0;
            } else {
                max = Math.max(max,pastSubArraySum);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr = {-3, 2, 4, -1, 2, 3, -2};
        System.out.println(largestSumSubarrayUsing3Loops(arr)); //10
        System.out.println(largestSumSubarrayUsingAnExtraLeftSumArray(arr)); //10
        System.out.println(largestSumSubarrayUsingKadanesAlgorithm(arr)); //10
    }
}
