//Ref:  https://www.youtube.com/watch?v=VmogG01IjYc&list=PLI1t_8YX-Apv-UiRlnZwqqrRT8D1RhriX&index=11

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class Demo {

    static void addNumber(int number, PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if (lowers.isEmpty() || number < lowers.peek()){
            lowers.add(number);
        } else {
            highers.add(number);
        }
    }
    static void rebalance(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size()<highers.size()?lowers:highers;
        if (biggerHeap.size()-smallerHeap.size()>=2){
            smallerHeap.add(biggerHeap.poll());
        }
    }
   static double getMedian(PriorityQueue<Integer> lowers, PriorityQueue<Integer> highers){
        if (lowers.size() ==highers.size()){
            return ((double)lowers.peek()+highers.peek())/2;
        }
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
        return biggerHeap.peek();
   }


    public static double[] getMedians(int[] arr){
        //Max Heap
        PriorityQueue<Integer> lowers = new PriorityQueue<>(Collections.reverseOrder());
        //Min Heap
        PriorityQueue<Integer> highers = new PriorityQueue<>();
        double[] medians = new double[arr.length];
        for (int i=0; i<arr.length; i++){
            int number = arr[i];
            addNumber(number, lowers, highers);
            rebalance(lowers, highers);
            medians[i] = getMedian(lowers, highers);
        }
        return medians;
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8,9,10};
        System.out.println(Arrays.toString(getMedians(arr))); //[1.0, 1.5, 2.0, 2.5, 3.0, 3.5, 4.0, 4.5, 5.0, 5.5]
    }
}
