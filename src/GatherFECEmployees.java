import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//***********************************************************************
//GatherFECEmployees.java     Name: Nisha Patel     Last Update: 01/04/17
//
//reads employee files and collects employee data
//***********************************************************************

public class GatherFECEmployees {
	
	public GatherFECEmployees() {
		
	}
	
	public static List<fecEmployeeData> getEmployees() throws FileNotFoundException{
		
			File file = new File(System.getProperty("user.dir") + "/Employees.txt");

            // if file doesnt exists, then create it
            if (!file.exists()) {
                try {
					file.createNewFile();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            }
			List<fecEmployeeData> list = new ArrayList<fecEmployeeData>();
			
			Scanner fileScan, dataScan;
			String data, delim = "%";
			
			fileScan = new Scanner(new File(System.getProperty("user.dir") + "/Employees.txt"));
			
			//READING FROM FILE AND ENTERING INTO JTABLE------------------------------------------
			
			String fn, mn, ln, id;
			String hm, hd, hy;
			String street, town, st, zip;
			String contact, dobM, dobD, dobY;
			String gender;
			
			while (fileScan.hasNext()) 
			{
				data = fileScan.nextLine();
				dataScan= new Scanner(data);
				dataScan.useDelimiter(delim);
				
				fn = dataScan.next();
				mn = dataScan.next();
				ln = dataScan.next();
				
				//Name
				fecEmployeeData employ = new fecEmployeeData(fn, mn, ln);
				
				id = dataScan.next();
				
				//ID
				employ.setEmployeeID(id);

				hm = dataScan.next();
				hd = dataScan.next();
				hy = dataScan.next();
				
				//Hire Date
				employ.setHireDate(hm, hd, hy);
				
				dataScan.next();
				
				street = dataScan.next();
				town = dataScan.next();
				st = dataScan.next();
				zip = dataScan.next();
				
				//Address
				employ.setHomeAddress(street, town, st, zip);

				contact = dataScan.next();
				
				//Phone Number
				employ.setContactNumber(contact.substring(0,3), contact.substring(3,6), contact.substring(6,10));
				
				dobM = dataScan.next();
				dobD = dataScan.next();
				dobY = dataScan.next();
				
				employ.setDateOfBirth(dobM, dobD, dobY);
				gender = dataScan.next();
				
				//Gender
				employ.setGender(gender);

				list.add(employ);
			}
			
			return list;
	}

}
