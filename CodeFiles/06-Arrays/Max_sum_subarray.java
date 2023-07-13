public class Max_sum_subarray {
    
    // Brute force O(n3)
    public static void max_sum_sub_Array(int arr[])
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;

        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++) 
            {
                currSum = 0;
                
                for (int k = i; k <= j; k++) 
                {
                    currSum += arr[k];
                }

                // System.out.println(currSum);
                
                if(maxSum < currSum)
                {
                    maxSum = currSum;
                }
            }
        }   

        System.out.println("Max sum of subarray is = " + maxSum);
    }

    // Prefix sum approach O(n2)

    public static void prefix_sum_sub_array(int arr[])
    {
        int currSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int n = arr.length;
        int prefix[] = new int[n];

        prefix[0] = arr[0];

        // calculate prefix array

        for (int i = 1; i < prefix.length; i++) 
        {
            prefix[i] = prefix[i - 1] + arr[i];
        }

        for (int i = 0; i < n; i++) 
        {
            int start = i;
            
            for (int j = i; j < n; j++) 
            {
                int end = j;

                currSum = start == 0 ? prefix[end] : prefix[end] - prefix[start - 1];

                if(maxSum < currSum)
                {
                    maxSum = currSum;
                }
            }
        }   

        System.out.println("Max sum of subarray is = " + maxSum);
    }

    // kadanes algo O(n)

    public static void kadanes(int arr[])
    {
        int max_sum = Integer.MIN_VALUE;
        int curr_Sum = 0;

        for (int i = 0; i < arr.length; i++) {
            curr_Sum = curr_Sum + arr[i];

            if(curr_Sum < 0)
            {
                curr_Sum = 0;
            }

            max_sum = Math.max(curr_Sum, max_sum);
        }

        System.out.println("Max sum of subarray is = " + max_sum);
    }


    public static void main(String[] args) {
        int arr[] = {1, -2, 6, -1, 3};

        kadanes(arr);
        prefix_sum_sub_array(arr);
        max_sum_sub_Array(arr);
        
    }
}
