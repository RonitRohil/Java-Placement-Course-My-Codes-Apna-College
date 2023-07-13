public class Keywords {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.schoolName = "CCHS";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "BTS";
        System.out.println(s3.schoolName);
        System.out.println(s1.schoolName);
        System.out.println(s2.schoolName);

        Horse h = new Horse();

        System.out.println(h.color);

    }
}

class Student {

    static int returnPercentage(int math, int phy, int chem)
    {
        return (math + phy + chem) / 3;
    }

    String name;
    int roll;

    static String schoolName;

    void setName(String name){
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}

class Animal {

    String color;

    Animal() {
        System.out.println("Animal Constructor is called");
    }
}

class Horse extends Animal {
    Horse() {
        super.color = "brown";
        System.out.println("Horse constructor is called .. ");
    }
}


/*
 * Static Keyword =>> Constant
 * -- Use to share the same variable or method of a 
 *    given class
 * 
 * Super Keyword
 * -- Use to refer immediate parent class object 
 * 
 * Construtor Chaining*
 * 
 */