

import java.io.*;
import java.net.*;

class send extends Thread // for sending thread
{
     Socket socket;
     send(Socket socket)
     {
       
        this.socket=socket;
     }

     public void run()
     {  
        try{
        PrintWriter out=new PrintWriter(socket.getOutputStream(),true);
        //Userinput
        BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
        String msg;
        while(true)
        {
            msg=input.readLine() ; // read
            out.println(msg) ; // show the message to other user
        }
    } 
    catch(IOException e)
    {
       e.printStackTrace() ;
    }
   }   
}

class receive extends Thread{

    Socket socket;
    receive(Socket socket)
    {
        this.socket=socket;
    }

    public void run(){
        try{

            BufferedReader in=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String msg;

            while ((msg = in.readLine()) != null) { // Read message from client
                System.out.println("Server :  " + msg);
            }
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

class client
{
    public static void main(String[] args)
    {   
        try{
       
        Socket socket=new Socket("localhost",1234);
        System.out.println("Client is connected");
        send s=new send(socket);
        s.start();
        receive r=new receive(socket);
        r.start();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

    }
}