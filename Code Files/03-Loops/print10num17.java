import java.util.Scanner;

public class print10num17 {
    public static void main(String[] args) {
        int counter = 1;
        try (Scanner sc = new Scanner(System.in)) {
            int range = sc.nextInt();

            while(counter <= range)
            {
                System.out.println(counter);
                counter++;
            }
        }
    }
}
