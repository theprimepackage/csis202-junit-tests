package CSIS202JunitTests.Program7;

import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import com.foba.CSIS202.Program7.Employee;
import org.junit.Test;

/**
 * Daniel Rohwedder's Employee class tests. Using JUnit 4, and hamcrest 1.3
 * 
 * Can we stop using JUnit 5? It's a beta library, 4 and 3 are both tried and
 * tested.
 */
public class EmployeeTest
{
   /*
    * -------------------------------------------------------------------------
    * All of these tests are simple and self-explanatory - just like Person
    * -------------------------------------------------------------------------
    */

   @Test
   public void testEmployee()
   {
      Employee e = new Employee("John Doe", "555-555-5555",
            "employee@email.org", "EMPID: 16239D-5");
      assertThat("Check Constructor", e, is(notNullValue()));
   }


   @Test
   public void testGetEmployeeID()
   {
      Employee e = new Employee("John Doe", "555-555-5555",
            "employee@email.org", "EMPID: 16239D-5");
      assertThat("Get EmployeeID", e.getEmployeeID(),
            is(equalTo("EMPID: 16239D-5")));
   }


   @Test
   public void testSetEmployeeID()
   {
      Employee e = new Employee("John Doe", "555-555-5555",
            "employee@email.org", "EMPID: 16239D-5");
      e.setEmployeeID("c00lguy:)");
      assertThat("Set EmployeeID", e.getEmployeeID(), is(equalTo("c00lguy:)")));
   }


   @Test
   public void testToString()
   {
      Employee e = new Employee("John Doe", "555-555-5555",
            "employee@email.org", "EMPID: 16239D-5");
      assertThat("toString contains employeeID", e.toString(),
            containsString("EMPID: 16239D-5"));
   }

}
