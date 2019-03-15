import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//******************************************************************
//fecEmployees.java     Name: Nisha Patel    Date: 2/13/17
//
//
//main GUI for employees, gives option to view and edit employees
//*******************************************************************

public class fecEmployees extends JPanel {
	
	public fecEmployees() throws IOException{
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		//------------------------------------------------------------
		
		JLabel schedule = new JLabel("   FEC Employee Roster");

		Font scheduleFont = new Font("",1,30);
		schedule.setFont(scheduleFont);
		schedule.setForeground(Color.blue);
		
		pane.add(schedule);
		
		//------------------------------------------------------------
		
		JLabel blank;
		blank = new JLabel();
		pane.add(blank);
		
		//------------------------------------------------------------
		Font btnFont = new Font("",1,20);
		
		JButton viewBtn = new JButton("View Employees");
		viewBtn.setFont(btnFont);
		viewBtn.setBackground(Color.lightGray);
		viewBtn.setForeground(Color.blue);
		
		pane.add(viewBtn);
		
		viewBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you to view FEC employees?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
            	if(confirm == JOptionPane.YES_OPTION)
            	{
            		frame.dispose();
            		try {
						showEmployees();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
            	}
				
            }
		});
		
		//-----------------------------------------------------------------------
		
		blank = new JLabel("------------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton createBtn = new JButton("Edit Employee Roster");
		
		Font createFont = new Font("",1,18);
		createBtn.setFont(createFont);
		createBtn.setBackground(Color.lightGray);
		createBtn.setForeground(Color.blue);
		
		pane.add(createBtn);
		
		createBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to view the employee Roster?", "Verificatin Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
						frame.dispose();
						try {
							FECEmployeeRoster.toRoster();
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
					}
            	
            }
		});
		

		//-----------------------------------------------------------------------
		
		blank = new JLabel("------------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton helpBtn = new JButton("Employee Help Menu");
		
		Font helpFont = new Font("",1,18);
		helpBtn.setFont(helpFont);
		helpBtn.setBackground(Color.lightGray);
		helpBtn.setForeground(Color.blue);
		
		pane.add(helpBtn);
		
		helpBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to view the employee help menu?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	frame.dispose();
            	
            	try {
            		//open Schedule GUI
            		helpEmployees.toEmployHelp();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});
		
		//-----------------------------------------------------------------------
		
		blank = new JLabel("------------------------------------------------------------------------------------------");
		blank.setForeground(Color.blue);
		pane.add(blank);
		
		//-----------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to FEC Home Page");
		
		Font returnFont = new Font("",1,18);
		returnBtn.setFont(returnFont);
		returnBtn.setBackground(Color.lightGray);
		returnBtn.setForeground(Color.blue);
		
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
		
		pane.setBackground(Color.black);
		
		add(pane);
		
	}
	
	private static void showEmployees() throws IOException{
		
		List<fecEmployeeData> employees = GatherFECEmployees.getEmployees();
		
		JFrame viewer = new JFrame("FEC Employee Viewer");

		viewer.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		viewer.setResizable(false);
		
		//-------------------------------------------------------------------------
		
		JPanel viewPane = new JPanel(new GridLayout(employees.size()+3, 4));
		
		Font titleFont = new Font("", 1,20);
		JLabel title = new JLabel("All FEC Employees");
		title.setFont(titleFont);
		title.setForeground(Color.darkGray);
		viewPane.add(title);
		
		JLabel blank;
		
		//-------------------------------------------------------------
		
		for (int x = 0; x < 3; x++)
		{
			blank = new JLabel(" ");
			viewPane.add(blank);
		}
		
		//-------------------------------------------------------------
		
		Font headerFont = new Font("",1,18);
		JLabel header;
		
		header = new JLabel("Employee ID");
		header.setFont(headerFont);
		header.setForeground(Color.blue);
		viewPane.add(header);
		
		header = new JLabel("First Name");
		header.setFont(headerFont);
		header.setForeground(Color.blue);
		viewPane.add(header);
		
		header = new JLabel("Last Name");
		header.setFont(headerFont);
		header.setForeground(Color.blue);
		viewPane.add(header);
		
		header = new JLabel("Contact Number");
		header.setFont(headerFont);
		header.setForeground(Color.blue);
		viewPane.add(header);
		
		Font contentFont = new Font("",1,14);
		JLabel content;
		
		for(int x = 0; x < employees.size(); x++){
			
			content = new JLabel(employees.get(x).getEmployeeID());
			content.setFont(contentFont);
			content.setForeground(Color.black);
			viewPane.add(content);
			
			content = new JLabel(employees.get(x).getFName());
			content.setFont(contentFont);
			content.setForeground(Color.black);
			viewPane.add(content);
			
			content = new JLabel(employees.get(x).getLName());
			content.setFont(contentFont);
			content.setForeground(Color.black);
			viewPane.add(content);
			
			content = new JLabel(employees.get(x).getContactNumber());
			content.setFont(contentFont);
			content.setForeground(Color.black);
			viewPane.add(content);
		}
		
		//-------------------------------------------------------------
		
		for (int x = 0; x < 3; x++)
		{
			blank = new JLabel(" ");
			viewPane.add(blank);
		}
				
		//-------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return To Employee Main");
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.white);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the main FEC Employee screen?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	
            	try {
            		//open Schedule Editor GUI
            		viewer.dispose();
            		toEmployees();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});

		viewPane.add(returnBtn);
		
		viewPane.setBackground(Color.lightGray);
		
		JScrollPane scrollPane = new JScrollPane(viewPane);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		viewer.add(scrollPane);
		viewer.setSize(600,400);
		viewer.pack();
		viewer.setLocationRelativeTo(null);
		viewer.setVisible(true);
		
	}
	
	static JFrame frame;
	
	private static void createAndShowEmployees() throws IOException{
	        //Create and set up the window.
		 frame = new JFrame("FEC Employees");   
		 
	     frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
	     frame.setResizable(false);
	 
	        //Set up the content pane.
	      JComponent employees = new fecEmployees();
	      employees.setOpaque(true);
	       
	      frame.setContentPane(employees);
	       
	        //Display the window.
	      frame.pack();
	      frame.setLocationRelativeTo(null);
	      frame.setVisible(true);
	}
	
	public static void toEmployees() throws IOException
	{
		createAndShowEmployees();
	}
	
//	public static void main(String[] args){
//	
//	javax.swing.SwingUtilities.invokeLater(new Runnable() {
//        public void run() {
//            try {
//				createAndShowEmployees();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//        }
//    });
//}
}
