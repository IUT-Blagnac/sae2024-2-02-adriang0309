

import org.junit.Test;
import junit.framework.TestCase;

public class AlgoTest extends TestCase {

   /*
    * Test suppplementaires
    * Ce fichier comporte que les test supplementaires
    * Le main (calcule le temps d'éxecution d'une méthode)
    * Rajout des tests supplementaires dans les testsRle, etc....
    * Pour l'éxecuter utilisé le repertoire sae/algo/AlgoTest.java
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

   
   @Test
   public void testRLERecursif() {
      try {
         
         assertEquals("111C111A111B", (Algo.RLE("CAB", 2)));//Supplementaire
         
      } catch (Exception e) {
         fail("Exception inatendue");
      }
   }

   

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