import java.util.Random;
import java.util.Map; 
import java.util.HashMap; 

//exception creation 

class withdraw extends Exception  //withdraw error
{
    public withdraw(String message)
    {
        super(message);
    }
}

class deposit extends Exception{  // deposit error

    public deposit(String message)
    {
        super(message);
    }
}

class account extends Exception{ //more withdraw than account money

    public account(String message)
    {
        super(message);
    }
}

class Generator extends Thread{
    int totalNumofTrans; 
    Random random = new Random(); 
    Map<Integer,Boolean>track = new HashMap<>(); 
    Generator(String name, int total){
        super(name); 
        this.totalNumofTrans = total; 
        start(); 
    }
    String genDeposit(){ // generating deposit type transaction
        int transID = genRandomTransID(); 
        int money = random.nextInt(10000) + 1; 
        int customerSerial = random.nextInt(100) + 1; // customers between 1 to 100 IDs ; 
        String message = "TRANSACTION " + transID +" DEPOSIT " + money + " CUSTOMER " + customerSerial; 
        return message;
    }
    String genWithdraw(){ // generating withdraw type transaction 
        int transID = genRandomTransID(); 
        int money = random.nextInt(10000) + 1; 
        int customerSerial = random.nextInt(100) + 1; // customers between 1 to 100 IDs ; 
        String message = "TRANSACTION " + transID +" WITHDRAW " + money + " CUSTOMER " + customerSerial; 
        return message;
    }
    String genCreate(){ // generating creation of customer type transaction
        int transID = genRandomTransID(); 

        int sz = random.nextInt(12) + 1; // Random size between 1 and 12
        String name = genRandomString(sz); 

        String message = "TRANSACTION " + transID +" CREATE CUSTOMER " + name; // 1st customer ID 1, 2nd Customer ID 2, 3rd so on 
        return message;
    }

    int genRandomTransID(){
        int v; 
        while(true){
            v = random.nextInt(100000000); 
            if(track.containsValue(v)) continue; 
            else {
                track.put(v, true); 
                break; 
            }
        }
        return v; 
    }

    String genRandomString(int sz){
       String name=""; 
       int v; 
       String temp;
       for(int i=0; i<sz; i++){
            v = random.nextInt(25) + 'A'; 
            name = name + (char)v; 
       }
       return name; 
    }
    public void run(){
        int v; 
        for(int i=0; i<totalNumofTrans; i++){
             v = random.nextInt(2); 
             String trans=""; 
             if(v == 0) {
                trans = genCreate(); 
             }
             if(v == 1) {
                trans = genDeposit();
             }
             if(v == 2){
                trans = genWithdraw(); 
             }
             System.out.println(trans); 
             try{
                Thread.sleep(2000); 
             }  
             catch(Exception e){
                e.printStackTrace(); 
             }
        }
    }
}

public class BankController_Roll_07 {
    public static void main (String [] args) {
            Generator g = new Generator("Transaction Generator Thread.", 1000); 

            try {
                g.join(); 
            }
            catch (Exception e){
                e.printStackTrace(); 
            }
            
    }
}