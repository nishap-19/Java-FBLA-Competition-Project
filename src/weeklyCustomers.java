
//********************************************************************
//weeklyCustomers.java     Name: Nisha Patel    Last Update: 01/07/17
//
//sub class file that uses the WorkDays support file to create an array
//of customers for each day of the work week
//*********************************************************************

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class weeklyCustomers {

	ArrayList<fecCustomerData> Monday = new ArrayList<fecCustomerData>();
	ArrayList<fecCustomerData> Tuesday = new ArrayList<fecCustomerData>();
	ArrayList<fecCustomerData> Wednesday = new ArrayList<fecCustomerData>();
	ArrayList<fecCustomerData> Thursday = new ArrayList<fecCustomerData>();
	ArrayList<fecCustomerData> Friday = new ArrayList<fecCustomerData>();
	ArrayList<fecCustomerData> Saturday = new ArrayList<fecCustomerData>();
	
	String MondayData = "Monday";
	String TuesdayData = "Tuesday";
	String WednesdayData = "Wednesday";
	String ThursdayData = "Thursday";
	String FridayData = "Friday";
	String SaturdayData = "Saturday";
	
	String currentWeek = "";
	
	//Construction establishes the date of the new work week
	public weeklyCustomers(String week) {
		
		currentWeek = week;
	}
	
	//sets the customer data for Monday to check them by sending first and last name to fecCustomerData support file
	public void addMondayCustomers (String first, String last) {
	
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Monday.add(customer);
		
		MondayData = MondayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Monday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addMondayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Monday.add(customer);
		
		MondayData = MondayData + customer.sendCustomerData();
	}

	//sets the customer data for Tuesday to check them by sending first and last name to fecCustomerData support file
	public void addTuesdayCustomers (String first, String last) {
		
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Tuesday.add(customer);
		
		TuesdayData = TuesdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Tuesday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addTuesdayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Tuesday.add(customer);
		
		TuesdayData = TuesdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Wednesday to check them by sending first and last name to fecCustomerData support file
	public void addWednesdayCustomers (String first, String last) {
		
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Wednesday.add(customer);
		
		WednesdayData = WednesdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Wednesday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addWednesdayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Wednesday.add(customer);
		
		WednesdayData = WednesdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Thursday to check them by sending first and last name to fecCustomerData support file
	public void addThursdayCustomers (String first, String last) {
		
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Thursday.add(customer);
		
		ThursdayData = ThursdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Thursday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addThursdayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Thursday.add(customer);
		
		ThursdayData = ThursdayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Friday to check them by sending first and last name to fecCustomerData support file
	public void addFridayCustomers (String first, String last) {
		
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Friday.add(customer);
		
		FridayData = FridayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Friday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addFridayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Friday.add(customer);
		
		FridayData = FridayData + customer.sendCustomerData();
	}
	
	//sets the customer data for Saturday to check them by sending first and last name to fecCustomerData support file
	public void addSaturdayCustomers (String first, String last) {
		
		fecCustomerData customer = new fecCustomerData(first, last);
		
		Saturday.add(customer);
		
		SaturdayData = SaturdayData + customer.sendCustomerData();
		
	}
	
	//sets the customer data for Saturday when pulling data from file by sending
	//first name, last name, and check in time to fecCustomerData support file
	public void addSaturdayCustomers (String first, String last, String time) {
		
		fecCustomerData customer = new fecCustomerData(first, last, time);
		
		Saturday.add(customer);
		
		SaturdayData = SaturdayData + customer.sendCustomerData();
		
	}
	
	//----------------------------------------------------------------------
	
	//allows user to get Monday's customer log
	public ArrayList<fecCustomerData> getMondayCustomers(){
		
		return Monday;
	}
	
	//allows user to get Tuesday's customer log
	public ArrayList<fecCustomerData> getTuesdayCustomers(){
		
		return Tuesday;
	}
	
	//allows user to get Wednesday's customer log
	public ArrayList<fecCustomerData> getWednesdayCustomers(){
			
			return Wednesday;
		}
	
	//allows user to get Thursday's customer log
	public ArrayList<fecCustomerData> getThursdayCustomers(){
		
		return Thursday;
	}
	
	//allows user to get Friday's customer log
	public ArrayList<fecCustomerData> getFridayCustomers(){
		
		return Friday;
	}
	
	//allows user to get Saturday's customer log
	public ArrayList<fecCustomerData> getSaturdayCustomers(){
		
		return Saturday;
	}
	
	//----------------------------------------------------------------------
	
	public String sendMondayToFile(){

		return MondayData;	
	}
	
	public String sendTuesdayToFile(){

		return TuesdayData;
	}

	public String sendWednesdayToFile(){
	
		return WednesdayData;
	}

	public String sendThursdayToFile(){
	
		return ThursdayData;
	}

	public String sendFridayToFile(){
	
		return FridayData;
	}

	public String sendSaturdayToFile(){
	
		return SaturdayData;
	}
	
	public String toString(){
		
		return currentWeek;
	}
	
}
