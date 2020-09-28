import java.util.*;

public class Demo {
    static void printKWayMergedArray(List<Integer> ... list){
        List<Integer> listMerged = new ArrayList<>();
        for (List<Integer> l: list)
            listMerged.addAll(l);
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        for (Integer i: listMerged){
            heap.add(i);
        }
        while (!heap.isEmpty()){
            System.out.print(heap.poll() + " "); //0 1 2 3 4 5 6 7 8 
        }
    }
    public static void main(String[] args) throws InterruptedException {
        int k = 3;
        List<Integer> list1 = new ArrayList<>(Arrays.asList(1,3,5));
        List<Integer> list2 = new ArrayList<>(Arrays.asList(2,4,6));
        List<Integer> list3 = new ArrayList<>(Arrays.asList(0,7,8));
        printKWayMergedArray(list1, list2, list3);
    }
}
