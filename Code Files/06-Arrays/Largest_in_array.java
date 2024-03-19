public class Largest_in_array {

    public static int getlargest(int num[])
    {
        int largest = Integer.MIN_VALUE; // -infinity

        for (int i = 0; i < num.length; i++) 
        {
            if(num[i] > largest)
            {
                largest = num[i];
            }
        }

        return largest;
    }

    public static int getsmallest(int num[])
    {
        int smallest = Integer.MAX_VALUE; // +infinity

        for (int i = 0; i < num.length; i++) 
        {
            if(num[i] < smallest)
            {
                smallest = num[i];
            }
        }

        return smallest;
    }

    public static void main(String[] args) 
    {
        int numbers[] = {1, 2, 6, 3, 5};
        System.out.println(getlargest(numbers));
        System.out.println(getsmallest(numbers));
    }
}
