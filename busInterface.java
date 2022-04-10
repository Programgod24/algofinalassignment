package busManagement;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;

public class busInterface {

	public static void main(String[] args) throws FileNotFoundException {
		Scanner input = new Scanner(System.in);
		stop stop = null;
		TST tree;
		boolean quit = false;
		do
		{
			System.out.println("Enter 1 to find the shortest path between 2 bus stops. Enter 2 to search for a bus stop. Enter 3 to search for trips. Or enter quit to quit");
			String userInput = input.nextLine();

				switch(userInput){
				//if (userInput.equalsIgnoreCase("quit"))
				case("quit"):
				{
					quit = true;
					break;
				}
				//if(userInput.equalsIgnoreCase("1"))
				case("1"):
				{
					System.out.println("Enter the stop_id of the two bus stops seperated by a comma");
					String usersInput=input.nextLine();
	    			String [] line = usersInput.trim().split(",");
	    			int stop1 = Integer.parseInt(line[0]);
	    			int stop2 = Integer.parseInt(line[1]);
	    			String result = shortestpath.shortestpath("stops.txt", stop1, stop2);
	    			System.out.println(""+result);

					
				}
				//else if(userInput.equalsIgnoreCase("2"));
				case("2"):
				{
					System.out.println("Enter the name of the bus stop");
					String usersInput=input.nextLine();
					//String stop = usersInput;
					stop = new stop();
					//reads in all stops
					ArrayList<stop> stopsList = stop.readStops("stops.txt");
					//creates tree by using put() method for each stop
					tree = new TST(stopsList);
					//creates list of keys with prefix from users input
					Iterable<String> list = tree.keysWithPrefix(usersInput);
					//iterates through list and returns the stop name for each key found
					for(String key: list)
					{
						stop treeStop = tree.get(key);
						System.out.println(treeStop.stopName);
					}
				}
				// if(userInput.equalsIgnoreCase("3")) 
				case("3"):
				 {
					System.out.println("Enter the arrival time of your wanted trip");
					String usersInput=input.nextLine();
					String[] stopTimes = stop.stopTimes("stop_times.txt");
					int [] arr=stringSearch.findAllCommonIndexString(usersInput, stopTimes);
					ArrayList<stop> StopTimes = stop.readStopTimes("stop_times.txt");
					for(int i =0; i<arr.length-1;i++) {
						System.out.println(""+StopTimes.get(i));
					}
					
				}
				default:
				{
					System.out.println("Error. Please enter 1 to find the shortest path between 2 bus stops. Enter 2 to search for a bus stop. Enter 3 to search for trips. Or enter quit to quit");

				}
				}
				
			
			
			
			
			
		}while(quit==false);
		
		
	}

}
