package busManagement;

import static org.junit.Assert.*;

import org.junit.Test;

public class stringSearchTest {
	

	@Test
	  public void testEmpty()
	  {
	    assertEquals("Empty text or pattern is invalid", -1, stringSearch.findCommon("",""));
	    assertEquals("Empty text or pattern is invalid", 0, stringSearch.findAllCommon("",""));
	    assertFalse("Empty text or pattern is invalid", stringSearch.fits("",""));
	  }
	  

	  
	  @Test
	  public void testSearchFirst()
	  {
		  assertEquals(0, stringSearch.findCommon("JKLJKLJKLJKL","JKL"));
		  assertEquals(0, stringSearch.findCommon("JKLJKLJKLJKL","J"));
		  assertEquals(2, stringSearch.findCommon("JKLJKLJKLJKL","L"));
		  assertEquals(0, stringSearch.findCommon("JKLJKLJKLJKL","JKLJKLJKLJKL"));
	  }
	  
	  @Test
	  public void testStringContains()
	  {
		  assertFalse(stringSearch.fits("JKLMNO","ABC"));
		  assertTrue(stringSearch.fits("JKLMNO", "JKL"));
		  assertTrue(stringSearch.fits("JKLMNO","KLM"));
		  assertTrue(stringSearch.fits("JKLMNO","LMN"));
		  assertTrue(stringSearch.fits("JKLMNO","MNO"));
		  assertTrue(stringSearch.fits("JKLMNO","J"));
		  assertTrue(stringSearch.fits("JKLMNO","O"));
		  assertTrue(stringSearch.fits("JKLMNO","JKLMNO"));
		  
	  }
	  
	  @Test
	  public void testSearchAll()
	  {
		  assertEquals(4, stringSearch.findAllCommon("JKLJKLJKLJKL","JKL"));
		  assertEquals(2, stringSearch.findAllCommon("JKLJKLJKLJKL","JKLJ"));
		  assertEquals(1, stringSearch.findAllCommon("JKLJKLJKLJKL","JKLJKLJKLJKL"));
		  assertEquals(2, stringSearch.findAllCommon("JKLJKLJKLJKL","KLJK"));
		  assertEquals(3, stringSearch.findAllCommon("JKLJKLJKLJKL","LJK"));
		  
	  }
	  /*
	@Test
	  public void testEmpty()
	  {
	    assertEquals("Empty text or pattern is invalid", -1, stringSearch.searchFirst("",""));
	    assertEquals("Empty text or pattern is invalid", 0, stringSearch.searchAll("",""));
	    assertFalse("Empty text or pattern is invalid", stringSearch.contains("",""));
	  }
	  

	  
	  @Test
	  public void testSearchFirst()
	  {
		  assertEquals(0, stringSearch.searchFirst("JKLJKLJKLJKL","JKL"));
		  assertEquals(0, stringSearch.searchFirst("JKLJKLJKLJKL","J"));
		  assertEquals(2, stringSearch.searchFirst("JKLJKLJKLJKL","L"));
		  assertEquals(0, stringSearch.searchFirst("JKLJKLJKLJKL","JKLJKLJKLJKL"));
	  }
	  
	  @Test
	  public void testStringContains()
	  {
		  assertFalse(stringSearch.contains("JKLMNO","ABC"));
		  assertTrue(stringSearch.contains("JKLMNO", "JKL"));
		  assertTrue(stringSearch.contains("JKLMNO","KLM"));
		  assertTrue(stringSearch.contains("JKLMNO","LMN"));
		  assertTrue(stringSearch.contains("JKLMNO","MNO"));
		  assertTrue(stringSearch.contains("JKLMNO","J"));
		  assertTrue(stringSearch.contains("JKLMNO","O"));
		  assertTrue(stringSearch.contains("JKLMNO","JKLMNO"));
		  
	  }
	  
	  @Test
	  public void testSearchAll()
	  {
		  assertEquals(4, stringSearch.searchAll("JKLJKLJKLJKL","JKL"));
		  assertEquals(2, stringSearch.searchAll("JKLJKLJKLJKL","JKLJ"));
		  assertEquals(1, stringSearch.searchAll("JKLJKLJKLJKL","JKLJKLJKLJKL"));
		  assertEquals(2, stringSearch.searchAll("JKLJKLJKLJKL","KLJK"));
		  assertEquals(3, stringSearch.searchAll("JKLJKLJKLJKL","LJK"));
		  
	  }
	  */

}
