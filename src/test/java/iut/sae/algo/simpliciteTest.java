package iut.sae.algo;

import org.junit.Test;

import junit.framework.TestCase;

public class simpliciteTest extends TestCase{

    /*
   * RLE("")=""
   * RLE("abc")="1a1b1c"
   * RLE("abbccc")="1a2b3c"
   * RLE("aaabaa")="3a1b2a"
   * RLE("aAa")="1a1A1a"
   */

   @Test
   public void testRLE(){
      assertEquals("", simplicite.RLE("") );
      
      assertEquals("1a1b1c", simplicite.RLE("abc"));
      assertEquals("1a2b3c", simplicite.RLE("abbccc"));
      assertEquals("3a1b2a", simplicite.RLE("aaabaa"));
      assertEquals("1a1A1a", simplicite.RLE("aAa"));
      assertEquals("9W4W", simplicite.RLE("WWWWWWWWWWWWW"));
      

   }


   /*
   * RLE(str, 1)=RLE(str)
   * RLE(str, 3)=RLE(RLE(RLE(str)))
   */
   @Test
   public void testRLERecursif(){
      try{
         assertEquals("", simplicite.RLE("", 1));
         assertEquals("", simplicite.RLE("", 3));
         
         assertEquals("1a1b1c", simplicite.RLE("abc", 1));
         assertEquals("1a2b3c", simplicite.RLE("abbccc", 1));
         assertEquals("3a1b2a", simplicite.RLE("aaabaa", 1));
         assertEquals("1a1A1a", simplicite.RLE("aAa", 1));

         assertEquals("111a111b111c", (simplicite.RLE("abc", 2)));
         assertEquals("311a311b311c", (simplicite.RLE("abc", 3)));

         String saeIte20="1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211S1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211E1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211 1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211A1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211l1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211g1113122113121113222123211211131211121311121321123113213221121113122123211211131221121311121312211213211321322112311311222113311213212322211211131221131211221321123113213221121113122113121113222112131112131221121321131211132221121321132132211331121321232221123113112221131112311322311211131122211213211331121321122112133221121113122113121113222123112221221321132132211231131122211331121321232221121113122113121113222123113221231231121113213221231221132221222112112322211o";
         assertEquals(saeIte20, simplicite.RLE("SAE Algo", 20));
      }
      catch(Exception e){
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
   public void testUnRLE(){
      try{
         assertEquals("", simplicite.unRLE(""));
         assertEquals("abc", simplicite.unRLE("1a1b1c"));
         assertEquals("abbccc", simplicite.unRLE("1a2b3c"));
         assertEquals("aaabaa", simplicite.unRLE("3a1b2a"));
         assertEquals("aAa", simplicite.unRLE("1a1A1a"));
         assertEquals("WWWWWWWWWWWWW", simplicite.unRLE("9W4W"));
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }

   
   @Test
   public void testUnRLERecursif(){
      try{
         assertEquals("", simplicite.unRLE("", 1));
         assertEquals("", simplicite.unRLE("", 3));
         
         assertEquals("abc", simplicite.unRLE("1a1b1c", 1));
         assertEquals("abbccc", simplicite.unRLE("1a2b3c", 1));
         assertEquals("aaabaa", simplicite.unRLE("3a1b2a", 1));
         assertEquals("aAa", simplicite.unRLE("1a1A1a", 1));

         assertEquals("abc", (simplicite.unRLE("111a111b111c", 2)));
         assertEquals("abc", (simplicite.unRLE("311a311b311c", 3)));
      }
      catch(Exception e){
         fail("Exception inatendue");
      }
   }
    
}
