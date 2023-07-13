import java.util.Scanner;

public class HW {

    public static double average(double a, double b, double c)
    {
        return (a + b + c)/3; 
    }

    public static boolean isEven(int n)
    {
        if(n%2 == 0)
        {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // double a = sc.nextDouble();
        // double b = sc.nextDouble();
        // double c = sc.nextDouble();

        // System.out.print(average(a, b, c));

        int n = sc.nextInt();

        if (isEven(n)) {
            System.out.print(n + " is even");
        }

        else
        {
            System.out.print(n + " is odd");
        }

        sc.close();
    }
}
