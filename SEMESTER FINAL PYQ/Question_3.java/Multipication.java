/* You are have given two matrices. Find C= AxB */

import java.util.Scanner;

class Multipication
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        //first matrix
        int r1=sc.nextInt();
        int c1=sc.nextInt();
        int [][] mat1=new int[r1][c1];
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c1;j++)
            {
                mat1[i][j] =sc.nextInt();
            }
        }
        //second matrix 
        int r2=sc.nextInt();
        int c2=sc.nextInt();
        int [][] mat2=new int[r2][c2];
        for(int i=0;i<r2;i++)
        {
            for(int j=0;j<c2;j++)
            {
                mat2[i][j] =sc.nextInt();
            }
        }
        int [][] res=new int[r1][c2];
        if(c1!=r2) {System.out.println("Matrix not possible");
         return;}

        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c2;j++)
            {
                for(int k=0;k<c1;k++)
                {
                    res[i][j]+=mat1[i][k]*mat2[k][j];
                }
            }
        }

        System.out.println("The result :");
        for(int i=0;i<r1;i++)
        {
            for(int j=0;j<c2;j++)
            {
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }

    }
}