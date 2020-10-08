import java.util.Arrays;

public class Demo {
    static void printMatrixInSpitalMannerIteratively(int[][] matrix){
        int rowStart = 0;
        int rowEnd = matrix.length-1;
        int colStart = 0;
        int colEnd = matrix[0].length-1;
        while (rowStart < rowEnd && colStart<colEnd) {
            for (int i = colStart; i <= colEnd; i++) {
                System.out.print(matrix[rowStart][i] + " ");
            }
            rowStart++;
            for (int i = rowStart; i <= rowEnd; i++) {
                System.out.print(matrix[i][colEnd] + " ");
            }
            colEnd--;
            for (int i = colEnd; i >= colStart; i--) {
                System.out.print(matrix[rowEnd][i] + " ");
            }
            rowEnd--;
            for (int i = rowEnd; i >= rowStart; i--) {
                System.out.print(matrix[i][colStart] + " ");
            }
            colStart++;
        }
    }
    static void printMatrixInSpitalMannerRecursively(int[][] matrix, int rowStart, int colStart , int rowEnd, int colEnd){
        if (rowStart >= rowEnd || colStart >= colEnd){
            return;
        }
        for (int i=colStart; i<=colEnd; i++){
            System.out.print(matrix[rowStart][i] + " ");
        }
        rowStart++;
        for (int i=rowStart; i<=rowEnd; i++){
            System.out.print(matrix[i][colEnd] + " ");
        }
        colEnd--;
        for(int i=colEnd; i>=colStart; i--){
            System.out.print(matrix[rowEnd][i] + " " );
        }
        rowEnd--;
        for (int i=rowEnd; i>=rowStart; i--){
            System.out.print(matrix[i][colStart] + " ");
        }
        colStart++;
        printMatrixInSpitalMannerRecursively(matrix,rowStart,colStart, rowEnd, colEnd );
    }
    public static void main(String[] args) {
        int[][] matrix = {
                {1,    2,   3,   4},
                {5,    6,   7,   8},
                {9,   10,  11,  12},
                {13,  14,  15,  16}
        };
        printMatrixInSpitalMannerIteratively(matrix); //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 
        System.out.println();
        printMatrixInSpitalMannerRecursively(matrix, 0, 0, 3, 3); //1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10 

    }
}
