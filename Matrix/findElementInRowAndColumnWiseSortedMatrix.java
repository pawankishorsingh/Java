public class Demo {
    public static boolean findElementInRowAndColumnWiseSortedMatrix(int[][] matrix, int num, int row, int col){
        int index_x = 0;
        int index_y = col-1;
        while(index_x>=0 && index_x < row && index_y>=0 && index_y<col){
            if (matrix[index_x][index_y] == num){
//                System.out.println(num+ " is found at index "+ index_x + "," + index_y);
                return true;
            }
            if (num < matrix[index_x][index_y])
                index_y--;
            else
                index_x++;
        }
        return false;
    }
    public static void main(String[] args){
        int[][] matrix = {
                    {2,7,15},
                    {4,9,19},
                    {6,10,24}
        };
        System.out.println("-100 Found?:" + findElementInRowAndColumnWiseSortedMatrix(matrix,-100, 3,3));
        System.out.println("2 Found?:" + findElementInRowAndColumnWiseSortedMatrix(matrix,2, 3,3));
        System.out.println("10 Found?:" + findElementInRowAndColumnWiseSortedMatrix(matrix,10, 3,3));
        System.out.println("24 Found?:" + findElementInRowAndColumnWiseSortedMatrix(matrix,24, 3,3));
        System.out.println("420 Found?:" + findElementInRowAndColumnWiseSortedMatrix(matrix,420, 3,3));
    }
}
