public class Powerof2_not {

    public static boolean isPower2(int n){
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        System.out.println(isPower2(8));
    }
}
