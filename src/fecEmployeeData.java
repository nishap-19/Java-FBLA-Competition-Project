

//*********************************************************************
//fecEmployeeData.java     Name: Nisha Patel     Last Update: 12/05/16
//
//class file to generate employee information
//*********************************************************************

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class fecEmployeeData
	{
	
			private String firstName = "N/A", midInitial = "N/A", lastName = "N/A", fullName = "N/A";
			private String homeAddress = "unavailable", contactNumber = "000000000", employeeID = "unavailable";
			private String streetAddress = "N/A", city = "N/A", state = "N/A", zipCode = "N/A";
			private String gender = "N/A", dateOfBirth = "00/00/0000", hireDate = "00/00/0000";
			private String dobMonth = "00", dobDay = "00", dobYear = "00", hMonth = "00", hDay = "00", hYear = "0000";
			private String number = "0000000000";
			
			public fecEmployeeData()
				{
					
				}
			
			public fecEmployeeData (String nameFirst, String initialMid, String nameLast)
				{
					firstName = nameFirst;
					midInitial = initialMid;
					lastName = nameLast;
					
					fullName = firstName + " " + midInitial + ". " + lastName;
				}
			
			public void setFName (String first)
			{
				firstName = first;
			}
			
			public void setMidInit (String initial)
			{
				midInitial = initial;
			}
			
			public void setLName (String last)
			{
				lastName = last;
			}
			
			public String setHomeAddress (String street, String town, String st, String zip)
				{
				  streetAddress = street;
				  city = town;
				  state = st;
				  zipCode = zip;
				  
				  homeAddress = streetAddress + "\n";
				  homeAddress += city + ", " + state + " " + zipCode;
				  return homeAddress;
				}
			
			public String getHomeAddress ()
				{
					return homeAddress;
				}
			
			public String getStreetAddress ()
			{
				return streetAddress;
			}
			
			public String getCity ()
			{
				return city;
			}
			
			public String getState ()
			{
				return state;
			}
			
			public String getZipCode ()
			{
				return zipCode;
			}
			
			public void setContactNumber (String codeArea, String midThree, String lastFour)
				{
					String areaCode = codeArea;
					String mid = midThree;
					String end = lastFour;
					number = codeArea + midThree + lastFour;
					
					contactNumber = "(" + areaCode + ") " + mid + "-" + end;
				}
			
			public String getContactNumber ()
				{
					return contactNumber;
				}
			
			public String setDateOfBirth (String month, String day, String year)
				{
					dobMonth = month;
					dobDay = day;
					dobYear = year;
					
					dateOfBirth = dobMonth + "/" + dobDay + "/" + dobYear;
					
					return dateOfBirth;
				}
			
			public String getDateOfBirth ()
				{
					return dateOfBirth;
				}
			
			public String setGender (String sex)
				{
					gender = sex;
				
					return gender;
				}
			
			public String getGender ()
				{
					return gender;
				}
			

			public String setHireDate (String month, String day, String year)
				{
						hMonth = month;
						hDay = day;
						hYear = year;
						
						hireDate = hMonth + "/" + hDay + "/" + hYear;
						
						return hireDate;
				}
			
			public String getHireDate ()
				{
					return hireDate;
				}
			
			public String setEmployeeID ()
			{
				Random rand = new Random ();
				employeeID = "";
				int num1;
				
				for (int x = 0; x <6; x++)
				{
					num1 = rand.nextInt(10);
					employeeID = employeeID + num1;
				}
					
				return employeeID;
			}
			
			public String setEmployeeID (String idNumber)
			{
				employeeID = idNumber;
					
				return employeeID;
			}
			
			public String setEmployeeID (List<fecEmployeeData> fecList)
				{
					Random rand = new Random ();
					employeeID = "";
					int num1, y;
					int check;
					boolean validate = true;
					
					while (validate)
					{
						for (int x = 0; x <6; x++)
						{
							num1 = rand.nextInt(10);
							employeeID = employeeID + num1;
						}
						
						check = Integer.parseInt(employeeID);
						
						for (y = 0; y < fecList.size(); y++) 
						{
						    if (fecList != null) 
						    {
						    	if (check == Integer.parseInt(fecList.get(y).getEmployeeID()))
						    	{	
							    	validate = true;
							        //break;
						    	}
						    	else
						    	{
						    		validate = false;
						    	}
						    }
						}
					}
					return employeeID;
				}
			
			public String getEmployeeID ()
				{
					return employeeID;
				}
			
			public String getName ()
				{
						return firstName + " " + lastName;
				}
			
			public String getFName ()
			{
				return firstName;
			}
			
			public String getMInitial ()
			{
				return midInitial;
			}
			
			public String getLName ()
			{
				return lastName;
			}
			
			public int findEmployee (List<fecEmployeeData> fecList, String str)
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
			
			public String getEmployeeData()
				{
				  return ("Name: " + fullName + "\nEmployee ID: " + employeeID + "\nHire Date: " + hireDate + 
						  		"\nAddress:\n" + homeAddress + "\nContact Number:\n" + contactNumber + "\nDate of Birth: " 
				  					+ dateOfBirth + "\nGender: " + gender);
				}
			
			public String sendDataToFile()
			{
			  return (firstName + "%" + midInitial + "%" + lastName + "%" + employeeID + "%" + hMonth + "%" + hDay + "%" + hYear + "%" + 
					  		"%" + streetAddress + "%" + city + "%" + state + "%" + zipCode + "%" + number + "%" 
			  					+ dobMonth + "%" + dobDay + "%" + dobYear + "%" + gender);
			}
			
			public String toString()
				{
				  return getEmployeeID();
				}
	}
