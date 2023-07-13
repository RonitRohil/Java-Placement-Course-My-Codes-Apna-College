import java.util.*;

public class input03 {
    public static void main(String args[]) {
        try (Scanner sc = new Scanner(System.in)) {
            String name = sc.nextLine();
            System.out.println(name);

            int num = sc.nextInt();
            System.out.println(num);

            float price = sc.nextFloat();
            System.out.println(price);
        }
    }
}
