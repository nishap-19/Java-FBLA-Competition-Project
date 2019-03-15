
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
//helpCustomers.java     Name: Nisha Patel     Date: 2/12/17
//
//help menu GUI for customer attendance logs
//*******************************************************************

public class helpCustomers extends JPanel{

private static JFrame frame;

	public helpCustomers() {
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		Font titleFont = new Font("",1,26);
		
		//creates the title for the help screen
		JLabel title = new JLabel("   Customer Log Help Menu");
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
		
		//help data for viewing customer log
		JLabel custHeader = new JLabel("   View Customer Log");
		custHeader.setFont(headerFont);
		custHeader.setForeground(Color.cyan);
		String custMess = "     Choose a customer attendance week from the drop down. Click on \"View Customers\" in order to view the customer log for the chosen week on  ";
		String custMess2 = "     the \"FEC Customer Log Viewer\" screen.";
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
		
		//help data for editing schedules
		JLabel addHeader = new JLabel("   Add Customers");
		addHeader.setFont(headerFont);
		addHeader.setForeground(Color.cyan);
		String addMess = "     On the \"FEC Customer Log\" screen, select the current weekly customer log and then select \"Add Customer\". Select the current day from the  ";
		String addMess2 = "     drop down and enter in the first and last name of the customer. Select \"Add Customer\" when you are finished.";
		JLabel addContent = new JLabel(addMess);
		JLabel addContent2 = new JLabel(addMess2);
		addContent.setFont(contentFont);
		addContent.setForeground(Color.green);
		addContent2.setFont(contentFont);
		addContent2.setForeground(Color.green);
		
		pane.add(addHeader);
		pane.add(addContent);
		pane.add(addContent2);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);

		//-----------------------------------------------------------------------------------------------
				
		//help data for creating new schedules
		JLabel printHeader = new JLabel("   Create New Cusomer Attendance Log");
		printHeader.setFont(headerFont);
		printHeader.setForeground(Color.cyan);
		String printMess = "      On the \"FEC Customer Log\" screen, select \"Create New Customer Log\". Enter in the date for the new weekly customer attendance log.    ";
		String printMess2 = "     Use the format MM/DD/YYYY for the date. Select \"Add New Week\" when you are finished.";
		JLabel printContent = new JLabel(printMess);
		JLabel printContent2 = new JLabel(printMess2);
		printContent.setFont(contentFont);
		printContent.setForeground(Color.green);
		printContent2.setFont(contentFont);
		printContent2.setForeground(Color.green);
		
		pane.add(printHeader);
		pane.add(printContent);
		pane.add(printContent2);
		
		//-----------------------------------------------------------------------------------------------

		blank = new JLabel();
		pane.add(blank);
						
		//-----------------------------------------------------------------------------------------------
		
		JButton returnBtn = new JButton("Return to Customer Logs");
		
		Font btnFont = new Font("",1,24);
		returnBtn.setFont(btnFont);
		returnBtn.setBackground(Color.blue);
		returnBtn.setForeground(Color.lightGray);
		
		returnBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
				int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to return to Customer Logs?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection
				if (confirm == JOptionPane.YES_OPTION)
					{
            		frame.dispose();
        		try {
        			fecCustomers.toCustomers();
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
	
	private static void createAndShowCustHelp() {

		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JComponent main = new helpCustomers();
	    main.setOpaque(true);
	    
		 JScrollPane scrollPane = new JScrollPane(main);
	        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
	        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
	    
	    frame.setContentPane(scrollPane);
		frame.setSize(870, 600);
		
		// Display the window.
		//frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	 }
	
	public static void toCustHelp() throws IOException
	{
		createAndShowCustHelp();
	}
	
//	public static void main(String[] args) {
//
//		javax.swing.SwingUtilities.invokeLater(new Runnable() 
//		{
//			public void run()
//				{
//					createAndShowCustHelp();
//				}
//		}
//	);
//	}
	
}
