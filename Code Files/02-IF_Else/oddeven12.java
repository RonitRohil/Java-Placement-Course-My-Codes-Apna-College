import java.util.Scanner;

public class oddeven12 {
    public static void main(String[] args) {

        try (Scanner sc = new Scanner(System.in)) {
            int num = sc.nextInt();

            if(num % 2 == 0)
            {
                System.out.println("Even");
            }

            else
            {
                System.out.println("Odd");
            }
        }
        
    }
}
