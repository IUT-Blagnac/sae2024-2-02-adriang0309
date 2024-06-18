

import org.junit.Test;
import junit.framework.TestCase;

public class AlgoTest extends TestCase {

   /*
    * Test suppplementaires
    * Le main (calcule le temps d'éxecution d'une méthode)
    * Rajout des tests supplementaires dans les testsRle, etc....
    * Pour l'éxecuter utilisé le repertoire sae/algo/AlgoTest.java
    */

   /*
    * RLE("")=""
    * RLE("abc")="1a1b1c"
    * RLE("abbccc")="1a2b3c"
    * RLE("aaabaa")="3a1b2a"
    * RLE("aAa")="1a1A1a"
    */

    //Supplementaire
   public static void main(String[] args) throws AlgoException {
      long startTime;
      long endTime;
      startTime = System.currentTimeMillis();
      System.out.println("--------------------------------------");
      System.out.println(Algo.RLE("abc", 2));
      endTime = System.currentTimeMillis();
      System.out.println("Temps d'exécution : " + (endTime - startTime) + " millisecondes");
   }

   @Test
   public void testRLE() {
      
      assertEquals("9W4W1A1a3b9B1B", Algo.RLE("WWWWWWWWWWWWWAabbbBBBBBBBBBB"));//Supplementaire

   }

   /*
    * RLE(str, 1)=RLE(str)
    * RLE(str, 3)=RLE(RLE(RLE(str)))
    */
   @Test
   public void testRLERecursif() {
      try {
         
         assertEquals("111C111A111B", (Algo.RLE("CAB", 2)));//Supplementaire
         
      } catch (Exception e) {
         fail("Exception inatendue");
      }
   }

   /*
    * unRLE(RLE(str))=str
    *
    * unRLE("")=""
    * unRLE("1a1b1c")="abc"
    * unRLE("1a2b3c")="abbccc"
    * unRLE("3a1b2a")="aaabaa"
    * unRLE("1a1A1a")="aAa"
    */

   @Test
   public void testUnRLE() {
      try {
       
         assertEquals("WWWWWWWWWWWWWAabbbBBBBBBBBBB", Algo.unRLE("9W4W1A1a3b9B1B"));//Supplementaire

      } catch (Exception e) {
         fail("Exception inatendue");
      }
   }

   @Test
   public void testUnRLERecursif() {
      try {
         
         assertEquals("CAB", (Algo.unRLE("111C111A111B", 2)));//Supplementaire
   

      } catch (Exception e) {
         fail("Exception inatendue");
      }
   }

}