package busManagement;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class stop {
	private int stopID;
	private int stopCode;
	//private String stopName;
	public String stopName;
	private String stopDesc;
	private String stopLat;
	private String stopLon;
	private String zoneID;
	private String locationType;
	private String stopURl;
	private String parentStation;
	private int tripId;
	private String arrTime;
	private String depTime;
	private String stopSeq;
	private String stopHead;
	private String stopPickup;
	private String stopDropoff;
	private String stopShape;
	
	public stop() {};
	public stop(String stopName)
	{
		this.stopName=stopName;
	}
	
	
	public stop(int stopID, int stopCode, String stopName, String stopDesc, String stopLat, String stopLon,
			String zoneID, String stopURl, String locationType, String parentStation) {
		this.stopID=stopID;
		this.stopCode=stopCode;
		this.stopName=stopName;
		this.stopDesc=stopDesc;
		this.stopLat=stopLat;
		this.stopLon=stopLon;
		this.zoneID=zoneID;
		this.locationType=locationType;
		this.stopURl=stopURl;
		this.parentStation=parentStation;

		
		}

	public ArrayList<stop> readStops(String fileName) throws FileNotFoundException{
//		File file = new File(fileName);
//		Scanner fileReader= new Scanner (file);
//		ArrayList<stop> stopList = new ArrayList<stop>();
//		while(fileReader.hasNextLine()) {
//			String line = fileReader.nextLine();
//			String [] items = line.split(",");
//			int stopID = Integer.parseInt(items[0]);
//			int stopCode= Integer.parseInt(items[1]);
//			String stopName= (items[2]);
//			String []stopReNamed = items[2].trim().split("\\s+");
//			String temp = stopReNamed[0];
//			int size = stopReNamed.length;
//			String putStart = stopReNamed[size-1];
//			stopReNamed[0] = putStart;
//			stopReNamed[size-1]=temp;
//			StringBuffer sb = new StringBuffer();
//			for(int i=0; i<stopReNamed.length;i++) {
//				sb.append(stopReNamed[i]);
//			}
//			String stopReReNamed = sb.toString();
//			String stopDesc= (items[3]);
//			String stopLat= (items[4]);
//			String stopLon= (items[5]);
//			String zoneID= (items[6]);
//			String stopURl= (items[7]);
//			String locationType= (items[8]);
//			String parentStation= (items[9]);
//			stop newStop = new stop(stopID,stopCode,stopReReNamed,stopDesc,stopLat,stopLon, zoneID,stopURl,locationType,parentStation);
//			stopList.add(newStop);
//		}
//		return stopList;
		
		BufferedReader br;
		ArrayList<stop> list = new ArrayList<stop>();
		br = new BufferedReader(new FileReader(fileName));
		try {
			String fileLine = br.readLine();
			fileLine = br.readLine();
			String stopName;
			
			while(fileLine!=null)
			{
				stopName = fileLine.split(",")[2];
				list.add(new stop(stopName));
				fileLine = br.readLine();
			}
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
			
		
	}
	public static String[] stopTimes(String fileName) throws FileNotFoundException {
		File file = new File(fileName);
		Scanner fileReader= new Scanner (file);
		int size = fileName.length();
		int i =0;
		String [] stopTimes = new String[size-1];
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			String [] items = line.split(",");
			stopTimes[i]=items[1];
			i++;
			

		}
		return stopTimes;
	}
	public stop(int tripID, String arrTime, String depTime, int stopID, String stopSeq, String stopHead,
			String stopPickup, String stopDropoff, String stopShape) {
		this.tripId=tripID;
		this.arrTime=arrTime;
		this.depTime=depTime;
		this.stopID=stopID;
		this.stopSeq=stopSeq;
		this.stopHead=stopHead;
		this.stopPickup=stopPickup;
		this.stopDropoff=stopDropoff;
		this.stopShape=stopShape;

	}
	public static ArrayList<stop> readStopTimes(String fileName) throws FileNotFoundException{
		File file = new File(fileName);
		Scanner fileReader= new Scanner (file);
		ArrayList<stop> stopTimeList = new ArrayList<stop>();
		while(fileReader.hasNextLine()) {
			String line = fileReader.nextLine();
			String [] items = line.split(",");
			int tripID = Integer.parseInt(items[0]);
			String arrTime= (items[1]);
			String depTime= (items[2]);
			int stopID = Integer.parseInt(items[3]);
			String stopSeq= (items[4]);
			String stopHead= (items[5]);
			String stopPickup= (items[6]);
			String stopDropoff= (items[7]);
			String stopShape= (items[8]);
			stop newStop = new stop(tripID,arrTime,depTime,stopID,stopSeq, stopHead,stopPickup,stopDropoff,stopShape);
			stopTimeList.add(newStop);
		}
		return stopTimeList;
		
			
		
	}
  
	
}
