package busManagement;

import java.io.File;
import java.util.Scanner;

public class stringSearch {
	public static final int x = 256;


	
	public static int search(String common, String text) {
	
			
		int commonL = common.length();
		int [][] acceptor = new int[x][commonL];
		acceptor[common.charAt(0)][0] = 1;

		int textL = text.length();
		int i, j, c;
		for ( i = 0, j = 1; j < commonL; j++) {
			for ( c = 0; x > c; c++) {
				acceptor[c][j] = acceptor[c][i];
			}
			acceptor[common.charAt(j)][j] = j + 1;
			i = acceptor[common.charAt(j)][i];
		}
		int m,n;
		for( m=0, n=0; textL > m && commonL > n; m++) {
			n = acceptor[text.charAt(m)][n];
		}
		if(commonL==n) {
			return m-commonL;
		}
		else {
			return -1;
		}
		
	}
	public static int findCommon(String common, String text) {
		if(common==""||text=="") {
			return -1;
		}
			return search(common, text);
		
	}
		public static int findAllCommon(String common, String text) {
			int occurance, product = 0;
			if(common==""||text=="") {
				return 0;
			}
			int linecount=0;
			int[] index = null;
			while(common.length()<=text.length()&&-1!=product) {
				product = search(common,text);
				if(-1!=product) {
					System.out.println(""+product);
					product = product++;
					text=text.substring(common.length() + product);
				}
				linecount++;
				
			}
			 
				return product;
			
		
	}
		public static int[] findAllCommonIndexInt(int stop1, int[] startID) {
			int [] indexs = null;
			int count = 0;
					if(stop1==0) {
						return null;
					}
					for (int i=0;i<startID.length;i++) {
					    if (startID[i]==stop1) {
					    	indexs=increaseSize(indexs);
					    	indexs[count]=i;
					    	count++;
					    }
					}
					return indexs;
			
		
	}
		public static int[] findAllCommonIndexString(String usersInput, String[] stopTimes) {
			int [] indexs = null;
			int count = 0;
					if(usersInput=="") {
						return null;
					}
					for (int i=0;i<stopTimes.length;i++) {
					    if (stopTimes[i].equals(usersInput)) {
					    	indexs=increaseSize(indexs);
					    	indexs[count]=i;
					    	count++;
					    }
					}
					return indexs;
			
		
	}
		
		
		public static int[] increaseSize(int[] arr)
	    {
	        int[] newArr = new int[arr.length + 1];
	        for(int i = 0; i < arr.length; i++)
	        {
	            newArr[i] = arr[i];
	        }
	        return newArr;
	    }
	    
	public static boolean fits(String common, String text) {
		if(common==""||text=="") {
			return false;
		}
		if(search(common, text)==-1) {
			return false;
		}
		else{
			return true;
		}
	}
	

}
