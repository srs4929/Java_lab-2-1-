abstract class Book
{
     String title;
     String author;
     boolean available=true;

     abstract void getDetails();

     public void unavailable()
     {
        available=false;
     }
     public void makeavailable()
     {
        available=true;
     }
}
class PrintedBook extends Book{
 
   
    public void getDetails()
    {
        System.out.println("The printed book author is "+author);
        System.out.println("The title of the book is "+title);
        if(available)
        {
            System.out.println("The book is available");
        }
        else{
            System.out.println("The book is unavailable after taking");
        }
    }

}

class Ebook extends Book{
   
    public void getDetails()
    {
        System.out.println("The ebook book author is "+author);
        System.out.println("The title of the book is "+title);
        System.out.println("The book is digitalized copy");
    }


}

interface User
{
    void borrowBook(Book book);
    void returnBook(Book book);
    void getBorrowedBooks();
}

class Student implements User {
    Book[] b = new Book[30];
    int count = 0;

    public void borrowBook(Book book) {
        if (count <3) { 
            if (book.available) {
                System.out.println("The book "+book.title+" is available");
                b[count] = book;  
                book.unavailable(); 
                count++;  
                System.out.println("The book  "+book.title +" is added");
            } else {
                System.out.println("The book "+book.title+ " unavailable");
            }
        } else {
            System.out.println("You have exceeded the borrow limit.Sorry.");
        }
    }

    public void returnBook(Book book) {
        for (int i = 0; i < count; i++) {
            if (b[i].title.equals(book.title)) {
                System.out.println("The book  "+book.title+" is avilable");
                b[i].makeavailable(); 
                
                for (int j = i; j < count - 1; j++) {
                    b[j] = b[j + 1];
                }
                b[count - 1] = null;  
                count--;  
                
            }
        }
       
    }

    public void getBorrowedBooks() {
        
            for (int i = 0; i < count; i++) {
                System.out.println("Borrowed book:");
                b[i].getDetails();  
            }
        }
    }


     
class Faculty implements User{
  
    Book [] b=new Book[30];
    int count=0;
    public void borrowBook(Book book)
    {   
        if(count<10)
        {
        if(book.available)
         {
            System.out.println("The book  "+book.title+" is available");
            b[count]=book;
            book.unavailable();
            System.out.println("The book  " +book.title+ "is added");
            count++;
           
         }
        }
         else if(count>=10)
         {
            System.out.println("The borrow book is exceeded ten. Sorry");
         }
       
    }
     public void returnBook(Book book)
     {
          for(int i=0;i<count;i++)
          {
            if(b[i].title.equals(book.title))
            {
              System.out.println("The book is returned successfully");
              b[i].makeavailable();

              for(int j=i;j<count-1;j++)
              {
                 b[j]=b[j+1];

              }
              b[count-1]=null;
              count--;
              
            }
          }
     }
     public void getBorrowedBooks()
     {
        for(int i=0;i<count;i++)
        {
            System.out.println("The  borrowed books are :");
            b[i].getDetails();

        }
            
        
     }
}








public class Roll_07 {

public static void main(String[] args)
{
     PrintedBook p=new PrintedBook();
     p.title="The sky";
     p.author="Mr.David";

     PrintedBook p1=new PrintedBook();
     p1.title="The rabbit";
     p1.author="Mr.Hulk";
     PrintedBook p2=new PrintedBook();
     p2.title="Food is good";
     p2.author="Mr. System";
     PrintedBook p3=new PrintedBook();
     p3.title="I am alone";
     p3.author="Mr.x";
     Student s=new Student();
     s.borrowBook(p);
     s.borrowBook(p1);
     s.borrowBook(p2);
     s.borrowBook(p3);
     s.returnBook(p1);
     s.borrowBook(p2);
     s.getBorrowedBooks();
     Ebook e1=new Ebook();
     e1.title="Hello Bangladesh";
     e1.author="Mr.y";
     Faculty f=new Faculty();
     f.borrowBook(e1);
     f.getBorrowedBooks();

}

}