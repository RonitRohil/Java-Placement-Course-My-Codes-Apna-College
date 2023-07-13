import java.util.Scanner;

public class Functions {

    public static void printHelloworld()
    {
        System.out.println("Hello World");
        System.out.println("Hello World");
        System.out.println("Hello World");
    }

    public static int sum(int a, int b)
    {
        int sum = a + b;
        return sum;
    }

    public static int product(int a, int b)
    {
        int prod = a*b;
        return prod;
    }

    public static int fact(int n)
    {
        int fact = 1;

        for(int i = 1; i <= n; i++)
        {
            fact *= i;
        }

        return fact;
    }

    public static int binomial_coeff(int n, int r)
    {
        int c = fact(n)/(fact(n - r)*fact(r));
        return c;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        // int sum = sum(a, b);
        // System.out.println("a + b = " + sum);

        // int prod = product(a, b);
        // System.out.println("a*b = " + prod);

        // int fact = fact(a);
        // System.out.println(a + "! = " + fact);

        int b_C = binomial_coeff(a, b);
        System.out.print(b_C);

        sc.close();
    }
}
