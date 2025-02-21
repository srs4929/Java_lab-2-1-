/*Consider some student objects have been written in a binary file named StudentInformation.dat where each student object has three attributes 
named id(int), name(String), and marks(double). Write a Java program to perform the following,

  (i) Read these student objects
  (ii) Determine which students have passed the exam (assume the pass mark is 50) 
  (iii) Print the id, and name of the students who have passed*/


  import java.io.*;

  class Student implements Serializable {
    int id;
    String name;
    double marks;

    // Constructor
    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }
}
  public class A{
    public static void main(String[] args)
    {
        try{
          
            FileInputStream file=new FileInputStream("StudentInformation.dat");
            ObjectInputStream in=new ObjectInputStream(file);
            System.out.println("Student who has passed :");
            System.out.println("--------------------------");
            while(true)
            {
                try{

                    Student s=(Student)in.readObject();
                    if(s.marks>=50.0)
                    {
                        System.out.println("Name : "+s.name+ " Id : "+s.id+" marks : "+s.marks);
                    }
                }
                catch(EOFException e) //end of file reached
                {
                    break;
                }
                catch(ClassNotFoundException e)
                {
                    e.printStackTrace();
                }
            }
            file.close();
            in.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
  }