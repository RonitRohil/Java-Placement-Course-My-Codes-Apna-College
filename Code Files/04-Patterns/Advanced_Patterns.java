import javax.swing.plaf.synth.SynthStyle;

public class Advanced_Patterns{

    public static void hollow_rect(int rows, int cols)
    {
        for (int i = 1; i <= rows; i++) 
        {
            for(int j = 1; j <= cols; j++)
            {
                if (i == 1 || i == rows || j == 1 || j == cols) {
                    System.out.print("* ");
                }

                else
                {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void inverted_rotated_half_pyramid(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            // Spaces
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print("  ");
            }

            // stars
            for(int j = 1; j <= i; j++)
            {
                System.out.print("* ");
            }

            System.out.println();
        }
    }

    public static void inverted_half_pyramid_num(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= n - i + 1; j++)
            {
                System.out.print(j);
            }

            System.out.println();
        }
    }

    public static void floyds_triangle(int n)
    {
        int counter = 1;
        for (int i = 1; i <= n; i++) 
        {
            for(int j = 1; j <= i; j++)
            {
                System.out.print(counter + " ");
                counter++;
            }

            System.out.println();
        }
    }

    public static void zero_one_traingle(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            for(int j = 1; j <= i; j++)
            {
                if((i+j) % 2 == 0)
                {
                    System.out.print("1");
                }

                else
                {
                    System.out.print("0");
                }
            }

            System.out.println();
        }
    }

    public static void butterfly(int n)
    {
        for (int i = 1; i <= n; i++) 
        {
            //stars - i

            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            
            // spaces - 2(n - i)

            for(int j = 1; j <= 2*(n - i); j++)
            {
                System.out.print(" ");
            }

            // stars - i

            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n; i >= 1; i--) 
        {
            //stars - i

            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }
            
            // spaces - 2(n - i)

            for(int j = 1; j <= 2*(n - i); j++)
            {
                System.out.print(" ");
            }

            // stars - i

            for(int j = 1; j <= i; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void solid_rhombus(int n)
    {
        for(int i = 1; i <= n ; i++)
        {
            // spaces
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            // stars

            for(int j = 1; j <= n; j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void hollow_rhombus(int n)
    {
        for(int i = 1; i <= n ; i++)
        {
            // spaces
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            // stars

            for(int j = 1; j <= n; j++)
            {
                if (i == 1 || i == n || j == 1 || j == n) 
                {
                    System.out.print("* ");
                }

                else
                {
                    System.out.print("  ");
                }
            }

            System.out.println();
        }
    }

    public static void diamond(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            //spaces
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            // stars

            for(int j = 1; j <= (2*i - 1); j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }

        for(int i = n; i >= 1; i--)
        {
            //spaces
            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            // stars

            for(int j = 1; j <= (2*i - 1); j++)
            {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    public static void number_pyramid(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            // spaces

            for(int j = 1; j <= n - i; j++)
            {
                System.out.print(" ");
            }

            // numbers

            for(int j = 1; j <= i; j++)
            {
                System.out.print(i + " ");
            }

            System.out.println();
        }
    }

    public static void palindromicPatternwitNum(int n)
    {
        for(int i = 1; i <= n; i++)
        {
            //spaces
            for(int j = 1; j <= (n - i); j++)
            {
                System.out.print(" ");
            }

            // descending
            for (int j = i; j >= 1; j--) 
            {
                System.out.print(j);
            }

            // ascending
            for (int j = 2; j <= i; j++) 
            {
                System.out.print(j);
            }

            System.out.println();
        }
    }
        
    public static void main(String[] args) {

        //hollow_rect(4, 5);
        // System.out.println();
        // inverted_rotated_half_pyramid(4);
        // System.out.println();
        //inverted_half_pyramid_num(5);

        //floyds_triangle(5);

        //zero_one_traingle(5);

        //butterfly(5);

        //solid_rhombus(5);

        //hollow_rhombus(5);

        // diamond(5);

        //number_pyramid(5);

        palindromicPatternwitNum(5);
    }
}