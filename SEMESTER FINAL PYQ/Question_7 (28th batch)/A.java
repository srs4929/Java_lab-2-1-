/*  (a) You are given a string S. You need to implement the following functions by incorporating them within a class to manipulate S based on Java-supported syntax.
     i.void putFront(char a): Will put a character a at the beginning of S
    ii.void putBehind(char a): Will put a character a at the end of the S 
    ii.void pop(int idx): Will remove the character from the Idx position of S*/

    import java.util.Scanner;

    class Result
    {
        String s;
        Result(String x)
        {
            this.s=x;
        }

        void putFront(char a)
        {
            s=a+s;
        }
        void putBehind(char a)
        {
            s=s+a;
        }

        void pop(int ind)
        {    
            String temp="";
            for(int i=0;i<s.length();i++)
            {
                if(i!=ind)
                {
                     temp+=s.charAt(i);
                }
            }
            s=temp;
        }
    }

    public class A{
       
        public static void main(String[] args)
        {
            Scanner sc=new Scanner(System.in);
            String s=sc.nextLine();
            Result a=new Result(s);
            char x=sc.next().charAt(0);
            a.putFront(x);
            System.out.println(a.s);//to print the modify string a.s
            a.putBehind(x);
            //behind
            System.out.println(a.s);
            int ind=sc.nextInt();
            a.pop(ind);
            System.out.println(a.s);

        }
    }
