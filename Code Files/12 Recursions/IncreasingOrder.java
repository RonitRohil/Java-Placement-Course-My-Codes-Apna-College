public class IncreasingOrder {


    public static void Inc_Num(int n)
    {
        if (n == 1) {
            System.out.print(n + " ");
            return;
        }
        
        Inc_Num(n - 1);
        System.out.print(n + " ");
    }

    public static void main(String[] args) {
        int n = 10;
        Inc_Num(n);
    }
}
