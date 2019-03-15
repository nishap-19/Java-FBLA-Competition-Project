
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

//*******************************************************************
//helpEmployees.java     Name: Nisha Patel     Date: 2/12/17
//
//help menu GUI for employee roster
//*******************************************************************

public class helpEmployees extends JPanel{

private static JFrame frame;

	public helpEmployees() {
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		Font titleFont = new Font("",1,26);
		
		//creates the title for the help screen
		JLabel title = new JLabel("   Employee Help Menu");
		title.setFont(titleFont);
		title.setForeground(Color.lightGray);
		
		pane.add(title);
		
		//-----------------------------------------------------------------------------------------------
		
		JLabel blank;
		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
		
		Font headerFont = new Font("",1,18);
		Font contentFont = new Font("",1,12);
		
		//help data for viewing list of employees
		JLabel employHeader = new JLabel("   View All FEC Employees");
		employHeader.setFont(headerFont);
		employHeader.setForeground(Color.cyan);
		String employMess = "     On the \"FEC Employees\" screen, select \"View Employees\" to see a list of all FEC employees. The list contains the ID Number, First Name, Last  ";
		String employMess2 = "     Name, and Contact Number. For more infomrmation  go to \"Edit Employee Roster\" to view all stored demographic data for each employee.   ";
		JLabel employContent = new JLabel(employMess);
		JLabel employContent2 = new JLabel(employMess2);
		
		employContent.setFont(contentFont);
		employContent.setForeground(Color.green);
		employContent2.setFont(contentFont);
		employContent2.setForeground(Color.green);
		
		pane.add(employHeader);
		pane.add(employContent);
		pane.add(employContent2);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
		
		//help data for editing employee roster
		JLabel editHeader = new JLabel("   Edit Employee Data");
		editHeader.setFont(headerFont);
		editHeader.setForeground(Color.cyan);
		String editMess = "     On the \"FEC Employees\" screen, select \"Edit Employee Roster\" to navigate to the roster viewer and editor. On this screen you will see a complete    ";
		String editMess2 = "     list of demographic information for each employee at FEC. Click on an employee that you want to view. Their information will fill into the boxes  ";
		String editMess3 = "     below the roster table. You can change the content of each field to update the employee's information. Select \"Update\" when you are finished to ";
		String editMess4 = "     save your changes";
		JLabel editContent = new JLabel(editMess);
		JLabel editContent2 = new JLabel(editMess2);
		JLabel editContent3 = new JLabel(editMess3);
		JLabel editContent4 = new JLabel(editMess4);
		editContent.setFont(contentFont);
		editContent.setForeground(Color.green);
		editContent2.setFont(contentFont);
		editContent2.setForeground(Color.green);
		editContent3.setFont(contentFont);
		editContent3.setForeground(Color.green);
		editContent4.setFont(contentFont);
		editContent4.setForeground(Color.green);
		
		pane.add(editHeader);
		pane.add(editContent);
		pane.add(editContent2);
		pane.add(editContent3);
		pane.add(editContent4);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
				
		//-----------------------------------------------------------------------------------------------
				
		//help data for adding employees
		JLabel addHeader = new JLabel("   Add Employees");
		addHeader.setFont(headerFont);
		addHeader.setForeground(Color.cyan);
		String addMess = "     On the \"FEC Employees\" screen, select \"Edit Employee Roster\" to navigate to the roster viewer and editor. On this screen you will see a complete    ";
		String addMess2 = "     list of demographic information for each employee at FEC. Below them roster table, there are textfields for you to type in the demographic  ";
		String addMess3 = "     information of a new employee. When you have filled in all of the data fields, select \"Add\" to add the employee to the roster.";
		JLabel addContent = new JLabel(addMess);
		JLabel addContent2 = new JLabel(addMess2);
		JLabel addContent3 = new JLabel(addMess3);
				
		addContent.setFont(contentFont);
		addContent.setForeground(Color.green);
		addContent2.setFont(contentFont);
		addContent2.setForeground(Color.green);
		addContent3.setFont(contentFont);
		addContent3.setForeground(Color.green);

		pane.add(addHeader);
		pane.add(addContent);
		pane.add(addContent2);
		pane.add(addContent3);

		blank = new JLabel();
		pane.add(blank);
						
		//-----------------------------------------------------------------------------------------------
		
		blank = new JLabel();
		pane.add(blank);
				
		//-----------------------------------------------------------------------------------------------
				
		//help data for deleting employees
		JLabel deleteHeader = new JLabel("   Delete Employees");
		deleteHeader.setFont(headerFont);
		deleteHeader.setForeground(Color.cyan);
		String deleteMess = "     On the \"FEC Employees\" screen, select \"Edit Employee Roster\" to navigate to the roster viewer and editor. On this screen you will see a complete    ";
		String deleteMess2 = "     list of demographic information for each employee at FEC. Click on the employee you want to delete from the employee roster. \"Select Delete\" to  ";
		String deleteMess3 = "     remove the employee.";
		JLabel deleteContent = new JLabel(deleteMess);
		JLabel deleteContent2 = new JLabel(deleteMess2);
		JLabel deleteContent3 = new JLabel(deleteMess3);
				
		deleteContent.setFont(contentFont);
		deleteContent.setForeground(Color.green);
		deleteContent2.setFont(contentFont);
		deleteContent2.setForeground(Color.green);
		deleteContent3.setFont(contentFont);
		deleteContent3.setForeground(Color.green);

		pane.add(deleteHeader);
		pane.add(deleteContent);
		pane.add(deleteContent2);
		pane.add(deleteContent3);

		blank = new JLabel();
		pane.add(blank);
		
		//------------------------------------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to Employees Screen");
		
		Font btnFont = new Font("",1,24);
		returnBtn.setFont(btnFont);
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.lightGray);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to the main Employees screen?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection
				if (confirm == JOptionPane.YES_OPTION)
					{
            		frame.dispose();
        		try {
        			fecEmployees.toEmployees();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
					}
            }
		});
		
		
		pane.add(returnBtn);
		pane.setBackground(Color.black);
		
		add(pane);
		
	}
	
	private static void createAndShowEmployHelp() {

		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JComponent main = new helpEmployees();
	    main.setOpaque(true);
	    
		 JScrollPane scrollPane = new JScrollPane(main);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
	    frame.setContentPane(scrollPane);
		frame.setSize(885, 600);
		
		// Display the window.
		//frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	 }
	
	public static void toEmployHelp() throws IOException
	{
		createAndShowEmployHelp();
	}
	
//	public static void main(String[] args) {
//
//		javax.swing.SwingUtilities.invokeLater(new Runnable() 
//		{
//			public void run()
//				{
//					createAndShowEmployHelp();
//				}
//		}
//	);
//	}
	
}
