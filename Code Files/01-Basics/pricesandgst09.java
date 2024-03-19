import java.util.Scanner;

public class pricesandgst09 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            float pencil = sc.nextFloat();
            float pen = sc.nextFloat();
            float eraser = sc.nextFloat();

            float total = pencil + pen + eraser;

            System.out.println("Total: " + total);

            float total_gst = total + (0.18f*total);

            System.out.println("Total Bill with gst: " + total_gst);
        }
    }
}
