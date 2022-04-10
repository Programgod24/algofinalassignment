package busManagement;

import java.io.File;
import java.util.Scanner;

public class shortestpath {
	public int stop1;
	public int stop2;
	public double distance[][];
	public static int[] tripID;
	public static int[] startID;
	public int endcount;
	public static String DataFile;
	public static int[] hA;
	public static int[] mA;
	public static int[] sA;
	public static int[] hD;
	public static int[] mD;
	public static int[] sD;
   	public static int hF;
	public static int mF;
	public static int sF;


	

 
    public  static String shortestpath (String filename, int s1, int s2){

    	int stop1 = s1;
    	int stop2 = s2;
    	String DataFile = filename;
    	try {
    		int linecount = 0;

    		File file1 = new File (DataFile);
    		String arr1 ="";
    		Scanner fileReader = new Scanner(file1);
    		int x = Integer.MAX_VALUE;
    		while(fileReader.hasNextLine()) {
    			String [] line = fileReader.nextLine().trim().split(",");
    			tripID = new int[Integer.parseInt(line[0])];
    			if(tripID[linecount]==stop1) {
    				arr1=""+linecount+",";
    			}
    			startID = new int[Integer.parseInt(line[3])];
    			String arrivetime = line[1];
    			String deptime = line[2];
    			String [] arriveTime = arrivetime.trim().split(":");
    			String [] depTime = deptime.trim().split(":");
                hA[linecount] = Integer.parseInt(arriveTime[0]);
                mA[linecount] = Integer.parseInt(arriveTime[1]);
                sA[linecount] = Integer.parseInt(arriveTime[2]);
                hD[linecount] = Integer.parseInt(arriveTime[0]);
                mD[linecount] = Integer.parseInt(arriveTime[1]);
                sD[linecount] = Integer.parseInt(arriveTime[2]);

    			linecount++;
    		}
    		
    		fileReader.close();
    		
    	}
    	catch(Exception x) {
    		
    		return "";
    	}
    	String Stop1 = Integer.toString(stop1);
    	
    	int[] startIDIndex =stringSearch.findAllCommonIndexInt(stop1, startID);

    	
    	int shortestCost =shortestCost(startIDIndex, stop1, stop2, tripID);
    	String shortestStop =shortestStop(startIDIndex, stop1, stop2, tripID);
    	return shortestStop;

    }

    
   
    
    public static int shortestCost(int[] startIDIndex, int arrive, int dep, int[] tripID) {
    	int j = 0;
    	int testShortest = 0;
    	int shortest=0;
    	int shortestStop;
    	for(int i =startIDIndex[j]; j < startIDIndex.length; j++) {
    		
    		while(arrive!=dep) {
    			
    			arrive = startID[i];
    			testShortest++;
    			i++;
    				
    		}
    		if(testShortest<shortest||shortest==0) {
    			shortest = testShortest;
    			shortestStop = startIDIndex[j];
    		}
    		
    	}
    	 return shortest;
    }
    public static String shortestStop(int[] startIDIndex, int arrive, int dep, int[] tripID) {
    	int j = 0;
    	int testShortest = 0;
    	int shortest=0;
    	int shortestStop=0;
    	int testHF=0;
    	int testMF=0;
    	int testSF=0;
    	String totalStops = "";
    	String testTotalStops="";
    	int testStop = 0;
    	
    	for(int i =startIDIndex[j]; j < startIDIndex.length; j++) {
    		
    		while(arrive!=dep) {
    			testStop=0;
    			arrive = startID[i];
    			testHF = hA[i+1] - hA[i];
    			testMF = mA[i+1] - mA[i];
    			testSF = sA[i+1] - sA[i];
    			testTotalStops += (""+startID[i]+ ", ");  			
    			testShortest++;
    			i++;
    			
    				
    		}
    		if((hF==0&&mF==0&&sF==0)||(testHF<=hF)||(testMF<=mF&&testHF==hF)||(testHF==hF&&testMF==mF&&testSF<=sF)) {
    			hF=testHF;
    			mF=testMF;
    			sF=testSF;
    			testStop=-1;
    		}
    		if(shortestStop==0||testShortest<shortestStop) {
    			shortestStop = testShortest;
    		}
    		if(testStop==-1) {
    			totalStops = testTotalStops;
    		}
    		if(testStop==0) {
    			totalStops = "";
    		}
    		
    		
    	}
    	String hours= Integer.toString(hF);
    	String mins= Integer.toString(mF);
    	String secs= Integer.toString(sF);
    	String result = ("Time:"+hF+":"+mF+":"+sF+  ". Stops: "+totalStops+". Cost: " +shortestStop );
    	 return result;
    }
    
}
