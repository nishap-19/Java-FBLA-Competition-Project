

//***********************************************************************
//FECEmployeeRoster.java     Name: Nisha Patel     Last Update: 01/04/17
//
//add, update, and delete employee information
//***********************************************************************

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import javax.swing.text.Document;

//************************************************************
//fecEmployees4.java     Name: Nisha Patel     Date: 11/24/16
//
//prints out a list of information on fec employees
//************************************************************


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class FECEmployeeRoster extends JPanel{
	
		List<fecEmployeeData> employees = GatherFECEmployees.getEmployees();
		
		public FECEmployeeRoster() throws IOException{
			
			JTable table = new JTable();
			
			//name of each column
			Object[] columns = {"Employee Id", "First Name", "Middle", "Last Name", "Hire Date",
					"Street", "City", "State", "Zip code", "Phone Number", "Date of Birth", "Sex"};
			DefaultTableModel model = new DefaultTableModel();
			model.setColumnIdentifiers(columns);
			table.setModel(model);
			table.getTableHeader().setReorderingAllowed(false);
			
			table.setBackground(Color.black);
			table.setForeground(Color.green);
			Font font = new Font("",1,18);
			table.setFont(font);
			table.setRowHeight(30);
			
			//JLabel
			JLabel employeeID = new JLabel("Employee Id");
			JLabel fName = new JLabel("First Name");
			JLabel mName = new JLabel("Middle Initial");
			JLabel lName = new JLabel("Last Name");
			JLabel hDate = new JLabel("Hire Date");
			JLabel h1 = new JLabel("\\");
			JLabel h2 = new JLabel("\\");
			JLabel streetAddress = new JLabel("Street Address");
			JLabel city = new JLabel("City");
			JLabel state = new JLabel("State Abrreviation");
			JLabel zipCode = new JLabel("Zip Code");
			JLabel number = new JLabel("Phone Number");
			JLabel x1 = new JLabel ("(");
			JLabel x2 = new JLabel (")");
			JLabel x3 = new JLabel ("-");
			JLabel dob = new JLabel("Date of Birth");
			JLabel d1 = new JLabel("\\");
			JLabel d2 = new JLabel("\\");
			JLabel sex = new JLabel("Sex");
			
			//JTextField
			JTextField textId = new JTextField();
			textId.setDocument(new CharLimiter(6));
			JTextField textFname = new JTextField();
			textFname.setDocument(new CharLimiter(25));
			JTextField textMname = new JTextField();
			textMname.setDocument(new CharLimiter(1));
			JTextField textLname = new JTextField();
			textLname.setDocument(new CharLimiter(25));
			JTextField textHM = new JTextField();
			textHM.setDocument(new CharLimiter(2));
			JTextField textHD = new JTextField();
			textHD.setDocument(new CharLimiter(2));
			JTextField textHY = new JTextField();
			textHY.setDocument(new CharLimiter(4));
			JTextField textStreet = new JTextField();
			textStreet.setDocument(new CharLimiter(100));
			JTextField textCity = new JTextField();
			textCity.setDocument(new CharLimiter(25));
			JTextField textState = new JTextField();
			textState.setDocument(new CharLimiter(15));
			textState.setDocument(new CharLimiter(2));
			JTextField textZip = new JTextField();
			textZip.setDocument(new CharLimiter(15));
			JTextField textAC = new JTextField();
			textAC.setDocument(new CharLimiter(3));
			JTextField textM3 = new JTextField();
			textM3.setDocument(new CharLimiter(3));
			JTextField textL4 = new JTextField();
			textL4.setDocument(new CharLimiter(4));
			JTextField textDOB = new JTextField();
			JTextField textBM = new JTextField();
			textBM.setDocument(new CharLimiter(2));
			JTextField textBD = new JTextField();
			textBD.setDocument(new CharLimiter(2));
			JTextField textBY = new JTextField();
			textBY.setDocument(new CharLimiter(4));
			JTextField textSex = new JTextField();
			
			Font btnFont = new Font("",1,14);
			
			//JButton
			JButton btnAdd = new JButton("Add");
			btnAdd.setFont(btnFont);
			btnAdd.setBackground(Color.black);
			btnAdd.setForeground(Color.cyan);
			JButton btnDelete = new JButton("Delete");
			btnDelete.setFont(btnFont);
			btnDelete.setBackground(Color.black);
			btnDelete.setForeground(Color.cyan);
			JButton btnUpdate = new JButton("Update");
			btnUpdate.setFont(btnFont);
			btnUpdate.setBackground(Color.black);
			btnUpdate.setForeground(Color.cyan);
			JButton btnSaveReturn = new JButton("Save and Return to FEC Employees");
			btnSaveReturn.setFont(btnFont);
			btnSaveReturn.setBackground(Color.black);
			btnSaveReturn.setForeground(Color.cyan);
			JButton btnSaveHome = new JButton("Save and Return to FEC Home");
			btnSaveHome.setFont(btnFont);
			btnSaveHome.setBackground(Color.black);
			btnSaveHome.setForeground(Color.cyan);
			
			//location and size of JLabel
			employeeID.setBounds(10, 360, 100, 25);
			fName.setBounds(10, 390, 100, 25);
			mName.setBounds(220, 390, 100, 25);
			lName.setBounds(350, 390, 100, 25);
			hDate.setBounds(10, 420, 100, 25);
			h1.setBounds(130, 420, 50, 25);
			h2.setBounds(170, 420, 50, 25);
			streetAddress.setBounds(10, 450, 100, 25);
			city.setBounds(280, 450, 100, 25);
			state.setBounds(430, 450, 110, 25);
			zipCode.setBounds(590, 450, 100, 25);
			number.setBounds(10, 480, 100, 25);
			x1.setBounds(110, 480, 50, 25);
			x2.setBounds(155, 480, 50, 25);
			x3.setBounds(215, 480, 50, 25);
			dob.setBounds(10, 510, 100, 25);
			d1.setBounds(130, 510, 50, 25);
			d2.setBounds(170, 510, 50, 25);
			sex.setBounds(10, 540, 100, 25);
			
			//location and size of JTextField
			textId.setBounds(100, 360, 100, 25);
		    textFname.setBounds(100, 390, 100, 25);
		    textMname.setBounds(300, 390, 30, 25);
		    textLname.setBounds(420, 390, 100, 25);
		    textHM.setBounds(100, 420, 25, 25);
			textHD.setBounds(140, 420, 25, 25);
			textHY.setBounds(180, 420, 35, 25);
		    textStreet.setBounds(100, 450, 160, 25);
		    textCity.setBounds(310, 450, 100, 25);
		    textState.setBounds(540, 450, 30, 25);
		    textZip.setBounds(650, 450, 90, 25);
		    textAC.setBounds(120, 480, 30, 25);
		    textM3.setBounds(175, 480, 30, 25);
		    textL4.setBounds(230, 480, 40, 25);
		    textBM.setBounds(100, 510, 25, 25);
			textBD.setBounds(140, 510, 25, 25);
			textBY.setBounds(180, 510, 35, 25);
		    textSex.setBounds(100, 540, 100, 25);
		      
		    //location and size of JButton
		    btnAdd.setBounds(1080, 360, 100, 25);
		    btnUpdate.setBounds(1080, 390, 100, 25);
		    btnDelete.setBounds(1080, 420, 100, 25);
		    btnSaveReturn.setBounds(900, 530, 290, 25);
		    btnSaveHome.setBounds(900, 560, 290, 25);
		    
		    //JScrollPane
		    JScrollPane pane = new JScrollPane(table);
	        pane.setBounds(0, 0, 1200, 350);
	        
	        frame.setLayout(null);
	        
	        frame.add(pane);
	        
	        //add JLabel
	        frame.add(employeeID);
	        frame.add(fName);
	        frame.add(mName);
	        frame.add(lName);
	        frame.add(hDate);
	        frame.add(h1);
	        frame.add(h2);
	        frame.add(streetAddress);
	        frame.add(city);
	        frame.add(state);
	        frame.add(zipCode);
	        frame.add(number);
	        frame.add(x1);
	        frame.add(x2);
	        frame.add(x3);
	        frame.add(dob);
	        frame.add(d1);
	        frame.add(d2);
	        frame.add(sex);
	        
	        //add JTextFields to jframe
	        frame.add(textId);
	        frame.add(textFname);
	        frame.add(textMname);
	        frame.add(textLname);
	        frame.add(textHM);
	        frame.add(textHD);
	        frame.add(textHY);
	        frame.add(textStreet);
	        frame.add(textCity);
	        frame.add(textState);
	        frame.add(textZip);
	        frame.add(textAC);
	        frame.add(textM3);
	        frame.add(textL4);
	        frame.add(textDOB);
	        frame.add(textBM);
	        frame.add(textBD);
	        frame.add(textBY);
	        frame.add(textSex);
	        
	        //add JButtons to jframe
	        frame.add(btnAdd);
	        frame.add(btnDelete);
	        frame.add(btnUpdate);
	        frame.add(btnSaveReturn);
	        frame.add(btnSaveHome);
			
	        Object[] row = new Object[12];
			
			for(int index = 0; index < employees.size(); index++){
			
				//ID
				row[0] = employees.get(index).getEmployeeID();
				
				//Name
				row[1] = employees.get(index).getFName();
				row[2] = employees.get(index).getMInitial();
				row[3] = employees.get(index).getLName();

				//Hire Date;
				row[4] = employees.get(index).getHireDate();
				
				//Address
				row[5] = employees.get(index).getStreetAddress();
                row[6] = employees.get(index).getCity();
                row[7] = employees.get(index).getState();
                row[8] = employees.get(index).getZipCode();
				
				//Phone Number
				row[9] = employees.get(index).getContactNumber();

				//Date of Birth
				row[10] = employees.get(index).getDateOfBirth();
				
				//Gender);
				row[11] = employees.get(index).getGender();

				model.addRow(row);
			}
	        
	        //button add row
	        btnAdd.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	             
	            	if(textId.getText().isEmpty() || textFname.getText().isEmpty()|| textMname.getText().isEmpty()|| textLname.getText().isEmpty() || textHM.getText().isEmpty() 
	            			|| textHD.getText().isEmpty() || textHY.getText().isEmpty() || textStreet.getText().isEmpty() || textCity.getText().isEmpty() || textState.getText().isEmpty() 
	            			|| textZip.getText().isEmpty() ||textAC.getText().isEmpty() || textM3.getText().isEmpty() ||textL4.getText().isEmpty() || textBM.getText().isEmpty() 
	            			|| textBD.getText().isEmpty() || textBY.getText().isEmpty() || textSex.getText().isEmpty())
	            		JOptionPane.showMessageDialog(null, "Please make sure all data fields are completed.");
	            	else{
	            	fecEmployeeData add = new fecEmployeeData(textFname.getText().toString(), textMname.getText().toString(), textLname.getText().toString());
	            	
	                row[0] = textId.getText();
	                row[1] = textFname.getText();
	                row[2] = textMname.getText();
	                row[3] = textLname.getText();
	                row[4] = textHM.getText() + "/" + textHD.getText() + "/" + textHY.getText();
	                row[5] = textStreet.getText();
	                row[6] = textCity.getText();
	                row[7] = textState.getText();
	                row[8] = textZip.getText();
	                row[9] = "(" + textAC.getText() + ") " + textM3.getText() + "-" + textL4.getText();
	                row[10] = textBM.getText() + "/" + textBD.getText() + "/" + textBY.getText();
	                row[11] = textSex.getText();
	                
	                
	                add.setEmployeeID(textId.getText().toString());
	                
		            add.setHireDate(textHM.getText().toString(), textHD.getText().toString(), textHY.getText().toString());
	                
	                add.setHomeAddress(textStreet.getText().toString(), textCity.getText().toString(), textState.getText().toString(), textZip.getText().toString());
	                
	                add.setContactNumber(textAC.getText(), textM3.getText(), textL4.getText());
	                
		            add.setDateOfBirth(textBM.getText().toString(), textBD.getText().toString(), textBY.getText().toString());
	                
	                add.setGender(textSex.getText().toString());
	                
	                // add row to the model
	                model.addRow(row);
	                employees.add(add);
	            	}
	            }
	            
	        });
	      //------------------------------------------------------------------------------------
	        
	        //button remove row
	        btnDelete.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	                fecEmployeeData remove = new fecEmployeeData();
	                String employee;
	                int refNumber = 0;
	                
	                employee = textId.getText().toString();
	                refNumber = remove.findEmployee(employees, employee);
	                try{
	   			    remove = employees.get(refNumber);
	                
	                employees.remove(remove);
	            	
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                if(i >= 0){
	                    // remove a row from jtable
	                    model.removeRow(i);
	                }
	                else{
	                    System.out.println("Delete Error");
	                }
	                }
	                catch(IndexOutOfBoundsException e1){
	                	JOptionPane.showMessageDialog(null, "Please select an employes to delete.");
	                }
	                
	            }
	        });
	        
	        // get selected row data From table to textfields 
	        table.addMouseListener(new MouseAdapter(){
	        
	        @Override
	        public void mouseClicked(MouseEvent e){
	            
	            // i = the index of the selected row
	            int i = table.getSelectedRow();
	            
	            textId.setText(model.getValueAt(i, 0).toString());
	            textFname.setText(model.getValueAt(i, 1).toString());
	            textMname.setText(model.getValueAt(i, 2).toString());
	            textLname.setText(model.getValueAt(i, 3).toString());
	            textHM.setText((model.getValueAt(i, 4).toString()).substring(0,2));
	            textHD.setText((model.getValueAt(i, 4).toString()).substring(3,5));
	            textHY.setText((model.getValueAt(i, 4).toString()).substring(6,10));
	            textStreet.setText(model.getValueAt(i, 5).toString());
	            textCity.setText(model.getValueAt(i,  6).toString());
	            textState.setText(model.getValueAt(i, 7).toString());
	            textZip.setText(model.getValueAt(i, 8).toString());
	            textAC.setText((model.getValueAt(i, 9).toString()).substring(1, 4));
	            textM3.setText((model.getValueAt(i,  9).toString()).substring(6,9));
	            textL4.setText((model.getValueAt(i, 9).toString()).substring(10,14));
	            textBM.setText((model.getValueAt(i, 10).toString()).substring(0,2));
	            textBD.setText((model.getValueAt(i, 10).toString()).substring(3,5));
	            textBY.setText((model.getValueAt(i, 10).toString()).substring(6,10));
	            textSex.setText(model.getValueAt(i, 11).toString());
	        }
	        });
	        
	        //button update row
	        btnUpdate.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	            	
	            	fecEmployeeData update = new fecEmployeeData();
	            	String employee;
		            int refNumber;
		            
		            employee = textId.getText().toString();
	                refNumber = update.findEmployee(employees, employee);
	                try{
		    		update = employees.get(refNumber);
	                
		    		
	                // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                //sets updated information to display in table
	                if(i >= 0) 
	                {
	                   model.setValueAt(textId.getText(), i, 0);
	                   model.setValueAt(textFname.getText(), i, 1);
	                   model.setValueAt(textMname.getText(), i, 2);
	                   model.setValueAt(textLname.getText(), i, 3);
	                   model.setValueAt(textHM.getText() + "/" + textHD.getText() + "/" + textHY.getText(), i, 4);
	                   model.setValueAt(textStreet.getText(), i, 5);
	                   model.setValueAt(textCity.getText(), i, 6);
	                   model.setValueAt(textState.getText(), i, 7);
	                   model.setValueAt(textZip.getText(), i, 8);
	                   model.setValueAt("(" + textAC.getText() + ") " + textM3.getText() + "-" + textL4.getText(), i, 9);
	                   model.setValueAt(textBM.getText() + "/" + textBD.getText() + "/" + textBY.getText(), i, 10);
	                   model.setValueAt(textSex.getText(), i, 11);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		            
	                //sets updated information to array list
	                update.setFName(textFname.getText().toString());
	                
	                update.setMidInit(textMname.getText().toString());
	                
	                update.setLName(textLname.getText().toString());
	                
	                update.setEmployeeID(textId.getText().toString());
	                
		            update.setHireDate(textHM.getText().toString(), textHD.getText().toString(), textHY.getText().toString());
	                
	                update.setHomeAddress(textStreet.getText().toString(), textCity.getText().toString(), textState.getText().toString(), textZip.getText().toString());
	                
	                update.setContactNumber(textAC.getText(), textM3.getText(), textL4.getText());
	                
		            update.setDateOfBirth(textBM.getText().toString(), textBD.getText().toString(), textBY.getText().toString());
	                
	                update.setGender(textSex.getText().toString());
	                
	                employees.set(refNumber, update);
	                }
	                catch(IndexOutOfBoundsException e1){
	                	JOptionPane.showMessageDialog(null, "Please select an employee or create a new employee entry."
	                			+ "\nNote: You cannot update the employee ID");
	                }
	            }
	        });
	        
	        btnSaveReturn.addActionListener(new ActionListener(){

	              @Override
	              public void actionPerformed(ActionEvent e) {
	      			
	            		  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Employees screen?", "Verificatin Screen", JOptionPane.YES_NO_OPTION);
	     					
	  	            	if (confirm == JOptionPane.YES_OPTION)
	  	            	{
	  	            	
	  	    			try{
	  	    	             // create new file
	  	    	             File file = new File(System.getProperty("user.dir") + "/Employees.txt");

	  	    	                // if file doesnt exists, then create it
	  	    	                if (!file.exists()) {
	  	    	                    file.createNewFile();
	  	    	                }
	  	    	                
	  	    	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
	  	    	                BufferedWriter bw = new BufferedWriter(fw);
	  	    	                // write in file
	  	    	                
	  	    	                for (fecEmployeeData employed : employees)
	  	    	    			{
	  	    	    				//System.out.println(employed.sendDataToFile());
	  	    	    				bw.write(employed.sendDataToFile() + "\n");
	  	    	    			}
	  	    	                // close connection
	  	    	                bw.close();
	  	    	          }catch(Exception error){
	  	    	              System.out.println(error);
	  	    	          }
	  	                frame.dispose();
	  	                
	  	                try {
	  						fecEmployees.toEmployees();
	  					} catch (IOException e1) {
	  						e1.printStackTrace();
	  					}
	  	            }
	  	            }
	          });
	          
	        
	        btnSaveHome.addActionListener(new ActionListener(){

	            @Override
	            public void actionPerformed(ActionEvent e) {
	    			
	            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Home Page?", "Verificatin Screen", JOptionPane.YES_NO_OPTION);
					
	            	if (confirm == JOptionPane.YES_OPTION)
	            	{
	            	
	    			try{
	    	             // create new file
	    	             File file = new File(System.getProperty("user.dir") + "/Employees.txt");

	    	                // if file doesnt exists, then create it
	    	                if (!file.exists()) {
	    	                    file.createNewFile();
	    	                }
	    	                
	    	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    	                BufferedWriter bw = new BufferedWriter(fw);
	    	                // write in file
	    	                
	    	                for (fecEmployeeData employed : employees)
	    	    			{
	    	    				//System.out.println(employed.sendDataToFile());
	    	    				bw.write(employed.sendDataToFile() + "\n");
	    	    			}
	    	                // close connection
	    	                bw.close();
	    	          }catch(Exception error){
	    	              System.out.println(error);
	    	          }
	                frame.dispose();
	                
	                try {
						FECMainScreen.toMainGUI();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
	            }
	            }
	        });
	        
	        //adjusts the column width in the JTable
	        TableColumnModel columnModel = table.getColumnModel();
	        
	        columnModel.getColumn(0).setPreferredWidth(40);
	        columnModel.getColumn(1).setPreferredWidth(60);
	        columnModel.getColumn(2).setPreferredWidth(5);
	        columnModel.getColumn(3).setPreferredWidth(60);
	        columnModel.getColumn(4).setPreferredWidth(65);
	        columnModel.getColumn(5).setPreferredWidth(160);
	        columnModel.getColumn(6).setPreferredWidth(65);
	        columnModel.getColumn(7).setPreferredWidth(5);
	        columnModel.getColumn(8).setPreferredWidth(30);
	        columnModel.getColumn(9).setPreferredWidth(100);
	        columnModel.getColumn(10).setPreferredWidth(65);
	        columnModel.getColumn(11).setPreferredWidth(35);
	        
		}

		private static JFrame frame;
		
		
		private static void createAndShowRoster() throws IOException {
	        //Create and set up the window.
			
			frame = new JFrame("Family Entertainment Center");
			
			frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			frame.setResizable(false);
			
	        //Set up the content pane.
			JComponent roster = new FECEmployeeRoster();
	        roster.setOpaque(true);
			
	        frame.add(roster);
	        //Display the window.
	        frame.setSize(1205, 640);
	        frame.setLocationRelativeTo(null);
	        frame.setVisible(true);
	    }
		
		public static void toRoster() throws IOException
		{
			createAndShowRoster();
		}
			
		public static void main(String[] args) {

			javax.swing.SwingUtilities.invokeLater(new Runnable() 
			{
				public void run()
					{
						try {
							createAndShowRoster();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
			}
		);
		}
	}
