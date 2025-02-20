/* Find the isuues in this programme */

public interface A    
{
    public void printA();  //printA() method need to be implemented
}
class Simple extends A{ // it should  be implemented. Class does not extend interface it implements  

    int x=10;
    static void access()
    {
        System.out.println("x "+x); // static method can only access static variable. Here x is defined as int not static
    }

abstract void simplePrint(); //abstract method can only be defined in abstract class
}
public class CodeProblem
{
    public void main(String[] args) // public static void main
    {
        Simple s=new Simple();
    }
}
