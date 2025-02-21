// What is the usefulness of the Serializable interface in Java I/O? Explain with an example,
/*
 Serialization :  The concept of representing an objects state as a byte stream . The byte stream has all the information
 about the object.

 Serializable interface is used to convert an objects state to byte stream.
 Importance :
 1) Allow objects to store in file or Database
 2) Objects can be transferred between application over a network

 */

 import java.io.*;
 class Person implements Serializable
 {
    String name;
    int age;
    Person(String name, int age)
    {
        this.name=name;
        this.age=age;
    }
    public void display()
    {
        System.out.println("Name : "+name+" Age : "+age);
    }
 }
 class A{
    public static void main(String[] args)
    {
        try
        {
            Person p=new Person("Soma",20);
            FileOutputStream file=new FileOutputStream("info.txt");
            ObjectOutputStream out=new ObjectOutputStream(file);
            //writing object to file
            out.writeObject(p);
            out.close();
            file.close();
            System.out.println("Successful");
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
 }