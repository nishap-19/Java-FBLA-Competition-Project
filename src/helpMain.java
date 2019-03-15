
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

//*******************************************************************
//helpMain.java     Name: Nisha Patel     Date: 2/12/17
//
//help menu GIU for main FEC home page
//*******************************************************************

public class helpMain extends JPanel{

private static JFrame frame;

	public helpMain() {
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		Font titleFont = new Font("",1,24);
		
		//creates the title for the help screen
		JLabel title = new JLabel("   FEC Main Help Menu");
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
		
		//creates all of the help data for employees
		JLabel employHeader = new JLabel("   Employees");
		employHeader.setFont(headerFont);
		employHeader.setForeground(Color.cyan);
		String employMess = "     Select \"View Employees\" on the home page in order to go to the employee data program. You will be able to view and    ";
		String employMess2 = "     update the employee roster. Navigate to the Employees screen for more information.";
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
		
		//creates all of the help data for work schedules
		JLabel workHeader = new JLabel("   Work Schedules");
		workHeader.setFont(headerFont);
		workHeader.setForeground(Color.cyan);
		String workMess = "     Select \"View Work Schedules\" on the home page in order to go to the work schedule program. You will be able to ";
		String workMess2 = "     create, view, and update employee work schedules. Navigate to the Work Schedules screen for more information.     ";
		JLabel workContent = new JLabel(workMess);
		JLabel workContent2 = new JLabel(workMess2);
		workContent.setFont(contentFont);
		workContent.setForeground(Color.green);
		workContent2.setFont(contentFont);
		workContent2.setForeground(Color.green);
		
		pane.add(workHeader);
		pane.add(workContent);
		pane.add(workContent2);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
		
		//creates all of the help data for customers
		JLabel custHeader = new JLabel("   Customers");
		custHeader.setFont(headerFont);
		custHeader.setForeground(Color.cyan);
		String custMess = "     Select \"View Customers\" on the home page in order to go to the customer data program. You will be able to check in    ";
		String custMess2 = "     customers and view customer logs. Navigate to the Customers screen for more information.";
		JLabel custContent = new JLabel(custMess);
		JLabel custContent2 = new JLabel(custMess2);
		custContent.setFont(contentFont);
		custContent.setForeground(Color.green);
		custContent2.setFont(contentFont);
		custContent2.setForeground(Color.green);
		
		pane.add(custHeader);
		pane.add(custContent);
		pane.add(custContent2);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
		
		//-----------------------------------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to FEC Home Page");
		
		Font btnFont = new Font("",1,25);
		returnBtn.setFont(btnFont);
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.lightGray);
		
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
		
	}
	
	private static void createAndShowMainHelp() {

		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JComponent main = new helpMain();
	    main.setOpaque(true);
	       
	    frame.setContentPane(main);
		frame.setSize(700, 690);
		
		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	 }
	
	public static void toMainHelpGUI() throws IOException
	{
		createAndShowMainHelp();
	}
	
//	public static void main(String[] args) {
//
//		javax.swing.SwingUtilities.invokeLater(new Runnable() 
//		{
//			public void run()
//				{
//					createAndShowMainHelp();
//				}
//		}
//	);
//	}
	
}
