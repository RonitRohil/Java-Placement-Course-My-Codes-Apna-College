import java.util.Scanner;

public class sum_of_odd_even_22 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int num;
        int choice;
        int even_sum = 0;
        int odd_sum = 0;

        do
        {
            System.out.println("Enter a number: ");
            num = sc.nextInt();

            if (num % 2 == 0) 
            {
                even_sum += num;                    
            }

            else
            {
                odd_sum += num;
            }

            System.out.println("Do you want to continue?");
            System.out.println("Press 1 for YES");
            System.out.println("Press 0 for NO");
            choice = sc.nextInt();
        }

        while(choice == 1);

        System.out.println("Sum of even numbers: " + even_sum);
        System.out.println("Sum of odd numbers: " + odd_sum);

        sc.close();
    }
}
