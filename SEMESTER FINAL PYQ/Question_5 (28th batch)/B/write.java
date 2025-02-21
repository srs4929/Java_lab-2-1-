import java.io.*;
import java.io.Serializable;
class Student implements Serializable
{    
    String name;
    int id;
    double marks;
    Student(String name,int id,double marks)
    {
        this.name=name;
        this.id=id;
        this.marks=marks;
    }
}

class write{
    public  static void main(String [] args)
   {   try{
        Student s1=new Student("Soma",07,45.5);
       Student s2=new Student ("Jon",90,33);
       Student s3=new Student("Disco",01,90);
       FileOutputStream file=new FileOutputStream("StudentInformation.dat");
       ObjectOutputStream obj=new ObjectOutputStream(file);
       obj.writeObject(s1);
       obj.writeObject(s2);
       obj.writeObject(s3);
       obj.close();
       file.close();
       System.out.println("Successful");
   }
   catch(IOException e)
   {
    e.printStackTrace();
   }

   }
}