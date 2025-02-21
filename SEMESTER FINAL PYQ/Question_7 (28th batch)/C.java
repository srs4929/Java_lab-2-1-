//Explain deadloack with example

/*
 Deadloack : Deadloack occurs in java when multiple threads block each other 
 while waiting for locks held by one another. It happens when two threads have a 
 circular dependency on a pair of synchronized object.
 */

 //Example :

 class A
 {
     synchronized void foo(B b)
     {
        String name=Thread.currentThread().getName();
        System.out.println(name + " entered A.foo");

        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println("A interrupted");
        }

        System.out.println(name +" trying to call B.last()");
        b.last();
     }

     synchronized void last()
     {
        System.out.println("Inside A.last");
     }
 }

 class B
 {
     synchronized void bar(A a)
     {
        String name=Thread.currentThread().getName();
        System.out.println(name + " entered B.bar");

        try
        {
            Thread.sleep(1000);
        }
        catch(Exception e)
        {
            System.out.println("B interrupted");
        }

        System.out.println(name +" trying to call A.last()");
        a.last();
     }

     synchronized void last()
     {
        System.out.println("Inside B.last");
     }
 }

 class C implements Runnable
 {
    A a=new A();
    B b=new B();
    Thread t;
    C()
    {
        Thread.currentThread().setName("Main thread");
        t=new Thread(this,"Racing thread");
    }
    void deadlockStart() {
        t.start();
        a.foo(b); // get lock on a in this thread.
        System.out.println("Back in main thread");
        }
        public void run() {
            b.bar(a); // get lock on b in other thread.
            System.out.println("Back in other thread");
            } 
            
      public static void main(String[] args)  
      {
           C c=new C();
           c.deadlockStart();
      }    
 }

  

