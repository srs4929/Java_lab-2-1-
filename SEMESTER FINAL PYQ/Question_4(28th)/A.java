/*
 Suppose , you are implementing a database for storing some information 
 of some students. You will be given an array of students.Each student has a 
 unique name and three additional features-age, address and nationality.After storing the information
 you will be asked with a query to fetch the data of the student named X.
 If no such entry exists , you need to create a custome exception denoting the issue
 */

 import java.util.Scanner;
  
 class notfound extends Exception{ // exception creation 
    
    public notfound(String message) 
    {
        super(message);
    }
 }
 class Student{

    String name;
    int age;
    String address;
    String naitonality;
    Student(String name, int age, String address, String naitonality)
    {
        this.name=name;
        this.age=age;
        this.address=address;
        this.naitonality=naitonality;
    }
 }

 class Database{
       
    int count=0;
    Student [] s=new Student[100];

    boolean  check(Student a) // if a student name already exists
    {
        for(int i=0;i<count;i++)
        {
            if(s[i].name.equals(a.name))
            {
                return true;
            }
        }
        return false;
    }

    void add(Student x)
    {
        if(count<s.length)
        {   
            if(check(x))
            {
                System.out.println("Sorry this name has been added");
            }
            else{
            s[count]=x;
            count++;
            }
        }
    }

     void query(String name) throws notfound
    {
        for(int i=0;i<count;i++)
        {
            if(s[i].name.equals(name))
            {
                System.out.println("Name : "+s[i].name);
                System.out.println("Age : "+s[i].age);
                System.out.println("Address : "+s[i].address);
                System.out.println("Naitonality : "+s[i].naitonality);
                return ;
            }
        }
        throw new notfound("Sorry , student is not found") ;
    }

}

class A{
   
    public static void main(String[] args)
    {
        Database d=new Database();
        Student s1=new Student("Soma",21,"Dhaka","British");
        Student s2=new Student("David",21,"Dhaka","British");
        //Student s3=new Student("Soma",21,"Dhaka","British");
        d.add(s1);
        d.add(s2);
       // d.add(s3);
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        try
        {
            d.query(s);
        }
        catch(notfound e)
        {
            System.out.println(e.getMessage());
        }
    }
}
    
 