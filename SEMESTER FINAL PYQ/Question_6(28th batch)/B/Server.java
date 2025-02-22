/*(b)Suppose, you have the following file on your server-side saved as "A.txt" and you need to make a copy of this file on the client side. Write a Java program based on 
   socket programming to send the contents of a file from server to client. Find the file content below:
   
   The brown fox makes a jump
   There is a beautiful movie called The Beautiful Mind
   A person with a beautiful heart, made of iron.*/

import java.io.*;
import java.net.*;
public class Server{
   public static void main(String[] args)
   {
      try
      {
         ServerSocket serversocket=new ServerSocket(1234);
         System.out.println("Server has started");
         Socket socket=serversocket.accept();
         System.out.println("Client is connected to server");
         File file=new File("A.txt");
         BufferedReader reader=new BufferedReader(new FileReader(file));
         BufferedWriter writer=new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

         String line;
         while((line=reader.readLine())!=null) //read from file
         {
               writer.write(line);
               writer.newLine();
               writer.flush();
         }
         
         writer.close();
         reader.close();
         serversocket.close();
         socket.close();

      }
      catch(Exception e)
      {
         e.printStackTrace();
      }
   }
}

