import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.Test;

public class PersonTest
{

   /**
    * Daniel Rohwedder's Person class tests. Using JUnit 4, and hamcrest 1.3
    * 
    * Can we stop using JUnit 5? It's a beta library, 4 and 3 are both tried and
    * tested.
    */

   // Test the constructor, ensure it makes something!
   @Test
   public void testPerson()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("Constructor", p, notNullValue());
   }


   /*
    * -------------------------------------------------------------------------
    * All of these tests are simple and self-explanatory
    * -------------------------------------------------------------------------
    */
   @Test
   public void testGetName()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("Get Name", p.getName(), is(equalTo("John Doe")));
   }


   @Test
   public void testGetPhone()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("Get Phone", p.getPhone(), is(equalTo("555-555-5555")));
   }


   @Test
   public void testGetEmail()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("Get Email", p.getEmail(), is(equalTo("jdoe@email.org")));
   }


   @Test
   public void testSetName()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      p.setName("CoolBeans");
      assertThat("Set Name", p.getName(), is(equalTo("CoolBeans")));
   }


   @Test
   public void testSetPhone()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      p.setPhone("1337");
      assertThat("Set Phone", p.getPhone(), is(equalTo("1337")));
   }


   @Test
   public void testSetEmail()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      p.setEmail("CoolGuy@email.cool");
      assertThat("Set Email", p.getEmail(), is(equalTo("CoolGuy@email.cool")));
   }


   /**
    * -------------------------------------------------------------------------
    * --------------------NEW HAMCREST METHOD AHEAD-----------------------------
    * -------------------------------------------------------------------------
    *  The containsString method searches the text for that particular string
    *  It's simple, but it's also a very helpful matcher to use, put it in your
    *  toolbox!
    * 
    */
   @Test
   public void testToStringName()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("toString contains Name", p.toString(),
            containsString("John Doe"));
   }


   @Test
   public void testToStringPhone()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("toString Contains Phone Number", p.toString(),
            containsString("555-555-5555"));
   }


   @Test
   public void testToStringEmail()
   {
      Person p = new Person("John Doe", "555-555-5555", "jdoe@email.org");
      assertThat("toString Contains Email", p.toString(),
            containsString("jdoe@email.org"));
   }

}
