public class GridWays {

    public static int gridWays(int i, int j, int n, int m)
    {
        //base case
        if(i == n - 1 && j == m -1) // last cell condition
        {
            return 1;
        }

        else if(i == n || j == n) // boundary cross condition
        {
            return 0;
        }

        int w1 = gridWays(i+1, j, n, m);
        int w2 = gridWays(i, j+1, n, m);

        return w1 + w2;
    }

    public static void main(String[] args) {
        int n = 3;
        int m = 3;

        System.out.println(gridWays(0, 0, n, m));
    }
}

/*
 * 
 * Find number of ways to reach from (0,0) to (n-1, m-1)
 * in a m*n grid
 * 
 * Allowed moves - right and down
 * 
 * time comp = greater than O(n^2)
 *          = O(2^n+m)
 *          very high time
 * 
 * 
 * trick => permutation
 * 
 * consider D -> n-1 ,R -> m - 1
 * permutation find 
 * 
 * totat char = n - 1 + m - 1
 * 
 * total ways = (n - 1 + m - 1)!    => Linear TIme O(n + m)
 *              ________________
 *              (n-1)! * (m - 1)!     
 * 
 * example n = 3 m = 3
 * 
 * ways = 4!/2! * 2! = 6       
 *  
 * time = linear time
 * 
 */
