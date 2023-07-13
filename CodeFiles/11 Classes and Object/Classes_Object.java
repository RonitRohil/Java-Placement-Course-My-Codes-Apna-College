public class Classes_Object {
    public static void main(String[] args) {
        Pen p1 = new Pen();
        p1.setColor("Blue");
        System.out.println(p1.getColor());
        
        p1.setTip(5);
        System.out.println(p1.getTip());

        p1.setColor("Yellow");
        System.out.println(p1.getColor());

        BankAccount myAcc = new BankAccount();
        myAcc.username = "Ronit";
        myAcc.setPassword("ronit123");

    }
}

class BankAccount {
    public String username;
    private String password;
    public void setPassword(String pwd)
    {
        password = pwd;
    }
}

class Pen {
    private String color;
    private int tip;

    int getTip()
    {
        return this.tip;
    }

    String getColor() {
        return this.color;
    }

    void setColor(String newColor)
    {
        color = newColor;
    }

    void setTip(int newTip)
    {
        tip = newTip;
    }
}

class Student {
    String name;
    int age;
    float percentage;

    void calcPercentage(int phy, int chem, int math)
    {
        percentage = (phy + chem + math) / 3;
    }
}



/*
 * 
 * parent reference == child object
 * 
 * 
 * Encapsulation - Wrapping up of data & methods under
 * a single unit, implementing data hiding
 * 
 * inheritance
 * 
 * abstaraction
 * 
 * polymorphism
 * 
 * 
 * https://www.w3schools.com/java/java_try_catch.asp
 * 
 */