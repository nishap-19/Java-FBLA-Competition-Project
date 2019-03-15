
//************************************************************
//fecCustomers.java     Name: Nisha Patel     Date: 11/21/16
//
//collects and prints data from customers at fec
//************************************************************

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import java.util.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class fecCustomers extends JPanel
{
	String selectedWeek;
	
	String selectedDay = "Monday";
	
	ArrayList allWeeks = PullAllCustomers.getListOfCustomers();
	
	public fecCustomers(){
	
		JPanel pane = new JPanel(new GridLayout(0,1));
		
		Font font = new Font("",1,25);
		JLabel chooseWeek = new JLabel(" Select Weekly Customer Log ");
		chooseWeek.setFont(font);
		chooseWeek.setForeground(Color.lightGray);
		
		pane.add(chooseWeek);
		
		//-------------------------------------------------------------
		
		JLabel blank;
		blank = new JLabel(" ");
		pane.add(blank);
		
		//--------------------------------------------------------------
		
		JComboBox weeks = new JComboBox();
		
		for(int x = 0; x < allWeeks.size(); x++){
			weeks.addItem(allWeeks.get(x));
		}

		Font comboFont = new Font("",1,18);
		weeks.setFont(comboFont);
		pane.add(weeks);
		
		weeks.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox combo = (JComboBox) e.getSource();		
				String week = combo.getSelectedItem().toString();
				
				selectedWeek = week;
			}
			});
		
		//-------------------------------------------------------------
		
		blank = new JLabel(" ");
		pane.add(blank);
		
		//--------------------------------------------------------------
		Font btnFont = new Font("",1,20);
		JButton viewBtn = new JButton("View Customers");
		viewBtn.setForeground(Color.white);
		viewBtn.setBackground(Color.blue);
		viewBtn.setFont(btnFont);
		
		//allows the user to view a selected weekly customer log
		viewBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
 	
    				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have selected the correct customer log?", "Verification Screen", JOptionPane.YES_NO_OPTION);
    				
    				//confirms selection
    				if (confirm == JOptionPane.YES_OPTION && selectedWeek != null)
    					{
                			frame.dispose();
    						try {
								viewCustomers(selectedWeek);
							} catch (FileNotFoundException e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
    					}
					
    				else{

						JOptionPane.showMessageDialog(frame, "Please select a valid customer log or create a new customer log.");
					}

            }
		});
		
		pane.add(viewBtn);
		
		//--------------------------------------------------------------
		
		blank = new JLabel("----------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//--------------------------------------------------------------
		
		JButton addBtn = new JButton("Add Customer");
		addBtn.setForeground(Color.white);
		addBtn.setBackground(Color.blue);
		addBtn.setFont(btnFont);
		
		//allows user to check in a customer
		addBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
					int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you have chosen the correct work week and work day?", "Verification Screen", JOptionPane.YES_NO_OPTION);
					
					//confirms selection and disables if yes
					if (confirm == JOptionPane.YES_OPTION && selectedWeek != null)
					{
	
	            		//open Schedule Viewer GUI
						frame.dispose();
	            		addCustomer(selectedWeek);
					}
					else{	
					
						JOptionPane.showMessageDialog(null, "Please select a valid customer log or create a new customer log.");
					}

            }
		});
		
		pane.add(addBtn);
		
		
		//--------------------------------------------------------------
		

		blank = new JLabel("----------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//--------------------------------------------------------------
		
		JButton newBtn = new JButton("Create New Cutomer Log");
		newBtn.setForeground(Color.white);
		newBtn.setBackground(Color.blue);
		newBtn.setFont(btnFont);
		
		//allows the user to return to the home screen
		newBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to create a new customer log?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
				{
            		frame.dispose();
            		newWeek();
				}
            }
		});
		
		pane.add(newBtn);
		
		//--------------------------------------------------------------

		blank = new JLabel("----------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//--------------------------------------------------------------
		
		JButton helpBtn = new JButton("Customer Log Help Menu");
		helpBtn.setForeground(Color.white);
		helpBtn.setBackground(Color.blue);
		helpBtn.setFont(btnFont);
		
		//allows the user to return to the home screen
		helpBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to view the customer log help menu?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            		frame.dispose();
            		try {
						helpCustomers.toCustHelp();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}
            }
		});
		
		pane.add(helpBtn);
		
		//--------------------------------------------------------------

		blank = new JLabel("----------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
				
		//--------------------------------------------------------------
				
		JButton returnBtn = new JButton("Return to FEC Home");
		returnBtn.setForeground(Color.white);
		returnBtn.setBackground(Color.blue);
		returnBtn.setFont(btnFont);
				
		//allows the user to return to the home screen
		returnBtn.addActionListener(new ActionListener(){
					
		     @Override
		     public void actionPerformed(ActionEvent e) {
		            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Home Page?", "Verification Screen", JOptionPane.YES_NO_OPTION);
						
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
				{
		            frame.dispose();
		            try {
						FECMainScreen.toMainGUI();
					} catch (IOException e1) {
							e1.printStackTrace();
					}
					}
		    }
		});
				
		pane.add(returnBtn);
		
		pane.setBackground(Color.black);
		add(pane);
		//setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
	}
	
	private static JFrame frame;
	
	private static void createAndShowCustomers() throws IOException {
		
		frame = new JFrame("FEC Customer Logs");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		
		JComponent customers = new fecCustomers();
		customers.setOpaque(true);
		
		frame.setContentPane(customers);
		
		frame.setSize(400, 520);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
	
	@SuppressWarnings("unchecked")
	public void addCustomer(String week){
		
		JFrame customFrame = new JFrame("New Customer");
		
		customFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel customer = new JPanel(new GridLayout(0,1));
		
		//--------------------------------------------------------------
		
		Font font = new Font("",1,22);
		JLabel chooseDay = new JLabel("Select Current Day");
		chooseDay.setFont(font);
		chooseDay.setForeground(Color.white);
		
		//--------------------------------------------------------------
		
		JComboBox days = new JComboBox();
		days.addItem("Monday");
		days.addItem("Tuesday");
		days.addItem("Wednesday");
		days.addItem("Thursday");
		days.addItem("Friday");
		days.addItem("Saturday");
				
		days.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JComboBox combo = (JComboBox) e.getSource();
				String day = combo.getSelectedItem().toString();		
						
				selectedDay = day;
			}
		});
				
		//--------------------------------------------------------------
				
		JLabel blank = new JLabel(" ");
		
		Font nameFont = new Font("",1,25);
		JLabel firstName = new JLabel("Enter First Name");
		firstName.setFont(nameFont);
		firstName.setForeground(Color.cyan);
		JLabel lastName = new JLabel("Enter Last Name");
		lastName.setFont(nameFont);
		lastName.setForeground(Color.cyan);
		JLabel space = new JLabel(" ");
		
		JTextField textFirst = new JTextField();
		textFirst.setDocument(new CharLimiter(25));
		JTextField textLast = new JTextField();
		textLast.setDocument(new CharLimiter(25));
		
		Font btnFont = new Font("",1,20);
		JButton addingBtn = new JButton("Add Customer");
		addingBtn.setForeground(Color.black);
		addingBtn.setBackground(Color.cyan);
		addingBtn.setFont(btnFont);
		
		
		customer.add(chooseDay);
		customer.add(days);
		customer.add(blank);
		customer.add(firstName);
		customer.add(textFirst);
		customer.add(lastName);
		customer.add(textLast);
		customer.add(space);
		customer.add(addingBtn);
		
		customer.setBorder(BorderFactory.createEmptyBorder(25, 40, 20, 40));
		customer.setBackground(Color.darkGray);
		customFrame.add(customer);
		
		customFrame.setSize(350, 400);
		customFrame.setLocationRelativeTo(null);
		customFrame.setVisible(true);
		
		addingBtn.addActionListener (new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				//adds new customer information to array list
				try {
					
					ArrayList<weeklyCustomers> allCustomers = PullAllCustomers.getCustomerLog(selectedWeek);
					
				if (selectedDay.equals("Monday")){
					
					allCustomers.get(0).addMondayCustomers(textFirst.getText(), textLast.getText());
				}
				else if (selectedDay.equals("Tuesday")){
					
					allCustomers.get(1).addTuesdayCustomers(textFirst.getText(), textLast.getText());
				}
				else if (selectedDay.equals("Wednesday")){
					
					allCustomers.get(2).addWednesdayCustomers(textFirst.getText(), textLast.getText());
				}
				else if (selectedDay.equals("Thursday")){
					
					allCustomers.get(3).addThursdayCustomers(textFirst.getText(), textLast.getText());
				}
				else if (selectedDay.equals("Friday")){
					
					allCustomers.get(4).addFridayCustomers(textFirst.getText(), textLast.getText());
				}
				else if (selectedDay.equals("Saturday")){
					
					allCustomers.get(5).addSaturdayCustomers(textFirst.getText(), textLast.getText());
				}
				
				 File file = new File(System.getProperty("user.dir") + "/Customers/" + selectedWeek + ".txt");
				 
					 try {
		               // if file doesnt exists, then create it
		               if (!file.exists()) {
		                   file.createNewFile();
		               }
		               
		               FileWriter fw;
					
						fw = new FileWriter(file.getAbsoluteFile());
					
		               BufferedWriter bw = new BufferedWriter(fw);
		               // write in file
	
		   				bw.write(allCustomers.get(0).sendMondayToFile() + "\n");
		   				bw.write(allCustomers.get(1).sendTuesdayToFile() + "\n");
		   				bw.write(allCustomers.get(2).sendWednesdayToFile() + "\n");
		   				bw.write(allCustomers.get(3).sendThursdayToFile() + "\n");
		   				bw.write(allCustomers.get(4).sendFridayToFile() + "\n");
		   				bw.write(allCustomers.get(5).sendSaturdayToFile() + "\n");
	
		               bw.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				}
				
				customFrame.dispose();
				
				try {
					toCustomers();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
	}
	
	public void newWeek(){
		
		JFrame newWeek = new JFrame("New Customer Log");
		newWeek.setResizable(false);
		
		newWeek.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel customer = new JPanel(new GridLayout(0,1));
		
		Font headerFont = new Font("",1,20);
    	Font dateFont = new Font("",1,16);
    	
    	JLabel header = new JLabel("Enter Date For New Weekly");
    	JLabel header2 = new JLabel("Customer Attendance Log");
    	header.setFont(headerFont);
    	header.setForeground(Color.cyan);
    	header2.setFont(headerFont);
    	header2.setForeground(Color.cyan);
    	JLabel space = new JLabel(" ");
    	JLabel month = new JLabel("Month");
    	month.setForeground(Color.white);
    	month.setFont(dateFont);
    	JLabel day = new JLabel("Day");
    	day.setForeground(Color.white);
    	day.setFont(dateFont);
    	JLabel year = new JLabel("Year");
    	year.setForeground(Color.white);
    	year.setFont(dateFont);
    	JLabel space2 = new JLabel(" ");
    	JLabel modelM = new JLabel("Use format MM");
    	modelM.setForeground(Color.cyan);
    	JLabel modelD = new JLabel("Use format DD");
    	modelD.setForeground(Color.cyan);
    	JLabel modelY = new JLabel("Use format YYYY");
    	modelY.setForeground(Color.cyan);
		
    	JTextField textM = new JTextField();
		textM.setDocument(new CharLimiter(2));
		JTextField textD = new JTextField();
		textD.setDocument(new CharLimiter(2));
		JTextField textY = new JTextField();
		textY.setDocument(new CharLimiter(4));
		
		JButton addBtn = new JButton("Add New Week");
		
		Font createFont = new Font("",1,15);
		addBtn.setFont(createFont);
		addBtn.setBackground(Color.black);
		addBtn.setForeground(Color.cyan);
		
		customer.add(header);
		customer.add(header2);
		customer.add(month);
		customer.add(textM);
		customer.add(modelM);
		customer.add(day);
		customer.add(textD);
		customer.add(modelD);
		customer.add(year);
		customer.add(textY);
		customer.add(modelY);
		customer.add(space2);
		customer.add(addBtn);
		
		customer.setBackground(Color.darkGray);
		newWeek.add(customer);
		
		customer.setBorder(BorderFactory.createEmptyBorder(25, 40, 20, 40));
		
		newWeek.setSize(350, 400);
		newWeek.setLocationRelativeTo(null);
		newWeek.setVisible(true);
		
		addBtn.addActionListener(new ActionListener(){
			
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
               		JOptionPane.showMessageDialog(null, "Please enter a valid date. Use format MM/DD/YYYY");
               	}
               	else{
            		
              File folder = new File(System.getProperty("user.dir") + "/Customers/");
         			
              if (!folder.exists())
            		folder.mkdir();

            	selectedWeek = date;
            	
        		try{
                    // create new file
                    File file = new File(System.getProperty("user.dir") + "/Customers/" + selectedWeek + ".txt");

                       // if file doesnt exists, then create it
                       if (!file.exists()) {
                           file.createNewFile();
                       }
                       
                       FileWriter fw = new FileWriter(file.getAbsoluteFile());
                       BufferedWriter bw = new BufferedWriter(fw);
                       // write in file

                       //sets basic information into the new file
           				bw.write("Monday\n");
           				bw.write("Tuesday\n");
           				bw.write("Wednesday\n");
           				bw.write("Thurday\n");
           				bw.write("Friday\n");
           				bw.write("Saturday\n");

                       bw.close();
                 }catch(Exception error){
                     System.out.println(error);
                 }
        		
        		newWeek.dispose();
            	addCustomer(selectedWeek);
            }
            }
            }
		});
	}
	
	public void viewCustomers(String week) throws FileNotFoundException{
		
		ArrayList<weeklyCustomers> customers = PullAllCustomers.getCustomerLog(week);
		
		JFrame customFrame = new JFrame("FEC Customer Log Viewer");
		customFrame.setResizable(false);
		
		customFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		JPanel customerPane = new JPanel(new GridLayout(0,1));
		
		Font font = new Font("",1,22);
		
		JLabel header = new JLabel("Customer Log For Week Of " + week.substring(0,2) + "/" + week.substring(2,4) + "/" + week.substring(4,8));
		header.setFont(font);
		header.setForeground(Color.darkGray);
		customerPane.add(header);
		
		JLabel space;
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//add customer log data into GUI
		
		JLabel customData;
		
		Font dayFont = new Font("",1,18);
		Font customFont = new Font("",1,15);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Monday's customer log data
		
		JLabel Monday = new JLabel("Monday");
		Monday.setFont(dayFont);
		Monday.setForeground(Color.blue);
		customerPane.add(Monday);
		
		for(int index = 0; index < customers.get(0).getMondayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(0).getMondayCustomers().get(index).getFname() + " " + 
					customers.get(0).getMondayCustomers().get(index).getLname() + " " +
					customers.get(0).getMondayCustomers().get(index).getTime());
				
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Tuesday's customer log data
		
		JLabel Tuesday = new JLabel("Tuesday");
		Tuesday.setFont(dayFont);
		Tuesday.setForeground(Color.blue);
		customerPane.add(Tuesday);
		
		for(int index = 0; index < customers.get(1).getTuesdayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(1).getTuesdayCustomers().get(index).getFname() + " " + 
					customers.get(1).getTuesdayCustomers().get(index).getLname() + " " +
					customers.get(1).getTuesdayCustomers().get(index).getTime());
			
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Wednesday's customer log data
		
		JLabel Wednesday = new JLabel("Wednesday");
		Wednesday.setFont(dayFont);
		Wednesday.setForeground(Color.blue);
		customerPane.add(Wednesday);
		
		for(int index = 0; index < customers.get(2).getWednesdayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(2).getWednesdayCustomers().get(index).getFname() + " " + 
					customers.get(2).getWednesdayCustomers().get(index).getLname() + " " +
					customers.get(2).getWednesdayCustomers().get(index).getTime());
			
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Thursday's customer log data
		
		JLabel Thursday = new JLabel("Thursday");
		Thursday.setFont(dayFont);
		Thursday.setForeground(Color.blue);
		customerPane.add(Thursday);
		
		for(int index = 0; index < customers.get(3).getThursdayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(3).getThursdayCustomers().get(index).getFname() + " " + 
					customers.get(3).getThursdayCustomers().get(index).getLname() + " " +
					customers.get(3).getThursdayCustomers().get(index).getTime());
				
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Friday's customer log data
		
		JLabel Friday = new JLabel("Friday");
		Friday.setFont(dayFont);
		Friday.setForeground(Color.blue);
		customerPane.add(Friday);
		
		for(int index = 0; index < customers.get(4).getFridayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(4).getFridayCustomers().get(index).getFname() + " " + 
					customers.get(4).getFridayCustomers().get(index).getLname() + " " +
					customers.get(4).getFridayCustomers().get(index).getTime());
			
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}	
		
		space = new JLabel(" ");
		customerPane.add(space);
		
		//-------------------------------------------------------------------------------------------------
		
		//creates and displays Saturday's customer log data
		
		JLabel Saturday = new JLabel("Saturday");
		Saturday.setFont(dayFont);
		Saturday.setForeground(Color.blue);
		customerPane.add(Saturday);
		
		for(int index = 0; index < customers.get(5).getSaturdayCustomers().size(); index++){
				
			customData = new JLabel(customers.get(5).getSaturdayCustomers().get(index).getFname() + " " + 
					customers.get(5).getSaturdayCustomers().get(index).getLname() + " " +
					customers.get(5).getSaturdayCustomers().get(index).getTime());
				
			customData.setFont(customFont);
			customData.setForeground(Color.black);
			customerPane.add(customData);
		}	
		
		//----------------------------------------------------------------------------------------------------
		
		JLabel blank = new JLabel();
		customerPane.add(blank);
		
		//----------------------------------------------------------------------------------------------------
		
		Font btnFont = new Font("",1,16);
		
		JButton BtnReturnCustomers = new JButton("Return to Customer Logs");
		BtnReturnCustomers.setFont(btnFont);
		BtnReturnCustomers.setBackground(Color.blue);
		BtnReturnCustomers.setForeground(Color.white);
		
		BtnReturnCustomers.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the Customer Logs?", "Return to Logs?", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	customFrame.dispose();
        		try {
        			toCustomers();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});

		customerPane.add(BtnReturnCustomers);

		JButton BtnReturnHome = new JButton("Return to FEC Home Page");
		BtnReturnHome.setFont(btnFont);
		BtnReturnHome.setBackground(Color.blue);
		BtnReturnHome.setForeground(Color.white);
		
		BtnReturnHome.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the FEC Home Page?", "Return to FEC Home?", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	customFrame.dispose();
        		try {
					FECMainScreen.toMainGUI();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});
		
		customerPane.add(BtnReturnHome);
		
		
		JButton printBtn = new JButton("Print Customer Log");
		printBtn.setFont(btnFont);
		printBtn.setBackground(Color.blue);
		printBtn.setForeground(Color.white);
		
		printBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to print this customer log?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
					
					
            PrinterJob pjob = PrinterJob.getPrinterJob();
			PageFormat preformat = pjob.defaultPage();
			preformat.setOrientation(PageFormat.PORTRAIT);
			PageFormat postformat = pjob.pageDialog(preformat);
			//If user does not hit cancel then print.
			if (preformat != postformat) {
		    //Set print component
		    pjob.setPrintable(new Printing(customerPane), postformat);
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
		
		customerPane.add(printBtn);
		
		customerPane.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
		
		 JScrollPane scrollPane = new JScrollPane(customerPane);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

		customFrame.add(scrollPane);
		customFrame.setSize(530, 700);
		customFrame.setLocationRelativeTo(null);
		customFrame.setVisible(true);
		
	}
	
	public static void toCustomers() throws IOException
	{
		createAndShowCustomers();
	}
	
//	public static void main(String[] args) throws IOException{
//	
//	javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            try {
//				createAndShowCustomers();
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//        }
//    });
//	}
}
