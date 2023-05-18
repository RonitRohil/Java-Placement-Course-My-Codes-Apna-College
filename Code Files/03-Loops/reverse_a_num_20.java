import java.util.Scanner;

public class reverse_a_num_20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        //10899

        // printing reverse of num
        
        // while(n > 0)
        // {
        //     int i = n%10;
        //     System.out.print(i);
        //     n = n/10;
        // }

        // reversing a number

        int reverse = 0;

        while(n > 0)
        {
            int i = n%10;
            reverse = (reverse*10) + i;
            n = n/10;
        }

        System.out.println();
        System.out.println(reverse);
        sc.close();
    }
}
