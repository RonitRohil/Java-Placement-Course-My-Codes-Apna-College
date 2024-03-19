public class DecreasingNumber {

    public static void Dec_Num(int n)
    {
        if (n == 1) {
            System.out.print(n);
            return;
        }
        System.out.print(n + " ");
        Dec_Num(n - 1);
    }

    public static void main(String[] args) {
        int n = 10;
        Dec_Num(n);
    }
}