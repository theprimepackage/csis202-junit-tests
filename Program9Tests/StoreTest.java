package CSIS202JunitTests.Program9Tests;

import com.foba.CSIS202.Program8.Store;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import static org.junit.Assert.*;


public class StoreTest {

    @Test
    public void loadStore() throws Exception
    {
        Store store = new Store();
    }

    @Disabled
    @Test
    public void processOrder() throws Exception
    {

    }

    @Disabled
    @Test
    public void processReturn() throws Exception
    {

    }

    //TODO: Add test for faulty files
    //TODO: Add tests for products that do not have an associating class
}