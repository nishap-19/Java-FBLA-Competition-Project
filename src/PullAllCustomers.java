

//*********************************************************************
//PullAllSchedules.java     Name: Nisha Patel     Last Update: 01/04/17
//
//support files that pulls all customer data
//*********************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class PullAllCustomers extends JPanel{

	public PullAllCustomers(){
		
	}
	
	public static ArrayList<String> getListOfCustomers(){
		
		File folder = new File(System.getProperty("user.dir") + "/Customers/");
		File[] listOfFiles = folder.listFiles();
		ArrayList list = new ArrayList();

		if (listOfFiles != null){
			for (int i = 0; i < listOfFiles.length; i++) {
				
			     if (listOfFiles[i].isFile()) {
			    	 list.add(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
//			         System.out.println(listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
			     } else if (listOfFiles[i].isDirectory()) {
//			         System.out.println("Directory " + listOfFiles[i].getName().substring(0,listOfFiles[i].getName().length()-4));
			     }
			}
		}
		    
	   return list;
	}
	
	public static ArrayList<weeklyCustomers> getCustomerLog(String week) throws FileNotFoundException{
		
   	File folder = new File(System.getProperty("user.dir") + "/Customers/");
		
		Scanner dataScan, lineScan;
		String checkWeek, data, delim = "%";
		
		ArrayList<weeklyCustomers> customers = new ArrayList<weeklyCustomers>();
        
		 dataScan = new Scanner(new File(System.getProperty("user.dir") + "/Customers/" + week + ".txt"));
		 
			while (dataScan.hasNext()){
				
				data = dataScan.nextLine();
				lineScan = new Scanner(data);
				
				lineScan.useDelimiter("%");
				
				checkWeek = lineScan.next();
				
				weeklyCustomers thisWeek = new weeklyCustomers(checkWeek);
				
				while (lineScan.hasNext() && checkWeek.equals("Monday")){
				
					thisWeek.addMondayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				while (lineScan.hasNext() && checkWeek.equals("Tuesday")){
					
					thisWeek.addTuesdayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				while (lineScan.hasNext() && checkWeek.equals("Wednesday")){
					
					thisWeek.addWednesdayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				while (lineScan.hasNext() && checkWeek.equals("Thursday")){
					
					thisWeek.addThursdayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				while (lineScan.hasNext() && checkWeek.equals("Friday")){
					
					thisWeek.addFridayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				while (lineScan.hasNext() && checkWeek.equals("Saturday")){
					
					thisWeek.addSaturdayCustomers(lineScan.next(), lineScan.next(), lineScan.next());
				
				}
				
				customers.add(thisWeek); ;
			}
			
			return customers;
	}
}
