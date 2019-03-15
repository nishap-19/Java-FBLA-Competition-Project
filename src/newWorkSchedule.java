
//********************************************************************
//newWorkSchedule.java     Name: Nisha Patel    Last Update: 01/07/17
//
//GUI that allows the user to create a new employee work schedule
//*********************************************************************

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class newWorkSchedule extends JPanel{

	static String startTime, endTime;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public newWorkSchedule(String week) throws IOException {

		JTable table = new JTable();
		
		Object[] columns = {"Employee ID", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
		DefaultTableModel model = new DefaultTableModel();
		model.setColumnIdentifiers(columns);
		table.setModel(model);
		table.getTableHeader().setReorderingAllowed(false);
		
		table.setBackground(Color.black);
		table.setForeground(Color.green);
		Font font = new Font("",1,21);
		table.setFont(font);
		table.setRowHeight(30);
		
		//-------------------------------------------------
		
		JLabel weekly = new JLabel("Week Of: " + week.substring(0,2) + "/" + week.substring(2,4) + "/" + week.substring(4,8));
		
		weekly.setBounds(0, 5, 300, 20);
		Font weekFont = new Font("",1,25);
		weekly.setFont(weekFont);
		
		frame.add(weekly);
		
		//-------------------------------------------------
		
	    JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 30, 1200, 300);
        
        frame.setLayout(null);
        
        frame.add(scrollPane);
		
        Font labelFont = new Font("",1,15);
        
        //JLabel
        JLabel employeeId = new JLabel("Employee ID");
        employeeId.setFont(labelFont);
        JLabel Monday = new JLabel("Monday");
        Monday.setFont(labelFont);
		JLabel Tuesday = new JLabel("Tuesday");
		Tuesday.setFont(labelFont);
		JLabel Wednesday = new JLabel("Wednesday");
		Wednesday.setFont(labelFont);
		JLabel Thursday = new JLabel("Thursday");
		Thursday.setFont(labelFont);
		JLabel Friday = new JLabel("Friday");
		Friday.setFont(labelFont);
		JLabel Saturday = new JLabel("Saturday");
		Saturday.setFont(labelFont);
		
		 Font textFont = new Font("",1,14);
		
        //JTextField
		JTextField textId = new JTextField();
		textId.setEnabled(false);
		textId.setFont(textFont);
		textId.setBackground(Color.black);
        
		//JComboBox
		JComboBox monOps = new JComboBox();
		monOps.addItem("Work Hours");
		monOps.addItem("Day Off");
		monOps.addItem("Request Off");
		JComboBox tueOps = new JComboBox();
		tueOps.addItem("Work Hours");
		tueOps.addItem("Day Off");
		tueOps.addItem("Request Off");
		JComboBox wedOps = new JComboBox();
		wedOps.addItem("Work Hours");
		wedOps.addItem("Day Off");
		wedOps.addItem("Request Off");
		JComboBox thurOps = new JComboBox();
		thurOps.addItem("Work Hours");
		thurOps.addItem("Day Off");
		thurOps.addItem("Request Off");
		JComboBox friOps = new JComboBox();
		friOps.addItem("Work Hours");
		friOps.addItem("Day Off");
		friOps.addItem("Request Off");
		JComboBox satOps = new JComboBox();
		satOps.addItem("Work Hours");
		satOps.addItem("Day Off");
		satOps.addItem("Request Off");
		
      //JButton
      JButton btnAdd1 = new JButton("Add");
      btnAdd1.setBackground(Color.blue);
      btnAdd1.setForeground(Color.white);
      JButton btnAdd2 = new JButton("Add");
      btnAdd2.setBackground(Color.blue);
      btnAdd2.setForeground(Color.white);
      JButton btnAdd3 = new JButton("Add");
      btnAdd3.setBackground(Color.blue);
      btnAdd3.setForeground(Color.white);
      JButton btnAdd4 = new JButton("Add");
      btnAdd4.setBackground(Color.blue);
      btnAdd4.setForeground(Color.white);
      JButton btnAdd5 = new JButton("Add");
      btnAdd5.setBackground(Color.blue);
      btnAdd5.setForeground(Color.white);
      JButton btnAdd6 = new JButton("Add");
      btnAdd6.setBackground(Color.blue);
      btnAdd6.setForeground(Color.white);
      
      Font btnfont = new Font("",1,14);
      
		JButton btnSaveReturn = new JButton("Save and Return to Schedule Selector");
		btnSaveReturn.setFont(btnfont);
		btnSaveReturn.setForeground(Color.cyan);
		btnSaveReturn.setBackground(Color.black);
		JButton btnSaveHome = new JButton("Save and Return to FEC Home Page");
		btnSaveHome.setFont(btnfont);
		btnSaveHome.setForeground(Color.cyan);
		btnSaveHome.setBackground(Color.black);
        
        //location and size of JLabel
		employeeId.setBounds(10, 340, 100, 25);
		Monday.setBounds(140, 340, 120, 25);
		Tuesday.setBounds(320, 340, 120, 25);
		Wednesday.setBounds(500, 340, 120, 25);
		Thursday.setBounds(680, 340, 120, 25);
		Friday.setBounds(860, 340, 120, 25);
		Saturday.setBounds(1040, 340, 120, 25);
		
		//location and size of JTextField
		textId.setBounds(10, 370, 100, 25);
		
		//location and size of JComboBox
		monOps.setBounds(140, 370, 120, 25);
		tueOps.setBounds(320, 370, 120, 25);
		wedOps.setBounds(500, 370, 120, 25);
		thurOps.setBounds(680, 370, 120, 25);
		friOps.setBounds(860, 370, 120, 25);
		satOps.setBounds(1040, 370, 120, 25);
		
		//location and size of JButton
		btnAdd1.setBounds(140, 400, 120, 25);
		btnAdd2.setBounds(320, 400, 120, 25);
	    btnAdd3.setBounds(500, 400, 120, 25);
	    btnAdd4.setBounds(680, 400, 120, 25);
	    btnAdd5.setBounds(860, 400, 120, 25);
	    btnAdd6.setBounds(1040, 400, 120, 25);
	    btnSaveReturn.setBounds(810, 570, 350, 25);
	    btnSaveHome.setBounds(810, 600, 350, 25);
		
	    //add JLabel to JFrame
	    frame.add(employeeId);
	    frame.add(Monday);
	    frame.add(Tuesday);
	    frame.add(Wednesday);
	    frame.add(Thursday);
	    frame.add(Friday);
	    frame.add(Saturday);
	    
	    //add JTextField to JFrame
	    frame.add(textId);
	    
	    //add JComboBox to JFrame
	    frame.add(monOps);
	    frame.add(tueOps);
	    frame.add(wedOps);
	    frame.add(thurOps);
	    frame.add(friOps);
	    frame.add(satOps);
	    
		//add JButton to JFrame
		frame.add(btnAdd1);
		frame.add(btnAdd2);
		frame.add(btnAdd3);
		frame.add(btnAdd4);
		frame.add(btnAdd5);
		frame.add(btnAdd6);
		frame.add(btnSaveHome);
		frame.add(btnSaveReturn);
        
        //--------------------------------------------------------------------------
        
        Object[] row = new Object[7];
		
        List<fecEmployeeData> allEmployed = GatherFECEmployees.getEmployees();
        
		ArrayList<WorkDays> employees = new ArrayList<WorkDays>();
		
		WorkDays hours;
        
		for(int index = 0; index < allEmployed.size(); index++){
			
			hours = new WorkDays(allEmployed.get(index).getEmployeeID());
			
			employees.add(hours);
			
			row[0] = employees.get(index).getEmployeeID();

			model.addRow(row);
		}
		
		//--------------------------------------------------------------------------
		
		 // get selected row data From table to textfields 
        table.addMouseListener(new MouseAdapter(){
        
        @Override
        public void mouseClicked(MouseEvent e){
            
            // i = the index of the selected row
            int i = table.getSelectedRow();
            
            textId.setText(model.getValueAt(i, 0).toString());
        }
        });
        
        //button update Monday-------------------------------------------------
        btnAdd1.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);	
                
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = monOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set new work hours employee's schedule for Monday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();
							
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
		            	if((startTime.length() != 4) || (endTime.length() != 4))
		            	{
		            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
		            	}
		            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addMonday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getMonHours(), i, 1);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Monday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addMonday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getMonHours(), i, 1);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		//set Request Off on the employee's schedule for Monday
	    		else
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addMonday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getMonHours(), i, 1);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
            }
   		catch(IndexOutOfBoundsException e1){
         	JOptionPane.showMessageDialog(null, "Please select an employee.");
         }
            }
        });
		
        //button update Tuesday------------------------------------------------
        btnAdd2.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);
                
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = tueOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set new work hours for employee's schedule for Tuesday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();

							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
		            	if((startTime.length() != 4) || (endTime.length() != 4))
		            	{
		            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
		            	}
		            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addTuesday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getTueHours(), i, 2);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Tuesday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addTuesday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getTueHours(), i, 2);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		//set Request Off on the employee's schedule for Tuesday
	    		else
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addTuesday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getTueHours(), i, 2);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
            }
   		catch(IndexOutOfBoundsException e1){
         	JOptionPane.showMessageDialog(null, "Please select an employee.");
         }
            }
        });
        
        //button update Wednesday------------------------------------------------
        btnAdd3.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);
                
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = wedOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set work new work hours for employee's schedule for Wednesday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();
							
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
		            	if((startTime.length() != 4) || (endTime.length() != 4))
		            	{
		            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
		            	}
		            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addWednesday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getWedHours(), i, 3);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Wednesday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addWednesday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getWedHours(), i, 3);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		else
		    	//set Request Off on the employee's schedule for Wednesday
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addWednesday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getWedHours(), i, 3);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
            }
   		catch(IndexOutOfBoundsException e1){
         	JOptionPane.showMessageDialog(null, "Please select an employee.");
         }
            }
        });
        
        //button update Thursday-----------------------------------------------
        btnAdd4.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);	
                
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = thurOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set new work hours for employee's schedule for Thursday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();
							
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
		            	if((startTime.length() != 4) || (endTime.length() != 4))
		            	{
		            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
		            	}
		            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addThursday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getThurHours(), i, 4);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Thursday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addThursday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getThurHours(), i, 4);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		//set Request Off on the employee's schedule for Thursday
	    		else
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addThursday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getThurHours(), i, 4);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
            }
   		catch(IndexOutOfBoundsException e1){
         	JOptionPane.showMessageDialog(null, "Please select an employee.");
         }
            }
        });
		
      //button update Friday-------------------------------------------------
        btnAdd5.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);	
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = friOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set new work hours for employee's schedule for Friday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();
							
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
		            	if((startTime.length() != 4) || (endTime.length() != 4))
		            	{
		            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
		            	}
		            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addFriday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getFriHours(), i, 5);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Friday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addFriday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getFriHours(), i, 5);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		//set Request Off on the employee's schedule for Friday
	    		else
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addFriday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getFriHours(), i, 5);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
            }
   		catch(IndexOutOfBoundsException e1){
         	JOptionPane.showMessageDialog(null, "Please select an employee.");
         }
            }
        });
        
      //button update Saturday-----------------------------------------------
        btnAdd6.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	WorkDays update = new WorkDays();
            	
            	String employee, start = "", end = "";
	            int refNumber;
	            
	            employee = textId.getText();
                refNumber = update.findEmployee(employees, employee);
                
                try{
	    		update = employees.get(refNumber);
            	
	    		//--------------------------------------------------------------
	    		
            	String selection = "";
				String selected = satOps.getSelectedItem().toString();
				
				if (selected == null)
					selection = "Work Hours";
				else
					selection = selected;
            	
	    		//set new work hours for employee's schedule for Saturday
	    		if (selection.equals("Work Hours"))
	    		{
	    			JFrame hours = new JFrame("Work Hours");
	    			hours.setResizable(false);
	    			
	    			hours.setLayout(new GridLayout(0,1));
	    			
	    			JLabel begin = new JLabel("Start Time");
	    			JLabel finish = new JLabel("End Time");
	    			JLabel sample = new JLabel("Use format 0000");
	    			
	    			JTextField textBegin = new JTextField();
	    			textBegin.setDocument(new CharLimiter(4));
	    			JTextField textFinish = new JTextField();
	    			textFinish.setDocument(new CharLimiter(4));
	    			
	    			JButton change = new JButton("Change");
	    			
	    			hours.add(begin);
	    			hours.add(textBegin);
	    			hours.add(finish);
	    			hours.add(textFinish);
	    			hours.add(sample);
	    			hours.add(change);
	    			
	    			hours.setSize(300, 150);;
	    			hours.setLocationRelativeTo(null);
	    	        hours.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	    	        hours.setVisible(true);

	    	        change.addActionListener(new ActionListener(){
	    				
	    	            @Override
	    	            public void actionPerformed(ActionEvent e) {
	    	            	
							startTime = textBegin.getText().toString();
							endTime = textFinish.getText().toString();
							
							int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct time?", "Verification Screen", JOptionPane.YES_NO_OPTION);
							
			            	if((startTime.length() != 4) || (endTime.length() != 4))
			            	{
			            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format 0000");
			            	}
			            	else{
							
							//------------------------------------------------
							WorkDays update = new WorkDays();
			            	
			            	String employee;
				            int refNumber;
				            
				            employee = textId.getText();
			                refNumber = update.findEmployee(employees, employee);	
				    		update = employees.get(refNumber);
							
							update.addSaturday(startTime, endTime);
				    		
				    		 // i = the index of the selected row
			                int i = table.getSelectedRow();
			                
			                if(i >= 0) 
			                {
			                   model.setValueAt(update.getSatHours(), i, 6);
			                }
			                else{
			                    System.out.println("Update Error");
			                }
				    		
			                
			                employees.set(refNumber, update);
							//------------------------------------------------
							
							hours.dispose();
	    	            }
	    	            }
	    			});	
	    		}
	    		//set Day Off on the employee's schedule for Saturday
	    		else if (selection.equals("Day Off"))
	    		{
	    			start = "Day";
	    			end = "Off";
	    			
		    		update.addSaturday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getSatHours(), i, 6);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
	    		//set Request Off on the employee's schedule for Saturday
	    		else
	    		{
	    			start = "Request";
	    			end = "Off";
	    			
		    		update.addSaturday(start, end);
		    		
		    		 // i = the index of the selected row
	                int i = table.getSelectedRow();
	                
	                if(i >= 0) 
	                {
	                   model.setValueAt(update.getSatHours(), i, 6);
	                }
	                else{
	                    System.out.println("Update Error");
	                }
		    		
	                
	                employees.set(refNumber, update);
	    		}
                }
	    		catch(IndexOutOfBoundsException e1){
             	JOptionPane.showMessageDialog(null, "Please select an employee.");
             }
            }
        });
        
        btnSaveReturn.addActionListener(new ActionListener(){

        	@Override
            public void actionPerformed(ActionEvent e) {
    			
                  File folder = new File(System.getProperty("user.dir") + "/Schedules/");
         			
                  if (!folder.exists())
                		folder.mkdir();
            		
    			try{
    	             // create new file
    	             File file = new File(System.getProperty("user.dir") + "/Schedules/" + week + ".txt");

    	                // if file doesnt exists, then create it
    	                if (!file.exists()) {
    	                    file.createNewFile();
    	                }
    	                
    	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	                BufferedWriter bw = new BufferedWriter(fw);
    	                // write in file
    	                
    	                for (WorkDays allHours : employees)
    	    			{
    	    				//System.out.println(allHours.sendScheduleToFile());
    	    				bw.write(allHours.sendScheduleToFile() + "\n");
    	    			}
    	                // close connection
    	                bw.close();
    	          }catch(Exception error){
    	              System.out.println(error);
    	          }
    			//System.exit(0);
                frame.dispose();
                
                try {
					ScheduleSelector.toHours();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        
        btnSaveHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
    			
                  File folder = new File(System.getProperty("user.dir") + "/Schedules/");
         			
                  if (!folder.exists())
                		folder.mkdir();
            		
    			try{
    	             // create new file
    	             File file = new File(System.getProperty("user.dir") + "/Schedules/" + week + ".txt");

    	                // if file doesnt exists, then create it
    	                if (!file.exists()) {
    	                    file.createNewFile();
    	                }
    	                
    	                FileWriter fw = new FileWriter(file.getAbsoluteFile());
    	                BufferedWriter bw = new BufferedWriter(fw);
    	                // write in file
    	                
    	                for (WorkDays allHours : employees)
    	    			{
    	    				//System.out.println(allHours.sendScheduleToFile());
    	    				bw.write(allHours.sendScheduleToFile() + "\n");
    	    			}
    	                // close connection
    	                bw.close();
    	          }catch(Exception error){
    	              System.out.println(error);
    	          }
    			//System.exit(0);
                frame.dispose();
                
                try {
					FECMainScreen.toMainGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
        });
        
		//-------------------------------------------------------------------------
		
		 //adjusts the column width in the JTable
        TableColumnModel columnModel = table.getColumnModel();
        
        columnModel.getColumn(0).setPreferredWidth(60);
        columnModel.getColumn(1).setPreferredWidth(120);
        columnModel.getColumn(2).setPreferredWidth(120);
        columnModel.getColumn(3).setPreferredWidth(120);
        columnModel.getColumn(4).setPreferredWidth(120);
        columnModel.getColumn(5).setPreferredWidth(120);
        columnModel.getColumn(6).setPreferredWidth(120);
     
	}
	
	private static JFrame frame;
	
	private static void createAndShowCreate(String week) throws IOException {
        //Create and set up the window.
		
		frame = new JFrame("Family Entertainment Center");
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		frame.setResizable(false);
		
        //Set up the content pane.
		newWorkSchedule schedule = new newWorkSchedule(week);
        schedule.setOpaque(true);
        
        //frame.setContentPane(schedule);
       
        //Display the window.
        frame.setSize(1205, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	public static void toCreate(String week) throws IOException
	{
		createAndShowCreate(week);
	}

//	public static void main(String[] args) {
//
//		javax.swing.SwingUtilities.invokeLater(new Runnable() 
//		{
//			public void run()
//				{
//					try {
//						createAndShowCreate("02132017");
//					} catch (IOException e) {
//						e.printStackTrace();
//					}
//				}
//		}
//	);
//	}
	
}
