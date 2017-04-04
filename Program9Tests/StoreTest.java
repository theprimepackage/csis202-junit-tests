package CSIS202JunitTests.Program9Tests;

import com.foba.CSIS202.Program8.Store;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Disabled;

import java.io.File;
import java.net.URL;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class StoreTest {


    private static Store store;

    @Before
    public void setUp()
    {

        store = new Store();

    }

    @Disabled
    @Test
    public void loadStore()
    {
        File file = new File(getClass().getResource("file.txt").getPath());
        store.loadStore(file.getPath());
    }

    @Test
    public void processOrder()
    {

    }

    @Disabled
    @Test
    public void processReturn()
    {

    }

    //TODO: Add test for faulty files
    //TODO: Add tests for products that do not have an associating class
}