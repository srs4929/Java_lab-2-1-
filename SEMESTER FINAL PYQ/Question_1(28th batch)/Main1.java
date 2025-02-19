//Inheritance provides a powerful mechanism for code reuse- justify

/*Inheritance allows a child class to inherits properties and behaviours from
another class (parent class)

code reuse -

1)Avoids code duplication : Instead of writing the same code in multiple places, we define it once in a parent class and reuse it in child classes.
2)Modification : If a method or property needs modification, we change it in the parent class, and the change reflects in all derived classes automatically.

*/

//code reusability example
class Vehicle
{
    String brand;
    int speed;
    void show()
    {
        System.out.println("Brand : "+brand+" Speed : "+speed);
    }
}

class Car extends Vehicle{
    int numdoor;
}

public class Main1
{
    public static void main(String[] args)
    {
        Car c=new Car();
        c.brand="Toyota";
        c.speed=120;
        c.numdoor=3;
        c.show(); // reusablity we did not have to define brand , speed again . It is inheriting from Vehicle
    }
}


