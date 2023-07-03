import java.util.Comparator;

public class Arrays {

    public static void update(int marks[])
    {
        for (int i = 0; i < marks.length; i++) {
            marks[i] = marks[i] + 1;
        }
    }

    public static void main(String[] args) {
        int marks[] = {97, 98, 99};
        update(marks);

        // print our marks

        for (int i = 0; i < marks.length; i++) 
        {
            System.out.println(marks[i]);
        }
    }

    public static void sort(Integer[] costVer, Comparator<?> comparator) {
    }

    public static void sort(char[] word) {
    }

    public static Object asList(Integer[] currency) {
        return null;
    }

    public static void fill(int[] ways, int i) {
    }
}