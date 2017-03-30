package CSIS202JunitTests.Program8.Lydia;

// ltaw16@georgefox.edu
public class Book extends Product
{
   private String _bookTitle;
   private String _bookAuthor;
   
   public Book(String id, String desc, double price, String title, String author)
   {
      super(id, desc, price);
      _bookTitle = title;
      _bookAuthor = author;
   }
   public String getBookTitle()
   {
      return _bookTitle;
   }
   public String getBookAuthor()
   {
      return _bookAuthor;
   }
   @Override
   public String toString()
   {
      return "Book [_bookTitle=" + _bookTitle + ", _bookAuthor=" + _bookAuthor
            + "]";
   }

}
