/*In this problem, we will deal with the student database. A student can be identified
with two pieces of information: name (string data) and roll number (integer data).
a) We should have a class that would address associated members to solve this
problem (Mark 10).
b) We should have a function that adds a new student to the database. (Mark
20).
c) We are going to track 7 days of student attendance. We should have a method
that would take the day number (1st day, 2nd day, …) along with the student’s
roll to store the information that the student was present at that day (Mark
30).
d) Finally, we should have another method that would take a parameter
denoting the student’s roll number and print the statistics (Mark 40). In this
statistics, we need to print, the student’s full name, and the percentage of days
he was present among the seven days. Alongside the days when he was
absent.*/
import java.util.Scanner;
class Student{   //student class
    
    String name;
    int roll;
    int [] attend;
    Student(String name,int roll)
    {
        this.name=name;
        this.roll=roll;
        attend=new int[7];
    }

}

//database

class Database{
    
   int count=0;
   Student [] student=new Student[60];

   void add(Student s)
   {
    if(count<student.length)
    {
        student[count]=s;
        count++;
    }
   }

   //tracker
   //for present 1
   //for absent 0
   void track(int roll,int day,int present)
   {
       for(int i=0;i<count;i++)
       {
           if(student[i].roll==roll)
           {
            student[i].attend[day]=present;
           }
       }
   }

   //print the statisctics

    void print(int roll)
    {
       for(int i=0;i<count;i++)
       {
           if(student[i].roll==roll)
           {
              System.out.println("The name of the student :"+student[i].name);
              System.out.println("The roll of the student :"+student[i].roll);
              System.out.println("The track day of the student :");

              for(int j=0;j<7;j++)
              {
                System.out.println("Day "+(j+1)+":"+student[i].attend[j]);
              }
           }
       }
    }


}

public class Main
{
   public static void main(String[] args)
   {    
        System.out.println("How many queries :");
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        Database d=new Database();
        sc.nextLine();
        for(int j=0;j<t;j++)
        {
        System.out.println("Enter 1 to add student");
        System.out.println("Enter 2 to print the information of the student");
      
        int input=sc.nextInt();
        sc.nextLine();
       
        if(input==1)
        {
           System.out.println("Enter Student's name");
           String name=sc.nextLine();
           System.out.println("Enter Student's roll");
           int roll=sc.nextInt();
           Student s=new Student(name,roll);
          
           d.add(s);
           System.out.println("Give 0 for his absent and 1 for present for seven days :");

           for(int i=0;i<7;i++)
           {  
            
              System.out.println("For day "+(i+1));
              int attendence=sc.nextInt();
              sc.nextLine();
              
              d.track(roll,i,attendence);
           }
        }
        else
        {
             System.out.println("The roll number that you want to print the information :");
             int roll=sc.nextInt();
             sc.nextLine();
             d.print(roll);

        } 
    }   
        


        


   }
}