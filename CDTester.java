import static org.junit.Assert.*;

import org.junit.Test;
import static org.hamcrest.Matchers.*;

public class CDTester
{




   @Test
   public void testCD()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("Calling constructor makes an object", c, notNullValue());
   }


   @Test
   public void testGetCDTitle()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("Can get the same CD title", c.getCDTitle(), is(equalTo("T-Swizzle's Greatest Hits")));
   }
   
   @Test
   public void testToString()
   {
      
   }
   

   
   /**
    * These three tests insure that the superclass' toString works, it's a little
    * redundant, but helpful.
    */
   @Test
   public void testToStringProductID()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("toString contains productID", c.toString(), containsString("A423"));
   }
   
   @Test
   public void testToStringProductDesc()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("toString contains product Desc", c.toString(), 
         containsString("A cool CD"));
   }
   
   @Test
   public void testToStringProductPrice()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("toString contains product price, formatted to .2f", 
         c.toString(), containsString("13.37"));
   }
   

   @Test
   public void testToStringCDTitle()
   {
      CD c = new CD("A423", "A cool CD", 13.37, "T-Swizzle's Greatest Hits");
      assertThat("toString contains CD Title", c.toString(), 
         containsString("T-Swizzle's Greatest Hits"));
   }


}
