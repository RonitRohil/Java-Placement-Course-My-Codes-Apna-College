import java.util.*;;

public class spiralarray {

    public static void printspiral(int matrix[][])
    {
        int n = matrix.length - 1;
        int m = matrix[0].length - 1;

        int startRow = 0;
        int startCol = 0;
        int endRow = n;
        int endCol = m;
        
        while(startRow <= endRow && startCol <= endCol)
        {
            //top
            for(int i = startCol; i <= endCol; i++)
            {
                System.out.print(matrix[startRow][i] + " ");
            }

            // right
            for(int i = startRow + 1; i <= endRow; i++)
            {
                System.out.print(matrix[i][endCol] + " ");
            }

            //bottom
            for (int i = endCol - 1; i >= startCol ; i--) {
                System.out.print(matrix[endRow][i] + " ");
            }

            //left
            for (int i = endRow - 1; i >= startRow + 1 ; i--) {
                System.out.print(matrix[i][startCol] + " ");
            }

            startRow++;
            startCol++;
            endCol--;
            endRow--;
        }
    }
    
    public static void main(String[] args) {
        int matrix[][] = {{1, 2, 3, 4},
                          {5, 6, 7, 8},
                          {9, 10, 11, 12},
                          {13, 14, 15, 16}};

        printspiral(matrix);
    }
}
