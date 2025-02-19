//Explain the concept of polymorphism using examples

//Polymorphism- is the ability to take on different form
//method overloading-compile time
//method overiding -run time 

//overloading - allows different methods to have same name but different parameters

class Demo //method overloading
{
    void test()
    {
        System.out.println("No parameter");
    }
    void test(int a)
    {
        System.out.println("a : "+a);
    }
    void test(double a, double b)
    {
        System.out.println("a : "+a +" b :"+b);
    }
}

//method overriding : is a feature where a child class provides a new implementation for a 
//method that is already defined in its parent class, while keeping same method name and parameter

class Animal
{
    void sound()
    {
        System.out.println("Animals are barking");
    }
}
class Dog extends Animal
{
    void hello()
    {
         System.out.println("Hello from dog");
    }
}
class Main1
{
    public static void main(String[] args)
    {
        Demo a=new Demo();
        a.test();
        a.test(6);
        a.test(78.9,90.5);
        Animal p=new Animal();
        p.sound();
        Dog x=new Dog();
        x.hello();
        x.sound();
    }
} 
