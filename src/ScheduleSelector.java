

//*********************************************************************
//ScheduleSelector.java     Name: Nisha Patel    Last Update: 01/04/17
//
//GUI allows users to choose a specific weekly schedule
//*********************************************************************

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;

public class ScheduleSelector extends JPanel{
	
	int weekIndex = 0;
	
	ArrayList allWeeks = PullAllSchedules.getListOfSchedules();
	
	String selectedWeek;
	
	public ScheduleSelector(){
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		//------------------------------------------------------------
		
		JLabel schedule = new JLabel("  All Weekly Work Schedules  ");

		Font scheduleFont = new Font("",1,28);
		schedule.setFont(scheduleFont);
		schedule.setForeground(Color.cyan);
		
		pane.add(schedule);
		
		//------------------------------------------------------------
		
		JLabel blank;
		blank = new JLabel();
		pane.add(blank);
		
		//------------------------------------------------------------
		
		JComboBox allSchedules = new JComboBox();
		
		for(int index = 0; index < allWeeks.size(); index++){
			allSchedules.addItem(allWeeks.get(index).toString().substring(0,2) + "/" +
									allWeeks.get(index).toString().substring(2,4) + "/" +
									allWeeks.get(index).toString().substring(4,8));
		}
		
		Font comboFont = new Font("",1,18);
		allSchedules.setFont(comboFont);
		pane.add(allSchedules);
		
		//action listener to save the week the user has selected
		allSchedules.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox combo = (JComboBox) e.getSource();
				String week = allWeeks.get(combo.getSelectedIndex()).toString();		
				
				weekIndex = combo.getSelectedIndex();
				selectedWeek = week;
			}
			});
		
		//-------------------------------------------------------------
		
		blank = new JLabel("----------------------------------------------------------------------------------------------------");
		blank.setForeground(Color.cyan);
		pane.add(blank);
		
		//-------------------------------------------------------------
		
		JButton selectBtn = new JButton("View Schedule");
		
		Font selectFont = new Font("",1,18);
		selectBtn.setFont(selectFont);
		selectBtn.setBackground(Color.black);
		selectBtn.setForeground(Color.cyan);
		
		pane.add(selectBtn);
		
		selectBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have selected the corrected work week to view?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION && selectedWeek != null)
				{
					try {
						frame.dispose();
						showSchedule(selectedWeek);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

				} else
				{
            		JOptionPane.showMessageDialog(null, "Please select a valid work week or create a new work schedule.");
            	}
            }
		});
		
		//-----------------------------------------------------------------------
		
		blank = new JLabel("----------------------------------------------------------------------------------------------------");
		blank.setForeground(Color.cyan);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton createBtn = new JButton("Create New Schedule");
		
		Font createFont = new Font("",1,18);
		createBtn.setFont(createFont);
		createBtn.setBackground(Color.black);
		createBtn.setForeground(Color.cyan);
		
		pane.add(createBtn);
		
		createBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to generate a new work schedule?", "Verificatin Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
						frame.dispose();
						createSchedule();
					}
            	
            }
		});
		

		
		//-----------------------------------------------------------------------
		
		blank = new JLabel("----------------------------------------------------------------------------------------------------");
		blank.setForeground(Color.cyan);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton helpBtn = new JButton("Schedule Help Menu");
		
		Font helpFont = new Font("",1,18);
		helpBtn.setFont(helpFont);
		helpBtn.setBackground(Color.black);
		helpBtn.setForeground(Color.cyan);
		
		pane.add(helpBtn);
		
		helpBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to view the schedule help menu?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	frame.dispose();
            	
            	try {
            		//open Schedule GUI
            		helpSchedules.toWorkHelp();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});
		
		//-----------------------------------------------------------------------
		
		blank = new JLabel("----------------------------------------------------------------------------------------------------");
		blank.setForeground(Color.cyan);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to FEC Home Page");
		
		Font returnFont = new Font("",1,18);
		returnBtn.setFont(returnFont);
		returnBtn.setBackground(Color.black);
		returnBtn.setForeground(Color.cyan);
		
		pane.add(returnBtn);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Home Page?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	frame.dispose();
            	
            	try {
            		//open Schedule GUI
            		FECMainScreen.toMainGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});
		
		//-------------------------------------------------------------------
		
		pane.setBackground(Color.darkGray);
		
		add(pane);
		
	}
	
	public void showSchedule(String week) throws IOException{
		
		ArrayList<WorkDays> employees = PullAllSchedules.getSchedule(week);
		
		JFrame viewer = new JFrame("FEC Schedule Viewer");
		
		viewer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		viewer.setResizable(false);
		
		Font font = new Font("",1,18);
		
		JPanel schedulePane = new JPanel(new GridLayout(employees.size()+5, 7));
		
		JLabel header = new JLabel("Employee Schedule");
		header.setFont(font);
		header.setForeground(Color.darkGray);
		schedulePane.add(header);
		
		header = new JLabel(" For: " + week.substring(0,2) + "/" + week.substring(2,4) + "/" + week.substring(4,8));
		header.setFont(font);
		header.setForeground(Color.darkGray);
		schedulePane.add(header);
		
		JLabel blank;
		
		for (int x = 0; x < 5; x++)
		{
			blank = new JLabel(" ");
			schedulePane.add(blank);
		}
		
		Font font2 = new Font("",1,16);
		
		JLabel employID, workDay;
		
		employID = new JLabel("Employee ID");
		employID.setFont(font2);
		employID.setForeground(Color.blue);
		schedulePane.add(employID);
		
		workDay = new JLabel("Monday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		workDay = new JLabel("Tuesday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		workDay = new JLabel("Wednesday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		workDay = new JLabel("Thursday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		workDay = new JLabel("Friday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		workDay = new JLabel("Saturday");
		workDay.setFont(font2);
		workDay.setForeground(Color.blue);
		schedulePane.add(workDay);
		
		JLabel employee, hours;
		
		//add employee IDs and work hours to GUI
		for(int x = 0; x < employees.size(); x++){
			
			employee = new JLabel(employees.get(x).getEmployeeID());
			employee.setForeground(Color.black);
			schedulePane.add(employee);

			hours = new JLabel(employees.get(x).getMonHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
			
			hours = new JLabel(employees.get(x).getTueHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
			
			hours = new JLabel(employees.get(x).getWedHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
			
			hours = new JLabel(employees.get(x).getThurHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
			
			hours = new JLabel(employees.get(x).getFriHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
			
			hours = new JLabel(employees.get(x).getSatHours());
			hours.setForeground(Color.black);
			schedulePane.add(hours);
		}
		
		for (int x = 0; x < 6; x++)
		{
			blank = new JLabel(" ");
			schedulePane.add(blank);
		}
		
		//----------------------------------------------------------------------------------
		
		JButton editBtn = new JButton("Edit Schedule");
		editBtn.setBackground(Color.blue);
		editBtn.setForeground(Color.white);
		
		editBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to edit the current schedule?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	
            	try {
            		//open Schedule Editor GUI
            		frame.dispose();
            		viewer.dispose();
            		fecWorkSchedule.toSchedule(week);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});

		schedulePane.add(editBtn);
		
		//----------------------------------------------------------------------------------
		
		for (int x = 0; x < 6; x++)
		{
			blank = new JLabel(" ");
			schedulePane.add(blank);
		}
		
		//----------------------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return To All Schedules");
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.white);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the Schedule Log?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	
            	try {
            		//open Schedule Editor GUI
            		frame.dispose();
            		viewer.dispose();
            		toHours();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});

		schedulePane.add(returnBtn);
		
		//----------------------------------------------------------------------------------
		
		for (int x = 0; x < 6; x++)
		{
			blank = new JLabel(" ");
			schedulePane.add(blank);
		}
		
		//----------------------------------------------------------------------------------
		
		JButton printBtn = new JButton("Print Schedule");
		printBtn.setBackground(Color.blue);
		printBtn.setForeground(Color.white);
		
		printBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to print this schedule?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
					
					
            PrinterJob pjob = PrinterJob.getPrinterJob();
			PageFormat preformat = pjob.defaultPage();
			preformat.setOrientation(PageFormat.LANDSCAPE);
			PageFormat postformat = pjob.pageDialog(preformat);
			//If user does not hit cancel then print.
			if (preformat != postformat) {
		    //Set print component
		    pjob.setPrintable(new Printing(schedulePane), postformat);
			    if (pjob.printDialog()) {
			        try {
						pjob.print();
					} catch (PrinterException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
			    }
			}
            	}
            
            }
            });
		
		schedulePane.add(printBtn);
		
		//----------------------------------------------------------------------------------
		
		schedulePane.setBackground(Color.lightGray);
		viewer.add(schedulePane);
		viewer.pack();
		viewer.setLocationRelativeTo(null);
		viewer.setVisible(true);
	}
	
	public void createSchedule(){
		
		JFrame enter = new JFrame("New Schedule");
    	
    	enter.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    	enter.setResizable(false);
    	
    	JPanel pane = new JPanel(new GridLayout(0,1));
    	
    	Font headerFont = new Font("",1,20);
    	Font dateFont = new Font("",1,15);
    	
    	JLabel header = new JLabel("Enter Date of Work Week");
    	header.setFont(headerFont);
    	header.setForeground(Color.blue);
    	JLabel space = new JLabel(" ");
    	JLabel month = new JLabel("Month");
    	month.setForeground(Color.black);
    	month.setFont(dateFont);
    	JLabel day = new JLabel("Day");
    	day.setForeground(Color.black);
    	day.setFont(dateFont);
    	JLabel year = new JLabel("Year");
    	year.setForeground(Color.black);
    	year.setFont(dateFont);
    	JLabel space2 = new JLabel(" ");
    	JLabel modelM = new JLabel("Use format MM");
    	modelM.setForeground(Color.blue);
    	JLabel modelD = new JLabel("Use format DD");
    	modelD.setForeground(Color.blue);
    	JLabel modelY = new JLabel("Use format YYYY");
    	modelY.setForeground(Color.blue);
    	
    	JTextField textM = new JTextField();
		textM.setDocument(new CharLimiter(2));
		JTextField textD = new JTextField();
		textD.setDocument(new CharLimiter(2));
		JTextField textY = new JTextField();
		textY.setDocument(new CharLimiter(4));
		
		JButton createBtn = new JButton("Create New Schedule");
		
		Font createFont = new Font("",1,15);
		createBtn.setFont(createFont);
		createBtn.setBackground(Color.blue);
		createBtn.setForeground(Color.white);
		
		pane.add(header);
		pane.add(space);
		pane.add(month);
		pane.add(textM);
		pane.add(modelM);
		pane.add(day);
		pane.add(textD);
		pane.add(modelD);
		pane.add(year);
		pane.add(textY);
		pane.add(modelY);
		pane.add(space2);
		
		pane.setBackground(Color.lightGray);
		pane.add(createBtn);
		
		pane.setBorder(BorderFactory.createEmptyBorder(20, 40, 10, 40));
		enter.add(pane);
		
		enter.setSize(350, 350);
		enter.setLocationRelativeTo(null);
		enter.setVisible(true);
		
		createBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	String newMonth = textM.getText().toString();
            	String newDay = textD.getText().toString();
            	String newYear = textY.getText().toString();
            	String date = newMonth + newDay + newYear;
            	
            	int check = JOptionPane.showConfirmDialog(null, "Are you sure you have entered in the correct date?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
            	if (check == JOptionPane.YES_OPTION){
            	
            	
            	if((newMonth.length() != 2) || (newDay.length() != 2) || (newYear.length() != 4))
            	{
            		System.out.println("F");
            		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format MM/DD/YYYY");
            		
            	}
            	else
            	{
		            try {
						newWorkSchedule.toCreate(date);
						enter.dispose();
						
					} catch (IOException e1) {
						
					}
				}
            	}
            
            }
		});
		
	}
	
	static JFrame frame;
	
	private static void createAndShowHours() {
	        //Create and set up the window.
		 frame = new JFrame("FEC Work Schedules");   
		 
	     frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	     frame.setResizable(false);
	 
	        //Set up the content pane.
	      JComponent mySchedules = new ScheduleSelector();
	      mySchedules.setOpaque(true);
	       
	      frame.setContentPane(mySchedules);
	       
	        //Display the window.
	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	}
	
	public static void toHours() throws IOException
	{
		createAndShowHours();
	}
	
//	public static void main(String[] args){
//		
//		javax.swing.SwingUtilities.invokeLater(new Runnable() {
//            public void run() {
//                createAndShowHours();
//            }
//        });
//	}

}
