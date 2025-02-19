/*
 1) Consider the parent class named Account. Design its two child classes named 
 Current account and Saving accounts. Child class should have one additional 
 meaningful variable within them , one parameterized constructor, toString method.
 The current account maintains daily transactions and provides chequebook facilities
 but does not provide interest. But SavingAccount does not provide any chequebook but provides 
 yearly interest.

 2) Design a driver class InheritenceTest and a main method inside it.Declare at least one
 object each of the two child classes using the parameterized constructor.Display values of all 
 varaiables of these objects using the toString method. You have to ensure the maximum utilzation of its 
 parent classes
 
 class Account
 {
 int accountnumber;
 String name;
 double balance;
 Account(int n, String s, double b)
 { 
 accountnumber=n;
 name=s;
 balance=b;
 }
 public String toString()
 {
 return accountnumber+" "+name+" "+balance;
 }
 }


 */

 class Account{  //parent

    int accountnumber;
    String name;
    double balance;
    Account(int n,String s, double b)
    {
        this.accountnumber=n;
        this.name=s;
        this.balance=b;
    }
    public String toString()
    {
        return accountnumber+" "+name+" "+balance;
    }
 }

 class CurrentAccount extends Account //child
 {
       int dailytransaction;
       boolean chequebook;
       CurrentAccount(int n,String s, double b, int daily) //constructor 
       {
          super(n,s,b);
          this.dailytransaction=daily;
          this.chequebook=true;
       }
      
       public String toString()
       {
           return super.toString()+" Chequebook "+chequebook+ " Dailytransaction "+dailytransaction ;
           
       }

 }

 class SavingAccount extends Account
 {
       double interest;
       boolean chequebook;
       SavingAccount(int n,String s, double b, double i)
       {
        super(n,s,b);
        this.interest=i;
        this.chequebook=false;
       }

       double calculate()
       {
            return balance*(interest)/100;
       }

       public String toString()
       {
           return super.toString()+" Interestrate "+interest+" Yearly Interest Value "+ calculate();
       }
          
       
 }

 public class Main2  //replace the main class with InheritenceTest
 {
      public static void main(String[] args)
      {
        CurrentAccount ca = new CurrentAccount(101, "Soma", 5000.0, 10);
        System.out.println(ca);
        SavingAccount sa= new SavingAccount(101,"Soma",5000,3.5);
        System.out.println(sa);
      }
 }
 