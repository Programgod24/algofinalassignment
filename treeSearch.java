package busManagement;

import java.util.ArrayList;
import java.util.LinkedList;

public class treeSearch<stop> {
	 private static class TrieNode<stop> 
	  {
			private char c;                        	   // character
	        private TrieNode<stop> left; 			   //left subtrie
	        private TrieNode<stop> mid;			   //mid subtrie
	        private TrieNode<stop> right;			   //right subtrie
	        private stop stop;                         // value associated with string
	  }

	  /* 
	   * a pointer to the start of your trie
	   */
	  private static TrieNode root = new TrieNode();
	  private static final int R = 256; 
	  private int size; 

	  /*
	   * Returns the number of words in the trie
	   */
	  public int size() 
	  {
	    return size; 
	  }

	  /*
	   * returns true if the word is in the trie, false otherwise
	   */
	  public boolean contains(String key) 
	  {
		  if (key == null)
	          return false;
	 
	      return get(key) != null;
	  }

	  /*
	   * return the value stored in a node with a given key, returns null if word is not in trie
	   */
	  public stop get(String key) 
	  {
		  //The key is the word made up of chars
		  //Each node has a char 
		  //The node with the last char in the key (which is a word), has the value 
		  
	      if (key == null) 
	      {
	          return null; 
	      }
	      
	      if (key.length() == 0) 
	      {
	    	  return null; 
	      }
	    	  
	      TrieNode<stop> x = get(root, key, 0);
	      
	      if (x == null) 
	    	  return null;
	      
	      return x.stop;

	  }
	  
	  private TrieNode<stop> get(TrieNode<stop> x, String key, int d) 
	  {
	      if (x == null)
		  {
	    	  return null;
		  }
	      
	      char c = key.charAt(d);
	      
	      if (c < x.c)              
	    	  return get(x.left,  key, d);
	      
	      else if (c > x.c)
	    	  return get(x.right, key, d);
	      
	      else if (d < key.length() - 1)
	    	  return get(x.mid,   key, d+1);
	      
	      else
	    	  return x;
	  }

	  /*
	   * stores the Value val in the node with the given key
	   */
	  public void put(String key, stop stop) 
	  {
	      if (!contains(key)) 
	    	  size++;
	      root = put(root, key, stop, 0);
	  }

	  private TrieNode<stop> put(TrieNode<stop> x, String key, stop stop, int d) 
	  {
	      char c = key.charAt(d);
	      if (x == null) 
	      {
	          x = new TrieNode<stop>();
	          x.c = c;
	      }
	      
	      if (c < x.c)              
	    	  x.left  = put(x.left,  key, stop, d);
	      
	      else if (c > x.c)               
	    	  x.right = put(x.right, key, stop, d);
	      
	      else if (d < key.length() - 1)  
	    	  x.mid   = put(x.mid,   key, stop, d+1);
	      
	      else                            
	    	  x.stop   = stop;
	      
	      return x;
	  }
	  
	  /*
	   * returns the linked list containing all the keys present in the trie
	   * that start with the prefix passes as a parameter, sorted in alphabetical order
	   */ 
	  public LinkedList<String> keysWithPrefix(String prefix) 
	  {
		  if (prefix == "") 
		  {
	          return null; 
	      }
	      
		  LinkedList<String> list = new LinkedList<String>();
	      
		  TrieNode<stop> x = get(root, prefix, 0);
	      
	      if (x == null) 
	    	  return list;
	     
	      if (x.stop != null) 
	    	  list.add(prefix);
	      
	      collect(x.mid, new StringBuilder(prefix), list);
	      
	      return list; 
	  }
	  
	  // all keys in subtrie rooted at x with given prefix
	  private void collect(TrieNode<stop> x, StringBuilder prefix, LinkedList<String> list) 
	  {
	      if (x == null) 
	    	  return;
	      
	      collect(x.left,  prefix, list);
	      
	      if (x.stop != null) 
	    	  list.add(prefix.toString() + x.c);
	      
	      collect(x.mid,   prefix.append(x.c), list);
	      
	      prefix.deleteCharAt(prefix.length() - 1);
	      
	      collect(x.right, prefix, list);
	  }

}
