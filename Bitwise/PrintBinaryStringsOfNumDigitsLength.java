public class Demo{
    static void printBinaryStringsOfNumDigitsLengthIteratively(int numDigits){
        int n = 1<<numDigits;
        for (int i=0; i<n; i++){
            for (int j=numDigits; j>0; j--){
                if ((i>>j-1 & 1) == 1){
                    System.out.print("1");
                } else {
                    System.out.print("0");
                }
            }
            System.out.print(" ");
        }
    }
    static void printTheArray(int[] arr, int numDigits){
        for (int i=0; i<numDigits; i++){
            System.out.print(arr[i]);
        }
        System.out.print(" ");
    }
    static void printBinaryStringsOfNumDigitsLengthRecursively(int numDigits, int[] arr, int i){
        if (numDigits == i){
            printTheArray(arr, numDigits);
            return;
        }
        arr[i] = 0;
        printBinaryStringsOfNumDigitsLengthRecursively(numDigits, arr, i+1);
        arr[i] = 1;
        printBinaryStringsOfNumDigitsLengthRecursively(numDigits, arr, i+1);
    }
    public static void main(String[] args) {
        int numDigits = 3;
        int[] arr = new int[numDigits];
        printBinaryStringsOfNumDigitsLengthIteratively(numDigits); //000 001 010 011 100 101 110 111
        System.out.println();
        printBinaryStringsOfNumDigitsLengthRecursively(numDigits, arr, 0); //000 001 010 011 100 101 110 111
    }
}
