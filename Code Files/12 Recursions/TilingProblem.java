public class TilingProblem {

    // notiles is also a way 

    public static int TillingWays(int n){
        if(n == 0 || n == 1)
        {
            return 1;
        }

        if(n == 2)
        {
            return 2;
        }

       
        // int VerticalWays =  TillingWays(n-1);
        // int HorizontalWays =  TillingWays(n - 2);
        
        
        int Totalways = TillingWays(n - 1) + TillingWays(n - 2);

        return Totalways;
    }

    public static void main(String[] args) {
        int n = 2;
        System.out.println(TillingWays(n));
    }
}


/*
 * 
 * board = 2 * n
 * tile = 2 * 1
 * tile can be placed horizontally and vertically
 *  
 */