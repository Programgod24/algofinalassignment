package busManagement;

public class stringSearch {
	public static final int R = 256;

	public static int search(String common, String text) {
		int commonL = common.length();
		int [][] acceptor = new int[R][commonL];
		acceptor[common.charAt(0)][0] = 1;

		int textL = text.length();
		int i, j, c;
		for ( i = 0, j = 1; j < commonL; j++) {
			for ( c = 0; R > c; c++) {
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
		else {
			return search(common, text);
		}
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
					product = product++;
					text=text.substring(common.length() + product);
				}
				linecount++;
				
			}
			 
				return product;
			
		
	}
		public static int[] findAllCommonIndex(String common, String text) {
			int occurance, product = 0;
			if(common==""||text=="") {
				return null;
			}
			int linecount=0;
			int[] index = null;
			while(common.length()<=text.length()&&-1!=product) {
				product = search(common,text);
				if(-1!=product) {
					index = increaseSize(index);
					index[product]=linecount;
					product = product++;
					text=text.substring(common.length() + product);
				}
				linecount++;
				
			}
			 
				return index;
			
		
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
