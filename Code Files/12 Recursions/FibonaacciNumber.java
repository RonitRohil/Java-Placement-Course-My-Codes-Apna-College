public class FibonaacciNumber {

    public static int Fib(int n)
    {
        if(n == 0)
        {
            return 0;
        }

        if(n == 1)
        {
            return 1;
        }

        int num = Fib(n-1) + Fib(n - 2);

        return num;
        
    }

    public static void main(String[] args) {
        System.out.println(Fib(28));
    }
}

// 0 1 2 3 4 5 6 7 8 9 10 11 12
// 0 1 1 2 3 5 8 13 
