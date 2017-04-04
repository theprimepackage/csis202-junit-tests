package CSIS202JunitTests.Program9Tests;

import static org.junit.Assert.*;

import com.foba.CSIS202.Program8.Inventory;
import com.foba.CSIS202.Program8.InventoryLineItem;
import com.foba.CSIS202.Program8.Product;
import org.junit.Before;
import static org.hamcrest.Matchers.*;
import org.junit.Test;


/**
 * Sick unit tests by Daniel Rohwedder
 * I have 100% code coverage on my Inventory class, but if you can think
 * of any fringe cases that aren't covered, please fix them!
 * Send a message about any of these tests if you don't understand what
 * they're testing for, some of them have several nested method calls, so
 * that can be annoying to trace through, but it's pretty nice.
 * @author drohwedder16@georgefox.edu
 *
 */
public class InventoryTest
{
   private static final String GREEN_WIDGET_ID = "WID_G";
   private static final String RED_WIDGET_ID = "WID_R";
   private static final String YELLOW_WIDGET_ID = "WID_Y";
   private static final String GREEN_WIDGET_DESC = "Widget in the green variety";
   private static final String RED_WIDGET_DESC = "Widget in the red variety";
   private static final String YELLOW_WIDGET_DESC = "Widget in the yellow variety";
   private static final double GREEN_WIDGET_PRICE = 0.99;
   private static final double RED_WIDGET_PRICE = 1.00;
   private static final double YELLOW_WIDGET_PRICE = 1.01;
   private static final int GREEN_WIDGET_STOCK = 5;
   private static final int RED_WIDGET_STOCK = 10;
   private static final int YELLOW_WIDGET_STOCK = 15;
   private Inventory testInventory;
   private Product greenWidget;
   private Product redWidget;
   private Product yellowWidget;
   
   
   @Before
   public void setUp()
   {
      testInventory = new Inventory();
      greenWidget = new Product(GREEN_WIDGET_ID, GREEN_WIDGET_DESC, GREEN_WIDGET_PRICE);
      redWidget  = new Product(RED_WIDGET_ID, RED_WIDGET_DESC, RED_WIDGET_PRICE);
      yellowWidget = new Product(YELLOW_WIDGET_ID, YELLOW_WIDGET_DESC, YELLOW_WIDGET_PRICE);
      testInventory.restock(greenWidget, GREEN_WIDGET_STOCK);
      testInventory.restock(redWidget,  RED_WIDGET_STOCK);
      testInventory.restock(yellowWidget, YELLOW_WIDGET_STOCK);
   }
   
   
   @Test
   public void testInventory()
   {
      assertThat(testInventory, is(notNullValue()));
   }


   @Test
   public void testFindInventoryItem()
   {
      assertThat(testInventory.findInventoryItem(redWidget.getProductID()).getProduct().getProductDesc(), 
         is(equalTo(RED_WIDGET_DESC)));
   }


   @Test
   public void testPickCorrect()
   {
      assertThat(testInventory.pick(redWidget.getProductID(), 1), is(equalTo(0)));
   }
   

   @Test
   public void testPickItemNotInInventory()
   {
      assertThat(testInventory.pick("foo", 1), is(equalTo(-1)));
   }
   
   @Test
   public void testPickNotEnoughItems()
   {
      assertThat(testInventory.pick(greenWidget.getProductID(), GREEN_WIDGET_STOCK + 1), 
         is(equalTo(GREEN_WIDGET_STOCK)));
   }
   
   
   @Test
   public void testPickChangesQtyInStock()
   {
      int expectedQtyOfGreenWidget = testInventory.getQtyInStock(greenWidget.getProductID()) - 1;
      testInventory.pick(greenWidget.getProductID(), 1);
      assertThat(testInventory.getQtyInStock(greenWidget.getProductID()), 
         is(equalTo(expectedQtyOfGreenWidget)));
   }

   @Test
   public void testRestockAddsItem()
   {
      int qtyOfNewItem = 7;
      Product newItem = new Product("N0TH1NG", "Cool", 13.37);
      testInventory.restock(newItem, qtyOfNewItem);
      assertThat(testInventory.getQtyInStock(newItem.getProductID()), is(equalTo(qtyOfNewItem)));
   }

   @Test
   public void testRestockAddsToCurrentStock()
   {
      Product additionItem = new Product("ADD_001", "An item that adds to itself", 19.99);
      testInventory.restock(additionItem, 1);
      testInventory.restock(additionItem, 20);
      assertThat(testInventory.getQtyInStock(additionItem.getProductID()), is(equalTo(21)));
   }

   @Test
   public void testRestockIgnoresNegQty()
   {
       testInventory.restock(new Product("NEG_001", "Not valid", 0.00), -1);
       int greenWidgetQty = testInventory.getQtyInStock(GREEN_WIDGET_ID);
       testInventory.restock(greenWidget,-20);
       assertNull(testInventory.findInventoryItem("NEG_001"));
       assertThat(testInventory.getQtyInStock(GREEN_WIDGET_ID), is(equalTo(greenWidgetQty)));
   }


   @Test
   public void testGetQtyInStock()
   {
      assertThat(testInventory.getQtyInStock(yellowWidget.getProductID()), is(equalTo(YELLOW_WIDGET_STOCK)));
   }


   @Test
   public void testGetInventoryValue()
   {
      Inventory totalValue = new Inventory();
      totalValue.restock(redWidget, 3);
      assertThat(totalValue.getInventoryValue(), is(closeTo(3.0, 1E-15)));
   }


   @Test
   public void testInventoryListing()
   {
      InventoryLineItem[] widgets = new InventoryLineItem[3];
      widgets = testInventory.getInventoryListing("WID");
      assertThat(widgets, arrayContainingInAnyOrder(
         testInventory.findInventoryItem(GREEN_WIDGET_ID), 
         testInventory.findInventoryItem(RED_WIDGET_ID), 
         testInventory.findInventoryItem(YELLOW_WIDGET_ID)));
   }
   
   @Test
   public void testInventoryListingBadItem()
   {
      InventoryLineItem[] shouldBeNull = testInventory.getInventoryListing("HELLO");
      assertThat(shouldBeNull, is(emptyArray()));
   }

}
