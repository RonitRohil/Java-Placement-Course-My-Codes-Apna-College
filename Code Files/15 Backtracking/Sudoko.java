public class Sudoko {

    public static boolean isSafe(int sudoko[][], int row, int col, int digit)
    {
        //column

        for (int i = 0; i <= 8; i++) {
            if (sudoko[i][col] == digit) {
                return false;
            }
        }

        //row

        for (int j = 0; j <= 8; j++) {
            if (sudoko[row][j] == digit) {
                return false;
            }
        }

        //grid

        int start_row = (row/3) * 3;
        int start_col = (col/3) * 3;

        for(int i = start_row; i < start_row + 3; i++)
        {
            for(int j = start_col; j < start_col + 3; j++)
            {
                if (sudoko[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }
    
    public static boolean SolveSudoko(int sudoko[][], int row, int col)
    {
        // base case
        if(row == 9)
        {
            return true;
        }

        //recursion

        int nextRow = row; 
        int nextCol = col+1;

        if (col + 1 == 9) {
            nextRow = row + 1;
            nextCol = 0;
        }

        if(sudoko[row][col] != 0)
        {
            return SolveSudoko(sudoko, nextRow, nextCol);
        }

        for (int digit = 1; digit <= 9; digit++) {
            if (isSafe(sudoko, row, col, digit)) {
                sudoko[row][col] = digit;
                if(SolveSudoko(sudoko, nextRow, nextCol))
                {
                    // solution exist
                    return true;
                }

                sudoko[row][col] = 0;
            }
        }

        return false;

    }

    public static void printSudoko(int sudoko[][])
    {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                System.out.print(sudoko[i][j] + " ");   
            }

            System.out.println();
        }
    }

    public static void main(String[] args) {
        int sudoko[][] = {{0, 0, 8, 0, 0, 0, 0, 0, 0},
                          {4, 9, 0, 1, 5, 7, 0, 0, 2},
                          {0, 0, 3, 0, 0, 4, 1, 9, 0},
                          {1, 8, 5, 0, 6, 0, 0, 2, 0},
                          {0, 0, 0, 0, 2, 0, 0, 6, 0},
                          {9, 6, 0, 4, 0, 5, 3, 0, 0},                         
                          {0, 3, 0, 0, 7, 2, 0, 0, 4},
                          {0, 4, 9, 0, 3, 0, 0, 5, 7},
                          {8, 2, 7, 0, 0, 9, 0, 1, 3}};

        if (SolveSudoko(sudoko, 0, 0)) {
            System.out.println("Solution Exist");
            printSudoko(sudoko);
        }

        else
        {
            System.out.println("Solution does not Exist");
        }
        

    }
}


/*
 * 
 * write function to complete a sukoda
 * 
 * if it is solvable print one solution 
 * 
 * 
 */