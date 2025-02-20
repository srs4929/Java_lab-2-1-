/*
 Identify the problemetic issues that might exist
 */

 public interface InnerExampleCode
 {
    static int x;  //interface variable must be initialized
    final int y;
    void demo()  //method should be declared without body
    {
       System.out.println("Demo functions here");
    }
    public void adddemo(); // this method is not implemented in the extend
 }

 class Def extends InnerExampleCode{  // interfaces are implemented not extended
    void demo()
    {
          x=67;  // interface variable are implicitly final. so modification can not be done. use local
          System.out.println("Demo functions here "+x);
    }
    void newFun()
    {
         int z=x+y; // x and y are not initialized
    }
 }

 public class ExampleCode{
     
    public static void  main(String[] args)
    {
        InnerExampleCode inExp=new Def(); // it should be Def inExp=new Def()
        inExp.newFun();
    }
 }