package CSIS202JunitTests.Program9Tests;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import com.foba.CSIS202.Program8.Book;
import com.foba.CSIS202.Program8.CD;
import com.foba.CSIS202.Program8.FlashDrive;
import com.foba.CSIS202.Program8.Inventory;
import com.foba.CSIS202.Program8.InventoryLineItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class InventoryTest {

    private static final String CD_PRODUCT_ID = "CD_000";
    private static final int SUCCESS = 0;
    private static final String FD_PRODUCT_ID = "FD_000";
    private static final int NOT_IN_STOCK = -1;
    private static final String BOOK_PRODUCT_ID = "BOOK_000";
    private FlashDrive flashDrive;
    private CD cd;
    private Book book;
    private Inventory inventory, inventoryList;
    InventoryLineItem[] listInventoryLineItems = {
            new InventoryLineItem(new Book( "BOOK_000", "A murder mystery", 14.98, "Buying the Bangkok Girl", "Phil Smith"), 9),
            new InventoryLineItem(new Book("BOOK_001", "Great book by even greater author", 9.99, "Garden City", "John Mark"), 80),
            new InventoryLineItem(new Book( "BOOK_002", "Psychology", 11.99, "The Paradox of Choice", "Barry Schwartz"), 32),
            new InventoryLineItem(new Book( "BOOK_003", "Math, Science, Logic", 13.35, "The Outer Limits of Reason", "N.S. Yanofsky"), 17)
    };

    @Before
    public void setUp()
    {
        flashDrive = new FlashDrive("FD_000", "A flash drive", 69.99, 16384);
        cd = new CD("CD_000", "Studio album by TobyMac", 19.95, "Momentum");
        book = new Book("BOOK_000", "A murder mystery", 14.98, "Buying the Bangkok Girl", "Phil Smith");
        inventory = new Inventory();
        inventory.restock(flashDrive, 26);
        inventory.restock(cd, 37);
        inventory.restock(book,19);
        inventoryList = new Inventory();
        inventoryList.restock(new FlashDrive("FD_000", "A flash drive", 69.99, 16384), 21);
        inventoryList.restock(new FlashDrive("FD_001", "A flash drive", 69.99, 4096), 6);
        inventoryList.restock(new FlashDrive("FD_002", "A flash drive", 69.99, 2048), 13);
        inventoryList.restock(new FlashDrive("FD_003", "A flash drive", 69.99, 1024), 19);
        inventoryList.restock(new CD("CD_000", "Studio album by TobyMac", 19.95, "Momentum"), 45);
        inventoryList.restock(new Book("BOOK_000", "A murder mystery", 14.98, "Buying the Bangkok Girl", "Phil Smith"), 9);
        inventoryList.restock(new Book("BOOK_001", "Great book by even greater author", 9.99, "Garden City", "John Mark"), 80);
        inventoryList.restock(new Book("BOOK_002", "Psychology", 11.99, "The Paradox of Choice", "Barry Schwartz"), 32);
        inventoryList.restock(new Book("BOOK_003", "Math, Science, Logic", 13.35, "The Outer Limits of Reason", "N.S. Yanofsky"), 17);

    }

    @Test
    public void findInventoryItemTestReturnsObject()
    {
        assertNotNull(inventory.findInventoryItem(CD_PRODUCT_ID));
    }

    @Test
    public void restockTest()
    {
        assertThat(inventory.getQtyInStock(flashDrive.getProductID()), is(equalTo(26)));
    }

    @Test
    public void restockTestNegVal()
    {
        Inventory inventoryNeg = new Inventory();
        inventoryNeg.restock(flashDrive,20);
        inventoryNeg.restock(flashDrive,-20);
        inventoryNeg.restock(book,-9);

        assertThat(inventoryNeg.findInventoryItem(FD_PRODUCT_ID).getLineItemQty(), is(equalTo(20)));
        assertNull(inventoryNeg.findInventoryItem(BOOK_PRODUCT_ID));
    }

    @Test
    public void pickTestSuccessfulPick(){
        inventory.restock(book,19);
        assertThat(inventory.pick(FD_PRODUCT_ID,20),is(equalTo(SUCCESS)));
    }

    @Test
    public void pickTestNotInStockPick(){
        Inventory inventory1 = new Inventory();
        inventory1.restock(book,0);
        assertThat(inventory1.pick(FD_PRODUCT_ID,20),is(equalTo(NOT_IN_STOCK)));
        assertThat(inventory1.pick(BOOK_PRODUCT_ID,20),is(equalTo(NOT_IN_STOCK)));
    }

    @Test
    public void pickTestMoreThanAvailable() {
        assertThat(inventory.pick(FD_PRODUCT_ID, 30), is(equalTo(26)));
    }


    @Test
    public void getInventoryValueTest()
    {
        assertThat(inventory.getInventoryValue(), is(closeTo(2842.51,1e-6)));
    }
/*
    A work in progress.....
    @Test
    public void getInventoryListingTest()
    {
        assertThat(listInventoryLineItems, contains(inventoryList.getInventoryListing("BOOK")));
    }
*/

}