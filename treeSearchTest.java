package busManagement;

import static org.junit.Assert.*;

import java.io.File;
import java.util.Scanner;

import org.junit.Test;

public class treeSearchTest {

	
	@Test
	public void testDefault()
	{
		treeSearch<Integer> trie = new treeSearch<>();
		
		Integer number = 1; 
		trie.put("the", number);
		
		assertEquals(1, trie.size());
		
		number = 2; 
		trie.put("pied", number);
		
		number =  3; 
		trie.put("piper", number);
		
		number =  4; 
		trie.put("picked", number);

		number =  5; 
		trie.put("a", number);

		number =  6; 
		trie.put("pack", number);
		
		number =  7; 
		trie.put("of", number);
		
		number =  8; 
		trie.put("pickled", number);
		
		number =  9; 
		trie.put("peppers", number);
		
		assertEquals(9, trie.size());


		assertTrue(trie.contains("the"));
		assertTrue(trie.contains("piper"));
		assertTrue(trie.contains("a"));
		assertTrue(trie.contains("pickled"));
		assertTrue(trie.contains("peppers"));
		
		assertFalse(trie.contains("shv"));
		assertFalse(trie.contains("sh"));
		assertFalse(trie.contains("shellsz"));
		

		Integer result =  5;
		assertEquals(result, trie.get("a"));
		result = 1;
		assertEquals(result, trie.get("the"));
		result = 6;
		assertEquals(result, trie.get("pack"));
		result = 2;
		assertEquals(result, trie.get("pied"));
		result = 9;
		assertEquals(result, trie.get("peppers"));
		
		result = null;
		assertEquals(result, trie.get("thv"));
		assertEquals(result, trie.get("pip"));
		assertEquals(result, trie.get("peipoers"));
		

		assertEquals("[picked, pickled, pied, piper]", trie.keysWithPrefix("pi").toString());
		assertEquals("[]", trie.keysWithPrefix("hi").toString());
		assertEquals("[peppers]", trie.keysWithPrefix("pep").toString());
	
	}

	

}
