public class Abstraction {
    public static void main(String[] args) {
        /*
                Horse h = new Horse();
                h.eat();
                h.walk();
                System.out.println(h.color);
                h.changeColor();
                System.out.println(h.color);

                Chicken c = new Chicken();
                c.eat();
                c.walk();
                System.out.println(c.color);
                c.changeColor();
                System.out.println(c.color);

                Mustang myHorse = new Mustang();

                // Animal -> Horse -> Mustang 
         */

        Queen q = new Queen();
        q.moves();

        King k = new King();
        k.moves();

        Rook r = new Rook();
        r.moves();
        
    }
}

// Abstraction

abstract class Animal{

    String color;

    Animal() {
        color = "brown";
        System.out.println("Animal constructor called .... ");
    }

    void eat(){
        System.out.println("Animal Eats");
    }

    abstract void walk();
}

class Horse extends Animal {

    Horse()
    {
        System.out.println("Horse constructor called ....");
    }

    void changeColor() {
        color = "dark brown";
    }

    void walk() {
        System.out.println("Walks on 4 legs");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang Horse constructor called ... ");
    }
}

class Chicken extends Animal {

    Chicken() {
        System.out.println("Chicken constructor called .... ");
    }

    void changeColor() {
        color = "Yellow";
    }

    void walk() {
        System.out.println("Walks on 2 legs");
    }
}

// Interface

interface ChessPlayer {
    void moves();
}

class Queen implements ChessPlayer{
    public void moves() {
        System.out.println("Up, Down, Left, Right, Diagonal (in all 4 dirns)");
    }
}

class Rook implements ChessPlayer{
    public void moves() {
        System.out.println("Up, Down, Left, Right");
    }
}

class King implements ChessPlayer{
    public void moves() {
        System.out.println("Up, Down, Left, Right, diagonal => only 1 step ");
    }
}

// Mutiple Inheritance

interface Herbivore {

}

interface Carnivore {

}

class Bear implements Herbivore, Carnivore {
    
}


/*
 * Abstraction
 * -> Hiding all the unnecessary details and showing only 
 *      the important parts to the user.
 * 
 *      idea - true
 *      implementation - false
 * 
 *  -- Abstract Classes
 *      => Cannot create an instance of abstract class
 *      => Can have abstractoin - abstract methods
 * 
 *  -- Interfaces
 *      => Interface is a blueprint of a class
 *      => Multiple Inheritance
 *      => Total Abstraction 
 *   
 * 
 *  Interface -> Implements
 *  Class -> Extends
 * 
 * 
 */