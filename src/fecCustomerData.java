
//**************************************************************
//fecCustomerData.java     Name: Nisha Patel     Date: 11/22/16
//
//organizes customer information
//**************************************************************

import java.util.Date;
import java.util.*;
import java.text.*;

public class fecCustomerData
	{
		Date date = new Date();
		private String firstName;
		private String lastName;
		String time;
		
		public fecCustomerData()
			{
				
			}
		
		public fecCustomerData (String first, String last)
		{
				firstName = first;
				lastName = last;
				
				checkIn();
		}
		
		public fecCustomerData (String first, String last, String inTime)
		{
				firstName = first;
				lastName = last;
				
				time = inTime;
		}

		public String checkIn ()
		{
			SimpleDateFormat ft = 
//				      new SimpleDateFormat ("E MM/dd/yyyy 'at' hh:mm:ss a ");
					  new SimpleDateFormat ("hh:mm:ss a");
					
			time = ft.format(date);
			
			return ft.format(date);
		}
		
		public String getFname()
		{
			return firstName;
		}
		
		public String getLname()
		{
			return lastName;
		}
		
		public String getTime()
		{
			return time;
		}
		
		public String getCustomerData(){
			
			return firstName + " " + lastName + " " + time;
		}
		
		public String sendCustomerData(){
			
			return "%" + firstName + "%" + lastName + "%" + time;
		}
		
		public String toString ()
		{
			return firstName;
		}
		
	}
