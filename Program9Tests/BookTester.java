package CSIS202JunitTests.Program9Tests;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.foba.CSIS202.Program8.Book;
import org.junit.Test;
public class BookTester
{


   /**
    * Another set of tests, this time for the Book class. Using same 
    * double-checking on the toString that I used on the CDTester 
    */

   @Test
   public void testBook()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat(b, is(notNullValue()));
   }


   @Test
   public void testGetBookTitle()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("Gets proper title", b.getBookTitle(), is(equalTo("Big Java, Early Objects")));
   }


   @Test
   public void testGetBookAuthor()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("Gets proper author", b.getBookAuthor(), is(equalTo("Horstman")));
   }
   
   
   @Test
   public void testToStringProductID()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("toString contains productID", b.toString(), containsString("C00L"));
   }
   
   @Test
   public void testToStringProductDesc()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("toString contains product Desc", b.toString(), 
         containsString("A book"));
   }
   
   @Test
   public void testToStringProductPrice()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("toString contains product price, formatted to .2f", 
         b.toString(), containsString("13.37"));
   }
   
   @Test
   public void testToStringBookTitle()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("toString contains book title", b.toString(), 
         containsString("Big Java, Early Objects"));
      
   }
   
   
   @Test
   public void testToStringBookAuthor()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects", "Horstman");
      assertThat("toString contains book author", b.toString(), 
         containsString("Horstman"));
      
   }
   


}
