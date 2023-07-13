import java.util.Scanner;

public class areaofsq08 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();

            int area = a*a;

            System.out.println(area);
        }
    }
}
