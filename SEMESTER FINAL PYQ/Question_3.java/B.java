/* To make computation faster use thread based process to compute C=AxB . Write a java 
 programme to find C using two thread.
*/

import java.util.Scanner;

class Multiplication extends Thread
{
    int [][] A;
    int [][] B;
    int [][] C;
    int startrow;
    int endrow;
    int resrow;
    int rescol;
    Multiplication(int [][] A,int [][] B, int [][]C, int startrow,int endrow)
    {
        this.A=A;
        this.B=B;
        this.C=C;
        this.startrow=startrow;
        this.endrow=endrow;
       
    }

    public void run()
    {
        for(int i=startrow;i<endrow;i++)
        {
            for(int j=0;j<B[0].length;j++)
            {
                C[i][j]=0;
                for(int k=0;k<A[0].length;k++)
                {
                    C[i][j]+=A[i][k]*B[k][j];
                }
            }
        }
    }

    
}

class B{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int r2=sc.nextInt();
        int c2=sc.nextInt();
        int [][]A=new int[r1][c1];
        int [][]B=new int [r2][c2];
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
            {
                A[i][j]=sc.nextInt();
            }
        }
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
            {
                B[i][j]=sc.nextInt();
            }
        }
        int [][] result=new int [r1][c2];

        int mid = r1 / 2;
        Multiplication thread1 = new Multiplication(A, B, result, 0, mid);
        Multiplication thread2 = new Multiplication(A, B, result, mid, r1);

        thread1.start();
        thread2.start();
        try
        {
            thread1.join();
            thread2.join();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        System.out.println("Resultant Matrix C:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }

    }
}






