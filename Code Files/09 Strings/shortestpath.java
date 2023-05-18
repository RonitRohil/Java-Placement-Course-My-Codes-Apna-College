import java.util.*;

public class shortestpath {

    public static double shortest_path(String str)
    {
        int x = 0;
        int y = 0;

        for (int i = 0; i < str.length(); i++) {
            char dir = str.charAt(i);

            if(dir == 'S')
            {
                y--;
            }

            if(dir == 'N')
            {
                y++;
            }

            if(dir == 'E')
            {
                x++;
            }

            if(dir == 'W')
            {
                x--;
            }
        }

        int X2 = x*x;
        int Y2 = y*y;

        return Math.sqrt(X2 + Y2);
    }

    public static void main(String[] args) {
        String path = "WNEENESENNN";
        System.out.println(shortest_path(path));
    }
}
