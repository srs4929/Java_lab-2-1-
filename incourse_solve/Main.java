/*
 Let us consider, an array A is given having N elements. A contains only integers and
 1 based indexing.
 You need to find two indexes x and y such that if the broken segments (1 to x) ,
 (x to y) and (y to N) are rearranged in some order the array will become sorted.
 Write a complete java programme

 Example'
 A={4,5,6,1,2,3,7,8,9}
 x and y equal to 3 and 6
 */

 import java.util.Scanner;

 class Main{

    public static void main(String[] args)
    {
        int n;
        Scanner sc=new Scanner(System.in);
        n= sc.nextInt();
        sc.nextLine();
        int [] arr=new int[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();

        }
       int x=-1,y=-1;
       for(int i=0;i<n-1;i++)
       {
        if(Math.abs(arr[i]-arr[i+1])!=1)
        {
            x=i;
            break;
        }
       }
       for(int i=x+1;i<n-1;i++)
       { 
        if(Math.abs(arr[i]-arr[i+1])!=1)
        {
            y=i;
            break;
        }
        
       }

       if(x==-1 && y==-1) System.out.println("Not found");
       else System.out.println("x "+(x+1)+" y "+(y+1));

    }
 }

 //does not follow corner case like if the gap is more than 1 :")
