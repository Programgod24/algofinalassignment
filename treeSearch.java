package busManagement;

import java.util.LinkedList;

public class treeSearch<Cost> {
	private static class ternaryNode<Cost>{
		 private char c;
		 private Cost cost;
		 private ternaryNode<Cost> right;
		 private ternaryNode<Cost> middle;
		 private ternaryNode<Cost> left;
	}
	private int size;
	private static final int R = 256;
	private ternaryNode root = new ternaryNode();
	public boolean occurence(String key) {
		if(null==key) {
			return false;
		}
		
		return find(key)!=null;
	}
	public Cost find(String key) {
		if(null==key||0==key.length()) {
			return null;
		}
		ternaryNode<Cost> c = find(key, root, 0);
		System.out.print(""+c);
		if(null==c) {
			return null;
		}
		else {
			return c.cost;
		}
	}
	private ternaryNode<Cost> find(String key, ternaryNode<Cost> c, int number){
		if(null==c) {
			return null;
		}
		System.out.print(""+c);
		char Char = key.charAt(number);
		if(c.c<Char) {
			return find(key,c.right, number);
		}
		else if(c.c> Char) {
			return find( key,c.left, number);
		}
		
		else if(key.length()-1>number) {
			return find( key,c.middle, number+1);
			
		}
		else {
			return c;
		}
	}
	public LinkedList<String> keysPresent(String title){
		if(title=="") {
			return null;
		}
		LinkedList<String> presentList = new LinkedList<String>();
		ternaryNode<Cost> c = find( title,root, 0);
		System.out.print(""+c);
		if(null==c) {
			return presentList;
		}
		else if(null!=c.cost) {
			presentList.add(title);
		}
		gather(c.middle, presentList, new StringBuilder(title));
		return presentList;
	}
	private void gather(ternaryNode<Cost> c, LinkedList<String> presentList, StringBuilder title) {
		if (null==c) {
			return;
		}
		System.out.print(""+c);

		gather(c.left, presentList, title);
		if(null!=c.cost) {
			presentList.add(title.toString() + c.c);
			if(null!=c.cost) {
				presentList.add(title.toString() + c.c);
				
			}
			gather(c.middle, presentList, title.append(c.c));
			title.deleteCharAt(title.length()-1);
			gather(c.right, presentList, title);
		}
	}
	public int size() {
		return size;
	}
	public void set(Cost cost, String key) {
		if(!occurence(key)) {
			size++;
		}
		root=set(key, root, 0, cost);
	}
	private ternaryNode<Cost> set(String key, ternaryNode<Cost> c, int number, Cost cost){
		char Char = key.charAt(number);
		if(null==c) {
			c = new ternaryNode<Cost>();
			c.c = Char;
		}
		System.out.print(""+c);

		if(c.c<Char) {
			return set(key,c.right, number, cost);
		}
		else if(c.c> Char) {
			return set( key,c.left, number, cost);
		}
		
		else if(key.length()-1>number) {
			return set( key,c.middle, number+1, cost);
			
		}
		else {
			c.cost=cost;
		}
		return c;
	}

}
