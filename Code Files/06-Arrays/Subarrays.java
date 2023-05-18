public class Subarrays {

    public static void sub_Array(int arr[])
    {
        int ts = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) 
        {
            for (int j = i; j < n; j++) 
            {
                for (int k = i; k <= j; k++) 
                {
                    System.out.print(arr[k] + " ");
                }
                ts++;
                System.out.println();
            }
            System.out.println();
        }   

        System.out.println(ts);
    }

    public static void main(String[] args) {
        int num[] = {2, 4, 6, 8, 10};

        sub_Array(num);
    }
}
