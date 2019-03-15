
//********************************************************************
//fecWorkSchedule.java     Name: Nisha Patel    Last Update: 01/04/17
//
//GUI displays a chosen work schedule and allows the user to edit its
//*********************************************************************

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
import java.util.Scanner;

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

public class fecWorkSchedule extends JPanel {
	
	static String startTime, endTime;
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public fecWorkSchedule(String week) throws IOException{
		
		JTable table = new JTable();
		
		//name of each column
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
		JTextField textMon = new JTextField();
		textMon.setEnabled(false);
		textMon.setFont(textFont);
		textMon.setBackground(Color.black);
		JTextField textTue = new JTextField();
		textTue.setEnabled(false);
		textTue.setFont(textFont);
		textTue.setBackground(Color.black);
		JTextField textWed = new JTextField();
		textWed.setEnabled(false);
		textWed.setFont(textFont);
		textWed.setBackground(Color.black);
		JTextField textThur = new JTextField();
		textThur.setEnabled(false);
		textThur.setFont(textFont);
		textThur.setBackground(Color.black);
		JTextField textFri = new JTextField();
		textFri.setEnabled(false);
		textFri.setFont(textFont);
		textFri.setBackground(Color.black);
		JTextField textSat = new JTextField();
		textSat.setEnabled(false);
		textSat.setFont(textFont);
		textSat.setBackground(Color.black);
        
		//JComboBox
		JComboBox monOps = new JComboBox();
		monOps.addItem("Change Hours");
		monOps.addItem("Day Off");
		monOps.addItem("Request Off");
		JComboBox tueOps = new JComboBox();
		tueOps.addItem("Change Hours");
		tueOps.addItem("Day Off");
		tueOps.addItem("Request Off");
		JComboBox wedOps = new JComboBox();
		wedOps.addItem("Change Hours");
		wedOps.addItem("Day Off");
		wedOps.addItem("Request Off");
		JComboBox thurOps = new JComboBox();
		thurOps.addItem("Change Hours");
		thurOps.addItem("Day Off");
		thurOps.addItem("Request Off");
		JComboBox friOps = new JComboBox();
		friOps.addItem("Change Hours");
		friOps.addItem("Day Off");
		friOps.addItem("Request Off");
		JComboBox satOps = new JComboBox();
		satOps.addItem("Change Hours");
		satOps.addItem("Day Off");
		satOps.addItem("Request Off");
		
        //JButton
        JButton btnUpdate1 = new JButton("Update");
        btnUpdate1.setBackground(Color.blue);
        btnUpdate1.setForeground(Color.white);
        JButton btnUpdate2 = new JButton("Update");
        btnUpdate2.setBackground(Color.blue);
        btnUpdate2.setForeground(Color.white);
        JButton btnUpdate3 = new JButton("Update");
        btnUpdate3.setBackground(Color.blue);
        btnUpdate3.setForeground(Color.white);
        JButton btnUpdate4 = new JButton("Update");
        btnUpdate4.setBackground(Color.blue);
        btnUpdate4.setForeground(Color.white);
        JButton btnUpdate5 = new JButton("Update");
        btnUpdate5.setBackground(Color.blue);
        btnUpdate5.setForeground(Color.white);
        JButton btnUpdate6 = new JButton("Update");
        btnUpdate6.setBackground(Color.blue);
        btnUpdate6.setForeground(Color.white);
		JButton btnDelete = new JButton("Delete Work Schedule");
		btnDelete.setBackground(Color.black);
		btnDelete.setForeground(Color.cyan);
		JButton btnSaveReturn = new JButton("Save and Return to All Schedules");
		btnSaveReturn.setBackground(Color.black);
		btnSaveReturn.setForeground(Color.cyan);
		JButton btnSaveHome = new JButton("Save and Return to FEC Home Page");
		btnSaveHome.setBackground(Color.black);
		btnSaveHome.setForeground(Color.cyan);
        
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
		textMon.setBounds(140, 370, 120, 25);
		textTue.setBounds(320, 370, 120, 25);
		textWed.setBounds(500, 370, 120, 25);
		textThur.setBounds(680, 370, 120, 25);
		textFri.setBounds(860, 370, 120, 25);
		textSat.setBounds(1040, 370, 120, 25);
		
		//location and size of JComboBox
		monOps.setBounds(140, 400, 120, 25);
		tueOps.setBounds(320, 400, 120, 25);
		wedOps.setBounds(500, 400, 120, 25);
		thurOps.setBounds(680, 400, 120, 25);
		friOps.setBounds(860, 400, 120, 25);
		satOps.setBounds(1040, 400, 120, 25);
		
		//location and size of JButton
		btnUpdate1.setBounds(140, 430, 120, 25);
	    btnUpdate2.setBounds(320, 430, 120, 25);
	    btnUpdate3.setBounds(500, 430, 120, 25);
	    btnUpdate4.setBounds(680, 430, 120, 25);
	    btnUpdate5.setBounds(860, 430, 120, 25);
	    btnUpdate6.setBounds(1040, 430, 120, 25);
	    btnDelete.setBounds(900, 520, 260, 25);
	    btnSaveReturn.setBounds(900, 560, 260, 25);
	    btnSaveHome.setBounds(900, 600, 260, 25);
		
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
	    frame.add(textMon);
	    frame.add(textTue);
	    frame.add(textWed);
	    frame.add(textThur);
	    frame.add(textFri);
	    frame.add(textSat);
	    
	    //add JComboBox to JFrame
	    frame.add(monOps);
	    frame.add(tueOps);
	    frame.add(wedOps);
	    frame.add(thurOps);
	    frame.add(friOps);
	    frame.add(satOps);
	    
		//add JButton to JFrame
		frame.add(btnUpdate1);
		frame.add(btnUpdate2);
		frame.add(btnUpdate3);
		frame.add(btnUpdate4);
		frame.add(btnUpdate5);
		frame.add(btnUpdate6);
		frame.add(btnDelete);
		frame.add(btnSaveReturn);
		frame.add(btnSaveHome);
        
        //--------------------------------------------------------------------------
        
        Object[] row = new Object[7];
		
		ArrayList<WorkDays> employees = PullAllSchedules.getSchedule(week);
        
		for(int index = 0; index < employees.size(); index++){
			
			row[0] = employees.get(index).getEmployeeID();

			row[1] = employees.get(index).getMonHours();

			row[2] = employees.get(index).getTueHours();

			row[3] = employees.get(index).getWedHours();

			row[4] = employees.get(index).getThurHours();

			row[5] = employees.get(index).getFriHours();
			
			row[6] = employees.get(index).getSatHours();

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
            textMon.setText(model.getValueAt(i, 1).toString());
            textTue.setText(model.getValueAt(i, 2).toString());
            textWed.setText(model.getValueAt(i, 3).toString());
            textThur.setText(model.getValueAt(i, 4).toString());
            textFri.setText(model.getValueAt(i, 5).toString());
            textSat.setText(model.getValueAt(i, 6).toString());
        }
        });
        
        //button update Monday-------------------------------------------------
        btnUpdate1.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
                	JOptionPane.showMessageDialog(null, "Please select an employees's work schedule.");
                }
            }
                
        });
		
        //button update Tuesday-----------------------------------------------
        btnUpdate2.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
                	JOptionPane.showMessageDialog(null, "Please select an employees's work schedule.");
                }
            }
        });
        
        //button update Wednesday------------------------------------------------
        btnUpdate3.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
		            		JOptionPane.showMessageDialog(null, "Please enter a valid time. Use format 0000");
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
                	JOptionPane.showMessageDialog(null, "Please select an employees's work schedule.");
                }
            }
        });
        
        //button update Thursday-----------------------------------------------
        btnUpdate4.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
		            		JOptionPane.showMessageDialog(null, "Please enter a valid time. Use format 0000");
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
                	JOptionPane.showMessageDialog(null, "Please select an employees's work schedule.");
                }
            }
        });
		
      //button update Friday-------------------------------------------------
        btnUpdate5.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
		            		JOptionPane.showMessageDialog(null, "Please enter a valid time. Use format 0000");
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
                	JOptionPane.showMessageDialog(null, "Please select an employees's work schedule.");
                }
            }
        });
        
      //button update Saturday-----------------------------------------------
        btnUpdate6.addActionListener(new ActionListener(){

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
					selection = "Change Hours";
				else
					selection = selected;
            	
	    		
	    		if (selection.equals("Change Hours"))
	    		{
	    			JFrame hours = new JFrame("Change Hours");
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
	    			
	    			hours.setSize(300, 190);
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
		            		JOptionPane.showMessageDialog(null, "Please enter a valid time. Use format 0000");
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
                	JOptionPane.showMessageDialog(null, "Please select an employes's work schedule.");
                }
            }
        });
        
        btnDelete.addActionListener(new ActionListener(){

              @Override
              public void actionPerformed(ActionEvent e) {
            		  
            		  int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete Schedule Log?", "Return to All Schedules?", JOptionPane.YES_NO_OPTION);
        				
        				//confirms selection and disables if yes
        				if (confirm == JOptionPane.YES_OPTION)
        					{
                    	
                    	
            			try{

            	           File file = new File(System.getProperty("user.dir") + "/Schedules/"  + week + ".txt");

            	           file.delete();
            	           
            	          }catch(Exception error){
            	              System.out.println(error);
            	          }
                        frame.dispose();
                        
                        try {
        					ScheduleSelector.toHours();
        				} catch (IOException e1) {
        					e1.printStackTrace();
        				}
        					} 
              }
        });
        
        
        
        btnSaveReturn.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
    			
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return Schedule Log?", "Return to All Schedules?", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	
    			try{
    				File folder = new File(System.getProperty("user.dir") + "/Schedules/");
    				
    				if (!folder.exists())
    					folder.createNewFile();
    				
    	             // create new file
    	             File file = new File(System.getProperty("user.dir") + "/Schedules/"  + week + ".txt");

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
            }
        });
        
        btnSaveHome.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
    			
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Home Page?", "Return to FEC Home?", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	
    			try{
    				File folder = new File(System.getProperty("user.dir") + "/Schedules/");
    				
    				if (!folder.exists())
    					folder.createNewFile();
    				
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
					}
                
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
	
	private static void createAndShowSchedule(String week) throws IOException {
        //Create and set up the window.
		
		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
        //Set up the content pane.
		fecWorkSchedule schedule = new fecWorkSchedule(week);
        schedule.setOpaque(true);
       
        //Display the window.
        frame.setSize(1205, 700);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	public static void toSchedule(String week) throws IOException
	{
		createAndShowSchedule(week);
	}

//	public static void main(String[] args) throws IOException{
//	
//	javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            try {
//				createAndShowSchedule("01022017");
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//        }
//    });
//	}
}
