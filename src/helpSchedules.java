
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
//helpSchedule.java     Name: Nisha Patel     Date: 2/12/17
//
//help menu GUI for employee work schedules
//*******************************************************************

public class helpSchedules extends JPanel{

private static JFrame frame;

	public helpSchedules() {
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		Font titleFont = new Font("",1,26);
		
		//creates the title for the help screen
		JLabel title = new JLabel("   Work Schedule Help Menu");
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
		
		//help data for viewing schedules
		JLabel employHeader = new JLabel("   View Schedules");
		employHeader.setFont(headerFont);
		employHeader.setForeground(Color.cyan);
		String employMess = "     Choose a work week from the drop down. Click on \"Select Schedule\" in order to view the schedule for the chosen work week on the \"FEC Schedule Viewer\"     ";
		String employMess2 = "     screen.";
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
		
		//help data for editing schedules
		JLabel editHeader = new JLabel("   Edit Existing Schedules");
		editHeader.setFont(headerFont);
		editHeader.setForeground(Color.cyan);
		String editMess = "     On the \"FEC Schedule Viewer\" screen, select \"Edit Schedule\" in order to open the schedule editor. Select an employee to highlight their work schedule.  ";
		String editMess2 = "     Select \"Change Hours\" in order to set or update the employee's work hours. Use the format \"0000\" for the new hours. You can also select \"Request Off\"   ";
		String editMess3 = "     or \"Day Off\" to specify why an employee is not working on a certain day.";
		JLabel editContent = new JLabel(editMess);
		JLabel editContent2 = new JLabel(editMess2);
		JLabel editContent3 = new JLabel(editMess3);
		editContent.setFont(contentFont);
		editContent.setForeground(Color.green);
		editContent2.setFont(contentFont);
		editContent2.setForeground(Color.green);
		editContent3.setFont(contentFont);
		editContent3.setForeground(Color.green);
		
		pane.add(editHeader);
		pane.add(editContent);
		pane.add(editContent2);
		pane.add(editContent3);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
		
		//help data for print schedules
		JLabel custHeader = new JLabel("   Print Schedules");
		custHeader.setFont(headerFont);
		custHeader.setForeground(Color.cyan);
		String custMess = "     On the \"FEC Schedule Viewer\" screen, select \"Print Schedule\" in order to print the current selected schedule. ";
		JLabel custContent = new JLabel(custMess);
		custContent.setFont(contentFont);
		custContent.setForeground(Color.green);
		
		pane.add(custHeader);
		pane.add(custContent);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
				
		//help data for creating new schedules
		JLabel printHeader = new JLabel("   Create New Schedule");
		printHeader.setFont(headerFont);
		printHeader.setForeground(Color.cyan);
		String printMess = "     Select \"Create New Schedule\" and enter in the date of the first day of the work week. Use the format MM/DD/YYYY for the date. Select an employee to    ";
		String printMess2 = "     highlight their work schedule. Select \"Add Hours\" in order to add the employee's work hours. Use the format \"0000\" for the new hours. You can also    ";
		String printMess3 = "     select \"Request Off\" or \"Day Off\" to specify why an employee is not working on a certain day.";
		JLabel printContent = new JLabel(printMess);
		JLabel printContent2 = new JLabel(printMess2);
		JLabel printContent3 = new JLabel(printMess3);
		printContent.setFont(contentFont);
		printContent.setForeground(Color.green);
		printContent2.setFont(contentFont);
		printContent2.setForeground(Color.green);
		printContent3.setFont(contentFont);
		printContent3.setForeground(Color.green);
		
		pane.add(printHeader);
		pane.add(printContent);
		pane.add(printContent2);
		pane.add(printContent3);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
						
		//-----------------------------------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to Work Schedules");
		
		Font btnFont = new Font("",1,24);
		returnBtn.setFont(btnFont);
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.lightGray);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to Work Schedules?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            		frame.dispose();
        		try {
        			ScheduleSelector.toHours();
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
	
	private static void createAndShowWorkHelp() {

		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JComponent main = new helpSchedules();
	    main.setOpaque(true);
	    
		 JScrollPane scrollPane = new JScrollPane(main);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
	    frame.setContentPane(scrollPane);
		frame.setSize(930, 600);
		
		// Display the window.
		//frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	 }
	
	public static void toWorkHelp() throws IOException
	{
		createAndShowWorkHelp();
	}
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
				{
					createAndShowWorkHelp();
				}
		}
	);
	}
	
}
