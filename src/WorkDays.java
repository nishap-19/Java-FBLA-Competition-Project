
//**************************************************************************
//WorkDays.java     Name: Nisha Patel    Last Update: 01/11/17
//
//support class file that can create store the work schedule for an employee
//**************************************************************************

import java.util.List;

public class WorkDays {
	
	String employeeID;
	
	String MonStart = "DAY", MonEnd = "OFF", MonHours = MonStart + " " + MonEnd + " ";
	String TueStart = "DAY", TueEnd = "OFF", TueHours = TueStart + " " + TueEnd + " ";
	String WedStart = "DAY", WedEnd = "OFF", WedHours = TueStart + " " + TueEnd + " ";
	String ThurStart = "DAY", ThurEnd = "OFF", ThurHours = ThurStart + " " + ThurEnd + " ";
	String FriStart = "DAY", FriEnd = "OFF", FriHours = FriStart + " " + FriEnd + " ";
	String SatStart = "DAY", SatEnd = "OFF", SatHours = SatStart + " " + SatEnd + " ";
	
	public WorkDays(){
		
	}
	
	public WorkDays(String IDnum){
		
		employeeID = IDnum;
	}

	public void addMonday(String start, String end){
		
		String check = start.toUpperCase() + " "  + end.toUpperCase();
		
		if (check.equals("DAY OFF"))
		{
			MonStart = "Day";
			MonEnd = "Off";
			MonHours = MonStart + " " + MonEnd;
		}
		else if (check.equals("REQUEST OFF"))
		{
			MonStart = "Request";
			MonEnd = "Off";
			MonHours = MonStart + " " + MonEnd;
		}
		else
		{
			MonStart = start;
			MonEnd = end;
			MonHours = MonStart.substring(0,2) + ":" + MonStart.substring(2,4) + "-" + MonEnd.substring(0,2) + ":" + MonEnd.substring(2,4);
		}
	}
	
	public String getMonStart(){
		
		return MonStart;
	}
	
	public String getMonEnd(){
		
		return MonEnd;
	}
	
	public String getMonHours(){
		
		return MonHours;
	}
	
	public void addTuesday(String start, String end){
		
		String check = start.toUpperCase() + " "  + end.toUpperCase();
		
		if (check.equals("DAY OFF"))
		{
			TueStart = "Day";
			TueEnd = "Off";
			TueHours = TueStart + " " + TueEnd;
		}
		else if (check.equals("REQUEST OFF"))
		{
			TueStart = "Request";
			TueEnd = "Off";
			TueHours = TueStart + " " + TueEnd;
		}
		else
		{
			TueStart = start;
			TueEnd = end;
			TueHours = TueStart.substring(0,2) + ":" + TueStart.substring(2,4) + "-" + TueEnd.substring(0,2) + ":" + TueEnd.substring(2,4);
		}
	}
	
	public String getTueStart(){
		
		return TueStart;
	}
	
	public String getTueEnd(){
		
		return TueEnd;
	}
	
	public String getTueHours(){
		
		return TueHours;
	}
	
	public void addWednesday(String start, String end){
		
		String check = start.toUpperCase() + " "  + end.toUpperCase();
		
		if (check.equals("DAY OFF"))
		{
			WedStart = "Day";
			WedEnd = "Off";
			WedHours = WedStart + " " + WedEnd;
		}
		else if (check.equals("REQUEST OFF"))
		{
			WedStart = "Request";
			WedEnd = "Off";
			WedHours = WedStart + " " + WedEnd;
		}
		else
		{
			WedStart = start;
			WedEnd = end;
			WedHours = WedStart.substring(0,2) + ":" + WedStart.substring(2,4) + "-" + WedEnd.substring(0,2) + ":" + WedEnd.substring(2,4);
		}
	}
	
	public String getWedStart(){
		
		return WedStart;
	}
	
	public String getWedEnd(){
		
		return WedEnd;
	}
	
	public String getWedHours(){
		
		return WedHours;
	}
	
	public void addThursday(String start, String end){
		
		String check = start.toUpperCase() + " "  + end.toUpperCase();
		
		if (check.equals("DAY OFF"))
		{
			ThurStart = "Day";
			ThurEnd = "Off";
			ThurHours = ThurStart + " " + ThurEnd;
		}
		else if (check.equals("REQUEST OFF"))
		{
			ThurStart = "Request";
			ThurEnd = "Off";
			ThurHours = ThurStart + " " + ThurEnd;
		}
		else
		{
			ThurStart = start;
			ThurEnd = end;
			ThurHours = ThurStart.substring(0,2) + ":" + ThurStart.substring(2,4) + "-" + ThurEnd.substring(0,2) + ":" + ThurEnd.substring(2,4);
		}
	}
	
	public String getThurStart(){
		
		return ThurStart;
	}
	
	public String getThurEnd(){
		
		return ThurEnd;
	}
	
	public String getThurHours(){
		
		return ThurHours;
	}
	
	public void addFriday(String start, String end){
		
		String check = start.toUpperCase() + " "  + end.toUpperCase();
		
		if (check.equals("DAY OFF"))
		{
			FriStart = "Day";
			FriEnd = "Off";
			FriHours = FriStart + " " + FriEnd;
		}
		else if (check.equals("REQUEST OFF"))
		{
			FriStart = "Request";
			FriEnd = "Off";
			FriHours = FriStart + " " + FriEnd;
		}
		else
		{
			FriStart = start;
			FriEnd = end;
			FriHours = FriStart.substring(0,2) + ":" + FriStart.substring(2,4) + "-" + FriEnd.substring(0,2) + ":" + FriEnd.substring(2,4);
		}
	}
	
	public String getFriStart(){
		
		return FriStart;
	}
	
	public String getFriEnd(){
		
		return FriEnd;
	}
	
	public String getFriHours(){
		
		return FriHours;
	}
	
	public void addSaturday(String start, String end){
		
		String check = start + " " + end;
		
		if (check.equalsIgnoreCase("Day Off"))
		{
			SatStart = "Day";
			SatEnd = "Off";
			SatHours = SatStart + " " + SatEnd;
		}
		else if (check.equals("Request Off"))
		{
			SatStart = "Request";
			SatEnd = "Off";
			SatHours = SatStart + " " + SatEnd;
		}
		else
		{
			SatStart = start;
			SatEnd = end;
			SatHours = SatStart.substring(0,2) + ":" + SatStart.substring(2,4) + "-" + SatEnd.substring(0,2) + ":" + SatEnd.substring(2,4);
		}
	}
	
	public String getSatStart(){
		
		return SatStart;
	}
	
	public String getSatEnd(){
		
		return SatEnd;
	}
	
	public String getSatHours(){
		
		return SatHours;
	}
	
	public String getEmployeeID(){
		
		return employeeID;
	}
	
	public int findEmployee (List<WorkDays> fecList, String str)
	{		
		int x;
		
		for (x = 0; x < fecList.size(); x++) 
		{
		    if (str.equalsIgnoreCase(fecList.get(x).getEmployeeID())) 
		    {
		        break;
		    }
		}
		
		return x;
	}
	
	public String getEmployeeHours(){
		
		return (employeeID + "\t\t" + MonHours + "\t" + TueHours + "\t" + WedHours + "\t" + ThurHours + "\t" + FriHours + "\t" + SatHours);
	}
	
	public String sendScheduleToFile(){
		
		return (employeeID + "%" + MonStart + "%" + MonEnd + "%" + TueStart + "%" + TueEnd + "%" + WedStart + "%" + WedEnd + "%" +
					ThurStart + "%" + ThurEnd + "%" + FriStart + "%" + FriEnd + "%" + SatStart + "%" + SatEnd);
	}
	
	public String toString(){
		
		return employeeID;
	}
}
