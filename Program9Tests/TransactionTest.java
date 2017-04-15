import org.junit.Before;
import org.junit.Test;
import java.io.File;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;


public class TransactionTest
{

   private Transaction transac;
   private static final String TRANSACTION = "CD_001, 5";
   private static final boolean IS_RETURN = false;
   private static File file;

   @Before
   public void setUp()
   {
      file = new File(getClass().getResource("transaction_tests.txt").getPath());
      transac = new Transaction(TRANSACTION, IS_RETURN);
   }
   @Test
   public void testTransaction()
   {
      assertThat(transac, is(notNullValue()));
   }


   @Test
   public void testGetTransaction()
   {
      assertThat(transac.getTransaction(), containsString(TRANSACTION));
      
   }


   @Test
   public void testIsReturn()
   {
      assertThat(transac.isReturn(), is(equalTo(IS_RETURN)));
   }


   @Test
   public void testLoadTransactionsCanLoad()
   {
      Transaction[] transactions = Transaction.loadTransactions(file.getPath());
      assertThat(transactions.length, is(equalTo(4)));
   }
   
   @Test
   public void testLoadTransactionsProperisReturn()
   {
      Transaction[] transactions = Transaction.loadTransactions(file.getPath());
      assertThat(transactions[0].isReturn(), is(equalTo(false)));
      assertThat(transactions[1].isReturn(), is(equalTo(true)));
      assertThat(transactions[2].isReturn(), is(equalTo(false)));
      assertThat(transactions[3].isReturn(), is(equalTo(true)));
   }

}
