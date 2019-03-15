

//*********************************************************************
//PullAllSchedules.java     Name: Nisha Patel     Last Update: 01/04/17
//
//support files that pulls all employee schedule data
//*********************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class PullAllSchedules extends JPanel{

	public PullAllSchedules(){
		
	}
	
	public static ArrayList<String> getListOfSchedules(){
		
		File folder = new File(System.getProperty("user.dir") + "/Schedules/");
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
	
	public static ArrayList<WorkDays> getSchedule(String week) throws FileNotFoundException{
		
		Scanner dataScan, lineScan;
		String data, delim = "%";
		
		ArrayList<WorkDays> employees = new ArrayList<WorkDays>();
		
		 dataScan = new Scanner(new File(System.getProperty("user.dir") + "/Schedules/" + week + ".txt"));
		 
			while (dataScan.hasNext()){
				
				data = dataScan.nextLine();
				lineScan = new Scanner(data);
				
				lineScan.useDelimiter("%");
				WorkDays hours = new WorkDays(lineScan.next());
				
				hours.addMonday(lineScan.next(), lineScan.next());

				hours.addTuesday(lineScan.next(), lineScan.next());;
	
				hours.addWednesday(lineScan.next(), lineScan.next());

				hours.addThursday(lineScan.next(), lineScan.next());
	
				hours.addFriday(lineScan.next(), lineScan.next());
				
				hours.addSaturday(lineScan.next(), lineScan.next());

				employees.add(hours); ;
			}
			
			return employees;
	}
}
