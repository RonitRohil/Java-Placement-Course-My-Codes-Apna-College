public class NqueenprintONesolution {
    
    public static boolean isSafe(char board[][], int row, int col)
    {
        // vertical UP
        for(int i = row - 1; i >= 0; i--)
        {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // diagonal left UP
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--)
        {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // diagonal right UP
        for(int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++)
        {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true;
    }
    
    public static boolean N_Queens(char board[][], int row)
    {
        //base
        if (row == board.length){
            count++;
            // printboard(board);
            return true;
        }

        // Column Loop
        for (int j = 0; j < board.length; j++) {

            if(isSafe(board, row, j))
            {
                board[row][j] = 'Q';
                if(N_Queens(board, row + 1))
                {
                    return true;
                }
                board[row][j] = 'x';
            }
           
        }

        return false;
    }

    public static void printboard(char board[][])
    {
        System.out.println();
        System.out.println("------ Chess Board ------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                System.out.print(board[i][j] + " ");
            }

            System.out.println();
        }

        System.out.println("-------------------------");
        System.out.println();
    }

    // FOr counting number of ways
    static int count = 0;

    public static void main(String[] args) {
        int n = 5;
        char board[][] = new char[n][n];
        
        // initialize

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'x';
            }
        }

        if(N_Queens(board, 0))
        {
            System.out.println("Solution is possible");
            printboard(board);
        }

        else
        {
            System.out.println("Solution is not possible");
        }

        // System.out.println("Number of ways = " + count);
    }
}
