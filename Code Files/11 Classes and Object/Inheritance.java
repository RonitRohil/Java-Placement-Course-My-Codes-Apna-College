public class Inheritance {
    public static void main(String[] args) {
        Fish shark = new Fish();
        shark.eat();

        Dog dobby = new Dog();
        dobby.eat();
        dobby.legs = 4; 
        System.out.println(dobby.legs);

        Bird parrot = new Bird();
        parrot.eat();

        dobby.walk();
        shark.swim();
        parrot.fly();

    }
}

//Base Class
class Animal {
    String color;

    void eat()
    {
        System.out.println("eats");
    }

    void breathe() {
        System.out.println("Breathes");
    }
}


//Derieved Class
class Mammal extends Animal {
    int legs;

    void walk() {
        System.out.println("walks");
    }
}

//Derieved Class
class Fish extends Animal {
    int fins;

    void swim() {
        System.out.println("Swims in Water");
    }
}

//Derieved Class
class Bird extends Animal {
    void fly() {
        System.out.println("Flies in sky");
    }
}

//Derieved Class from derived Class
class Dog extends Mammal {
    String breed;
}

/*
 * Parent Base
 * Child Class
 * 
 * Single Level Inheritence 
 *  -- Base Class
 *  -- Derived Class
 * 
 * Multi Level Inheritance
 *  -- Base Class
 *  -- Derived Class
 *  -- Derived Class
 * 
 * Hierarchial Inheritance
 *  -- Base Class
 *  -- Derived Class -- Derived class
 * 
 * Hybrid Inheritence
 *  -- all inheritance
 * 
 * Multipe Inheritance
 *  -- In c++
 * 
 * 
 */