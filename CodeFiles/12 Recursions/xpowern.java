import java.util.*;
import java.math.*;

public class xpowern {

    public static int xpown(int x, int n)
    {
        if(n == 0)
        {
            return 1;
        }

        return x*xpown(x, n-1);

    }

    public static int optimizedPower(int x, int n)
    {

        if(n == 0)
        {
            return 1;
        }

        int a = optimizedPower(x, n/2);

        int halfPowerSq = a*a;

        if (n % 2 != 0) {
            halfPowerSq = x*halfPowerSq;
        }

        return halfPowerSq;
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 20;

        System.out.println(xpown(x,n));
        System.out.println(xpown(2, 10));

        // System.out.println(optimizedPower(x,n));
        // System.out.println(optimizedPower(2, 10));
    }
}
