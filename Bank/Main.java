/*In this problem, we will deal with a banking system. A customer of a bank will have
two pieces of information for his authentication, name (string data) and customer ID
(integer number).
a) We should have a class that would address associated members to solve this
problem (Mark 10).
b) We should have a function that adds a new customer to the database (Mark
20).
c) We are going to track 7 days of banking transactions. We should have a
method that would take the day number (1st day, 2nd day, …) customer ID,
transaction type (deposit/withdrawal), and an amount of money (integer).
This method would be responsible for executing the transaction and updating
the information in the banking database (Mark 30).
d) Finally, we should have another method that would take a parameter
denoting the customer’s ID and print the statistics (Mark 40). In these
statistics, we need to print the customer’s full ID, the amount of current
savings in his account, and the days when he did some sort of transaction
(deposit/withdrawal) with the information regarding the associated money.*/
import java.util.Scanner;
class Customer{  // customer class

    String name;
    int id;
    String[] day;
    Customer(String name, int id)
    {
        this.name=name;
        this.id=id;
        this. day=new String[7];
    }
}

class Database
{
     Customer[] customer=new Customer[30] ;
     int count=0;

     void add(Customer c)
     {
        if(count<customer.length)
        {
            customer[count]=c;
            count++;
        }
     }
     void track(int d,int id,String type)
     {
         for(int i=0;i<count;i++)
         {
            if(id==customer[i].id)
            {
                
               
                customer[i].day[d]=type;

            }
         }
     }

     void print(int id) {
        if (count == 0) {
            System.out.println("No customers in the database.");
            return;
        }

        for (int i = 0; i < count; i++) {
            if(id==customer[i].id){
            System.out.println("Customer Name: " + customer[i].name);
            System.out.println("Customer ID: " + customer[i].id);
            System.out.println("Activity Types:");
            for (int d = 0; d < 7; d++) {
              
                System.out.println("Day : "+(d+1)+"type :"+customer[i].day[d]);
            }
            
        }
    }
}



}
public class Main
{
    public static void main(String[] args)
    {
        System.out.println("How many queries");
        Scanner sc=new Scanner(System.in);
        int q=sc.nextInt();
        sc.nextLine();
        Database d=new Database();
        for(int i=0;i<q;i++)
        {
           System.out.println("1.Add");
           System.out.println("2.Track");
           System.out.println("3.Print");
           int t=sc.nextInt();
           sc.nextLine();
           if(t==1)
           {
              System.out.println("Enter the name");
              String s=sc.nextLine();
              System.out.println("Enter the id");
              int id=sc.nextInt();
              sc.nextLine();
              Customer c=new Customer(s,id);
              d.add(c);

           }
           if(t==2)
           {
                 System.out.println("Enter the day (0-6):");
                int day = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the ID:");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.println("Enter the type :");
                String type=sc.nextLine();
                d.track(day, id,type);
           }
           if(t==3)
           {
                System.out.println("Enter the ID:");
                int id = sc.nextInt();
                sc.nextLine();
                d.print(id);
           }
        }

    }
}