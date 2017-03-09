import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 * My cool JUnit Tests for the Product superclass!
 * Uses JUnit 4 and Hamcrest 1.3
 * Self-explanitory tests, some "documentation" is in the titles of tests
 * and in the strings inside the assertions
 *
 */
public class ProductTester
{

   @Test
   public void testProduct()
   {
      Product p = new Product("IdFoo", "It's a foo", 13.37);
      assertThat("Product constructor generates something", p, is(notNullValue()));
   }


   @Test
   public void testGetProductID()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);
      assertThat("Gets the right ID", p.getProductID(), is(equalTo("Idee")));
      
   }


   @Test
   public void testGetProductDesc()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);

      assertThat("Gets the right description", p.getProductDesc(), is(equalTo("Description goes here")));
   }


   @Test
   public void testGetProductPrice()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);
      assertThat("Gets roughly the right price", 
         p.getProductPrice(), is(closeTo(13.37, 1.0E-6)));
   }


   @Test
   public void testToStringProductID()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);
      assertThat("toString contains productID", p.toString(), containsString("Idee"));
   }
   
   @Test
   public void testToStringProductDesc()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);
      assertThat("toString contains product Desc", p.toString(), 
         containsString("Description goes here"));
   }
   
   @Test
   public void testToStringProductPrice()
   {
      Product p = new Product("Idee", "Description goes here", 13.37);
      assertThat("toString contains product price, formatted to .2f", 
         p.toString(), containsString("13.37"));
   }

}
