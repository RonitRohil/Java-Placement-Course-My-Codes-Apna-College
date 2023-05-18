import java.util.Scanner;

public class IsPalindrome {

    public static boolean isPalindrome(int n)
    {
        int num = n;
        int reverse = 0;

        while (num != 0) 
        {
            int remainder = num % 10;
            reverse = reverse * 10 + remainder;
            num = num / 10;
        }

        if (reverse == n) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        if (isPalindrome(n)) 
        {
            System.out.println(n + " is a Palindrome.");
        }

        else
        {
            System.out.println(n + " is not a Palindrome.");
        }

        sc.close(); 
    }
}
