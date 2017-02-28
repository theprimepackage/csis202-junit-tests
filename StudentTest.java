import static org.junit.Assert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import org.junit.Test;

/**
 * Daniel Rohwedder's Student class tests. Using JUnit 4, and hamcrest 1.3
 * 
 * Can we stop using JUnit 5? It's a beta library, 4 and 3 are both tried and
 * tested.
 */
public class StudentTest
{

   /*
    * -------------------------------------------------------------------------
    * All of these tests are simple and self-explanatory - just like Person
    * -------------------------------------------------------------------------
    */
   @Test
   public void testStudent()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      assertThat("Constructor makes an object", s, is(notNullValue()));
   }


   @Test
   public void testGetMajor()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      assertThat("Get Major", s.getMajor(), is(equalTo("Computer Science")));
   }


   @Test
   public void testGetGPA()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      assertThat("Get GPA", s.getGPA(), closeTo(3.5, 1.0E-6));
   }


   @Test
   public void testSetMajor()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      s.setMajor("Underwater Basket-Weaving");
      assertThat("Set Major", s.getMajor(),
            is(equalTo("Underwater Basket-Weaving")));
   }


   @Test
   public void testSetGPA()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      s.setGPA(1.3);
      assertThat("Set GPA", s.getGPA(), is(closeTo(1.3, 1.0E-10)));
   }


   @Test
   public void testToStringMajor()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      assertThat("toString contains major", s.toString(),
            containsString("Computer Science"));
   }


   @Test
   public void testToStringGPA()
   {
      Student s = new Student("John Smith", "555-555-5555", "jsmith@gfu.edu",
            "Computer Science", 3.5);
      assertThat("toString contains GPA", s.toString(), containsString("3.5"));
   }

}
