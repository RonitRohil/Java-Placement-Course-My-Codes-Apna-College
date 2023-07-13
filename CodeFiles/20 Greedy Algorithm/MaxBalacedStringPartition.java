public class MaxBalacedStringPartition {

    static int BalancedPartition(String str, int n)
    {
        if(n == 0)
        {
            return 0;
        }

        int r = 0, l = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == 'R') {
                r++;
            }

            else if(str.charAt(i) == 'L')
            {
                l++;
            }

            if(r == l)
            {
                ans++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        String str = "LRRRRLLRLLRL";
        int n = str.length();
        System.out.print(BalancedPartition(str, n) + "\n");
    }
}


/*
 * 
 * 
 * Question 1 :
 * Maximum Balanced String Partitions
 * We have balanced string str of size N with an equal number of L and R,
 * the task is to find a maximum number X, such that a given string can 
 * be partitioned into X balanced substring. A string is called to be 
 * balanced if the number of ‘L’s in the string equals the number of 
 * ‘R’s.
 * 
 * Input : “LRRRRLLRLLRL”
 * Output : 3
 * 
 * 
 * 
 */