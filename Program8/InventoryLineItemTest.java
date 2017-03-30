package CSIS202JunitTests.Program8;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;


import CSIS202JunitTests.Program8.Lydia.Book;
import CSIS202JunitTests.Program8.Lydia.InventoryLineItem;
import CSIS202JunitTests.Program8.Lydia.Product;

import org.junit.Test;

public class InventoryLineItemTest
{


   /*
    * Daniel Rohwedder's InventoryLineItem unit tests.
    * Using JUnit4 and Hamcrest1.3
    */
   
   @Test
   public void testInventoryLineItem()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 32);
      assertThat("Ensure that the constructor makes an object", i,
         is(notNullValue()));
   }


   /*--------------------------------------------------------------------------
    * Test setting and getting the discount rates all at once.
    * Using these discount brackets:
    * 0-9 lineItemQty: 0.0
    * 10-24 lineItemQty: .10
    * 25-49 lineItemQty: .20
    * 50+ _lineItemQty: .25
    *--------------------------------------------------------------------------
    */
   @Test
   public void testSetLineItemDiscountRate1()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 1);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is 0.0 in the range of 0-9 (Lower Limit)",
         i.getLineItemDiscountRate(), is(closeTo(0.0, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate5()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 5);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is 0.0 in the range of 0-9 (Middle)",
         i.getLineItemDiscountRate(), is(closeTo(0.0, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate9()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 9);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is 0.0 in the range of 0-9 (Upper Limit)",
         i.getLineItemDiscountRate(), is(closeTo(0.0, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate10()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 10);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .10 in the range of 10-24 (Lower Limit)",
         i.getLineItemDiscountRate(), is(closeTo(.10, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate17()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 17);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .10 in the range of 10-24 (Middle)",
         i.getLineItemDiscountRate(), is(closeTo(.10, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate24()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 24);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .10 in the range of 10-24 (Upper limit)",
         i.getLineItemDiscountRate(), is(closeTo(.10, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate25()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 25);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .20 in the range of 25-49 (Lower Limit)",
         i.getLineItemDiscountRate(), is(closeTo(.20, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate32()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 32);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .20 in the range of 25-49 (Middle)",
         i.getLineItemDiscountRate(), is(closeTo(.20, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate49()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 49);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .20 in the range of 25-49 (Upper Limit)",
         i.getLineItemDiscountRate(), is(closeTo(.20, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate50()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 50);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .20 in the range of 50+ (Lower Limit)",
         i.getLineItemDiscountRate(), is(closeTo(.25, 1.0E-6)));
   }


   @Test
   public void testSetLineItemDiscountRate250()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      i.setLineItemDiscountRate();
      assertThat(
         "Ensure that the discount rate is .20 in the range of 50+ (Out there)",
         i.getLineItemDiscountRate(), is(closeTo(.25, 1.0E-6)));
   }


   /**
    *--------------------------------------------------------------------------
    * Testing how the lineItemSubtotal changes, these tests WILL fail if you
    * failed the discount rate tests.
    *--------------------------------------------------------------------------
    */
   @Test
   public void testSetLineItemSubtotal1()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 1);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 0-9 range. (lower limit)",
         i.getLineItemSubtotal(), is(closeTo((13.37), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal5()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 5);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 0-9 range. (middle)",
         i.getLineItemSubtotal(), is(closeTo((66.85), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal9()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 9);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 0-9 range. (upper limit)",
         i.getLineItemSubtotal(), is(closeTo((120.33), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal10()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 10);
      i.setLineItemDiscountRate();
      assertThat(
         "The subtotal works properly in the 10-24 range. (lower limit)",
         i.getLineItemSubtotal(), is(closeTo((120.33), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal17()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 17);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 10-24 range. (Middle)",
         i.getLineItemSubtotal(), is(closeTo((204.561), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal24()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 24);
      i.setLineItemDiscountRate();
      assertThat(
         "The subtotal works properly in the 10-24 range. (upper limit)",
         i.getLineItemSubtotal(), is(closeTo((288.792), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal25()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 25);
      i.setLineItemDiscountRate();
      assertThat(
         "The subtotal works properly in the 25-49 range. (lower limit)",
         i.getLineItemSubtotal(), is(closeTo((267.4), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal32()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 32);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 25-49 range. (middle)",
         i.getLineItemSubtotal(), is(closeTo((342.272), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal49()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 49);
      i.setLineItemDiscountRate();
      assertThat(
         "The subtotal works properly in the 25-49 range. (upper limit)",
         i.getLineItemSubtotal(), is(closeTo((524.10400), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal50()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 50);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 50+ range. (lower limit)",
         i.getLineItemSubtotal(), is(closeTo((501.375), 1.0E-6)));
   }


   @Test
   public void testSetLineItemSubtotal250()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      i.setLineItemDiscountRate();
      assertThat("The subtotal works properly in the 50+ range. (out there)",
         i.getLineItemSubtotal(), is(closeTo((2506.875), 1.0E-6)));
   }

   /*--------------------------------------------------------------------------
    * Basic getter tests, nothing too crazy. The getLineItemNum test may not
    * work the first time, adjust it to use the right number as needed.
    *--------------------------------------------------------------------------
    */
   
   
   /**
    * There are 18 instances of InventoryLineItem before this test, and so
    * that's why it acts the way it does
    */
   @Test
   public void testGetLineItemNum()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 49);
      assertThat(i.getLineItemNum(), is(equalTo(18)));
   }


   
   @Test
   public void testGetProduct()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      assertThat("Gets the right product", i.getProduct(),
         is(instanceOf(Product.class)));
   }


   @Test
   public void testGetLineItemQty()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      assertThat("Gets the right line item quantity", i.getLineItemQty(),
         is(equalTo(250)));
   }

   
   
   /*--------------------------------------------------------------------------
    * toString Tests, assumes that the toString contains the product's toString,
    * the quantity of the product in the InventoryLineItem, the discount rate,
    * and the subtotal-all formatted to .2f.
    *--------------------------------------------------------------------------
    */

   @Test
   public void testToStringContainsProductToString()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      assertThat("toString contains the product toString", i.toString(),
         containsString(b.toString()));
   }


   @Test
   public void testToStringContainsLineItemQty()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 250);
      assertThat("toString contains line item quantity", i.toString(),
         containsString("250"));
   }


   @Test
   public void testToStringContainsDiscountRate()
   {
      Book b = new Book("C00L", "A book", 13.37, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 51);
      assertThat("toString contains discount rate", i.toString(),
         containsString("25.00"));
   }


   @Test
   public void testToStringContainsSubtotal()
   {
      Book b = new Book("C00L", "A book", 1.25, "Big Java, Early Objects",
         "Horstman");
      InventoryLineItem i = new InventoryLineItem(b, 1);
      assertThat("toString contains subtotal", i.toString(),
         containsString("1.25"));
   }

}
