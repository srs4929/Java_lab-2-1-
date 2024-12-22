/*In this problem, we will deal with a cricket team. A team member can be identified
with the following pieces of information: name (string data), quality (batsman,
bowler, all_rounder), and jersey number (integer).
a) We should have a class that would address associated members to solve this
problem (Mark 10).
b) We should have a function that adds a new player to the team with his
associated information (Mark 20).
c) We are going to construct teams for 7 days denoting, 7 team formations. We
should have a method that would take the day number (1st day, 2nd day, …)
and the player’s jersey number to include him/her in a particular day’s
formation. (Mark 30).
d) Finally, we should have another method that would take a parameter
denoting the day number on which we are going to print the information. In
the printing, we would expect to see all the players of that particular day’s
formation: their names, jersey numbers, and attributes. We would also expect
statistics denoting the total number of batsmen, bowlers, and all_rounders in
that particular day’s formation in a summarized manner (Mark 40).*/










package Cricket;
import java.util.Scanner;
//Team member info
class Team
{
    String name;
    String quality;
    int jersey;
    int []day= new int [7];
    Team(String name,String quality,int jersey)
    {
        this.name=name;
        this.quality=quality;
        this.jersey=jersey;
    }
}
//database
class Database
{
     Team [] t=new Team[15];
     int count=0;
     // Adding member
     void add(Team x)
     {
        if(count<t.length)
        {
            t[count]=x;
            count++;
        }
     }

     //constructing team

     void construct(int day,int jersey)
     { 
        for(int i=0;i<count;i++)
        {
            if(t[i].jersey==jersey)
            {
                t[i].day[day-1]=1;// marked 1 as added

            }
            else
            {
                System.out.println("Jersey number not found");
            }
           
        }
    }

    //display
    void display(int day)
    {
         int batsman=0;
         int bowler=0;
         int allrounder=0;
         
         System.out.println("Day "+ day+" Team formation: ");
         for(int i=0;i<count;i++)
         {
            if(t[i].day[day-1]==1)
            {
                System.out.println("Name : "+t[i].name+" Jersey : "+t[i].jersey+" Quality : "+t[i].quality);
                if(t[i].quality.equals("Batsman")) batsman++;
                else if(t[i].quality.equals("Bowler")) bowler++;
                else if(t[i].quality.equals("Allrounder") )allrounder++;
            }


         }
         System.out.println("\nSummary :");
         System.out.println("Total Batsman :"+batsman);
         System.out.println("Total Bowler :"+bowler);
         System.out.println("Total All-rounder: "+allrounder);

    }
     
}
public class Main {
    public static void main(String[] args){
      
        Database d=new Database();
        Scanner sc=new Scanner(System.in);
        System.out.println("How many query :");
        int choice=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<choice;i++)
        {
            System.out.println("\n Menu :");
            System.out.println("1.Add member ");
            System.out.println("2.Construct team based on the day");
            System.out.println("3.Display :");
            int op=sc.nextInt();
            sc.nextLine();
            if(op==1)
            {
                System.out.println("Enter player's name :");
                String name=sc.nextLine();
                System.out.println("Enter quality :");
                String quality=sc.nextLine();
                System.out.println("Enter player's jersey number :");
                int num=sc.nextInt();
                sc.nextLine();
                Team x=new Team(name,quality,num);
                d.add(x);
            }
            else if(op==2)
            {
                System.out.println("Enter players jersey number and the day that you want to add :");
                System.out.println("Jersey number :");
                int num=sc.nextInt();
                sc.nextLine();
                System.out.println("Day :");
                int day=sc.nextInt();
                sc.nextLine();
                d.construct(day,num);

            }
            else if(op==3)
            {
                System.out.println("The day you want to display :");
                int day=sc.nextInt();
                sc.nextLine();
                d.display(day);
            }
        }
        

        

    }
    
}
