/*
 You are given following multithreaded programme.You need to extract the values from the array
 given Arr in the object of the class Data and store them locally within the 
 classes'array  SArr that implements the thread.Each value should be extracted only once from Arr.
 You can assume all the values of arr will be positive value.For any index , -1 means
 that the value of the index has already been extraced.

 identify any concurrency-related issue and explain your rationale.In addition ,
 mention any synchronization measure you would consider here.
 */

 class Data
 {
    int Arr[];
    public Data()
    {
        Arr=new int[20];
        for(int i=0;i<20;i++)
        {
            Arr[i]=i*2+1;
        }
    }
 }

 class Processor implements Runnable
 {
    Data d;
    int SArr[];
    Thread t;
    Processor(Data d, String threadname)
    {
        SArr=new int[20];
        this.d=d;
        t=new Thread(this,threadname);
    }
    public void run()
    {   
       
        int j=-1;
        for(int i=0;i<20;i++)
        {    
             
            synchronized (d){
            if(this.d.Arr[i]!=-1)
            {
                j++;
                SArr[j]=this.d.Arr[i];
                System.out.println(" j "+SArr[j]+" "+i+" "+d.Arr[i]+" "+Thread.currentThread());
                this.d.Arr[i]=-1;
            }
        }
        }
    }
 }

 public class b{
    public static void main(String[] args)
    {
        Data d=new Data();
        Processor p1=new Processor(d,"p1");
        Processor p2=new Processor(d,"p2");
        p1.t.start();
        p2.t.start();
        try
        {
            p1.t.join();
            p2.t.join();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }

    }
 }

 //in the previous code there was no synchronization. As a result two thread p1,p2 was sharing same object at the same time
 // and was creating racing condition. if two thread was reading same Arr[i], they may extract same value which results duplicate result.
 /*
  with sync output :
  j 1 0 1 Thread[p1,5,main]
 j 3 1 3 Thread[p1,5,main]
 j 5 2 5 Thread[p1,5,main]
 j 7 3 7 Thread[p1,5,main]
 j 9 4 9 Thread[p1,5,main]
 j 11 5 11 Thread[p1,5,main]
 j 13 6 13 Thread[p1,5,main]
 j 15 7 15 Thread[p1,5,main]
 j 17 8 17 Thread[p1,5,main]
 j 19 9 19 Thread[p1,5,main]
 j 21 10 21 Thread[p1,5,main]
 j 23 11 23 Thread[p1,5,main]
 j 25 12 25 Thread[p1,5,main]
 j 27 13 27 Thread[p1,5,main]
 j 29 14 29 Thread[p1,5,main]
 j 31 15 31 Thread[p1,5,main]
 j 33 16 33 Thread[p1,5,main]
 j 35 17 35 Thread[p1,5,main]
 j 37 18 37 Thread[p1,5,main]
 j 39 19 39 Thread[p1,5,main]

 Since in the p1 thread all the index of Arr[i]=-1 then nothing will impact on p2 thread
  */