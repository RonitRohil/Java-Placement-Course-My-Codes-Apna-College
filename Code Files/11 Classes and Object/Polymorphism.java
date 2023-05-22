public class Polymorphism {
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.sum(1, 2));
        System.out.println(calc.sum(1.5, 2.5));
        System.out.println(calc.sum(1, 2, 3));

        Deer d = new Deer();
        d.eat();
    }
}

class Animal {
    void eat() {
        System.out.println("Eats anything");
    }
}

class Deer extends Animal {
    void eat() {
        System.out.println("Eats Grass");
    }
}

class Calculator {
    int sum (int a, int b)
    {
        return a + b;
    }

    double sum (double a, double b)
    {
        return a + b;
    }

    int sum(int a, int b, int c)
    {
        return a + b + c;
    }
}


/*
 * Polymorphism
 * 
 * Compile Time Polymorphism (Static)
 *  -- Method Overloading
 *      => Mutiple functions with same name but 
 *          different parameters
 * 
 * 
 * 
 * Run Time Polymorphism (Dynamic)
 *  -- Method Overriding    
 *      => Parent and child classes both contain the same
 *          same function with a different definition
 * 
 */