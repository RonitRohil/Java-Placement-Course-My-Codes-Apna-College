import java.util.Scanner;

public class variablehwavg07 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            int avg = (a + b + c)/3;

            System.out.println(avg);
        }
    }
}
