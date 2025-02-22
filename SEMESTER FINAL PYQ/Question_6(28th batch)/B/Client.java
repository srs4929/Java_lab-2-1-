import java.io.*;
import java.net.*;
class Client{
    public static void main(String[] args)
    {
        try
        {
            Socket socket=new Socket("localhost",1234);
            System.out.println("Client started.....");
            File file=new File("Copy.txt");
            BufferedReader reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer=new BufferedWriter(new FileWriter(file,true));
            String line;
            while((line=reader.readLine())!=null)
            {
                writer.write(line);
                writer.newLine();
                writer.flush();
            }
            reader.close();
            writer.close();
           
            socket.close();
        }
        catch(Exception e)
        {
             e.printStackTrace();
        }
    }
}