import java.lang.ref.Reference;

public class Constructor {
    public static void main(String[] args) {
        Student s1 = new Student();
        // Student s2 = new Student("Ronit");
        // Student s3 = new Student(123);
        // Student s4 = new Student("ronit", 12);

    //     System.out.println(s1.name);
    //     // System.out.println(s1.name);
    //     System.out.println(s1.name);

        s1.name = "ronit";
        s1.roll = 12;
        s1.password = "abjfdb";

        s1.marks[0] = 100;
        s1.marks[1] = 90;
        s1.marks[2] = 95;

        Student s2 = new Student(s1);
        s2.password = "xyz";

        s1.marks[1] = 100;

        for (int i = 0; i < 3; i++) {
            System.out.println(s2.marks[i]);
        }

    }
}

class Student {
    String name;
    int roll;
    String password;
    int marks[];

    //shalllow copy constructor
    // Student(Student s1)
    // {
    //     marks = new int[3];
    //     this.name = s1.name;
    //     this.roll = s1.roll;
    //     this.marks = s1.marks;
    //     // this.password = s1.password;
    // }

    // Deep Copy constructor
    Student(Student s1)
    {
        marks = new int[3];
        this.name = s1.name;
        this.roll = s1.roll;

        for (int i = 0; i < marks.length; i++) {
            this.marks[i] = s1.marks[i];
        }
    }

    Student(){
        marks = new int[3];
        System.out.println("Constructor is called ....");
    }

    Student(String name)
    {
        marks = new int[3];
        this.name = name;
    }

    Student(int roll)
    {
        marks = new int[3];
        this.roll = roll;
    }
}

/*
 * 
    this is polymorphism

    Copy Constructor

    Shallow and                  Deep Copy
    |                              | 
    References                   New copy
    changes reflect              Changes don't reflect

 * 
 * 
 */

