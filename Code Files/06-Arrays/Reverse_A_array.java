public class Reverse_A_array {

    public static void reverse(int arr[])
    {
        int first = 0;
        int last = arr.length - 1;

        while (first < last) 
        {
            int temp = arr[last];
            arr[last] = arr[first];
            arr[first] = temp;

            first++;
            last--;
        }
    }
    
    public static void main(String[] args) 
    {

        int num[] = {2, 4, 6 , 8, 10};
        reverse(num);

        for (int i = 0; i < num.length; i++) 
        {
            System.out.println(num[i]);
        }
        
    }
}
