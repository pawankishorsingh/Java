public class Demo {
    static boolean binarySearchRecursive(int[] arr, int data, int start, int end){
        System.out.println("Searching data="+data+" between indexes " + start+ " and " + end);
        if (start>end){
            return false;
        }
        int mid;
        if (start==end){
            mid = start;
        } else {
            mid = (start+end) / 2;
        }
//        System.out.println("mid="+mid);
        if (arr[mid] == data){
            return true;
        } else if (data < arr[mid]){
            return binarySearchRecursive(arr,data,start,mid-1);
        } else {
            return binarySearchRecursive(arr,data,mid+1, end);
        }
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        System.out.println("Found? = "+binarySearchRecursive(arr,2,0,4));//Found? = true
        System.out.println("Found? = "+binarySearchRecursive(arr,-2,0,4));//Found? = false
    }
}
