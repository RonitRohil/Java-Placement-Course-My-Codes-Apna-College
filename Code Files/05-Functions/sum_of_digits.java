import java.util.Scanner;

public class sum_of_digits {

    public static int sumofdigit(int n)
    {
        int sum = 0;

        while (n > 0) {
            sum = sum + n%10;
            n = n/10;
        }

        return sum;
    }

    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextInt();

            int sum = sumofdigit(n);

            System.out.println(sum);
        }
    }
}
