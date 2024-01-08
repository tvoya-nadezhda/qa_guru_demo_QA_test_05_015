package guru.qa;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
public class SimpleJUnitTest {
   @AfterAll

   @BeforeEach
   void BeforeEach()  {
      System.out.println("### @BeforeEach");
   }
   @Test
   void firstTest() {
      System.out.println("### @Test firstTest");
           Assertions.assertTrue(2>1);
   }
   @Test
   void secondTest() {
      System.out.println("### @Test secondTest");
      Assertions.assertTrue(3>2);
   }
}
