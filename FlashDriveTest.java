import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

public class FlashDriveTest
{




   @Test
   public void testFlashDrive()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat(f, is(notNullValue()));
   }


   @Test
   public void testGetFlashDriveCapacity()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat("FlashDrive capacity getter works", f.getFlashDriveCapacity(), is(equalTo(2048)));
   }
   
   @Test
   public void testToStringProductID()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat("toString contains productID", f.toString(), containsString("FL4SH"));
   }
   
   @Test
   public void testToStringProductDesc()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat("toString contains product Desc", f.toString(), 
         containsString("A cool flash drive"));
   }
   
   @Test
   public void testToStringProductPrice()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat("toString contains product price, formatted to .2f", 
         f.toString(), containsString("13.37"));
   }
   
   @Test
   public void testToStringFlashDriveCapacity()
   {
      FlashDrive f = new FlashDrive("FL4SH", "A cool flash drive", 13.37, 2048);
      assertThat("toString contains flash drive capacity", 
         f.toString(), containsString("2048"));
   }


}
