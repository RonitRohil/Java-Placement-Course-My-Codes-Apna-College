

public class Reverse_Array {

    public static void reverse(int num[])
    {
        int first = 0;
        int last = num.length - 1;

        while(first < last)
        {
            // swap
            int temp = num[last];
            num[last] = num[first];
            num[first] = temp;

            first++;
            last--;
        }
    }

    public static void main(String[] args) {

        int num[] = {2, 4, 5, 9, 11, 16};

        reverse(num);

        for(int i = 0; i < num.length - 1; i++)
        {
            System.out.print(num[i] + " " );
        }
        
    }
}
