
//********************************************************************
//FECMainScreen.java     Name: Nisha Patel    Last Update: 01/05/17
//
//Main GUI to display the FEC company's home page
//*********************************************************************

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class FECMainScreen extends JPanel{
	
	public FECMainScreen() {
		
		JPanel pane = new JPanel(new GridLayout(0, 1));
		
		JLabel greetLabel = new JLabel("  Welcome to Family Entertainment Center  ");
		
		Font headerFont = new Font("",1,40);
		greetLabel.setFont(headerFont);
		greetLabel.setForeground(Color.white);
		
		pane.add(greetLabel);
		
		//-------------------------------------------------------------
		
		JLabel blank;
		blank = new JLabel();
		pane.add(blank);
		
		//-------------------------------------------------------------
		
		JButton employBtn = new JButton("View Employees");
		
		Font employFont = new Font("",1,25);
		employBtn.setFont(employFont);
		employBtn.setBackground(Color.blue);
		employBtn.setForeground(Color.white);
		
		pane.add(employBtn);
		
		employBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.dispose();
            	
            	try {
            		//open Schedule GUI
            		fecEmployees.toEmployees();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
		});
		
		//-------------------------------------------------------------
		
		blank = new JLabel();
		pane.add(blank);
		
		//-------------------------------------------------------------
		
		JButton workBtn = new JButton("View Work Schedules");
		
		Font workFont = new Font("",1,25);
		workBtn.setFont(workFont);
		workBtn.setBackground(Color.cyan);
		workBtn.setForeground(Color.black);
		
		pane.add(workBtn);
		
		workBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.dispose();
            	
            	try {
            		//open Schedule GUI
            		ScheduleSelector.toHours();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
            }
		});
		
		
		//-------------------------------------------------------------
		
		blank = new JLabel();
		pane.add(blank);
		
		//-------------------------------------------------------------
		
		JButton customerBtn = new JButton("View Customers");
		
		Font selectFont = new Font("",1,25);
		customerBtn.setFont(selectFont);
		customerBtn.setBackground(Color.blue);
		customerBtn.setForeground(Color.white);
		
		pane.add(customerBtn);
		
		customerBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.dispose();
            	
            	try {
					fecCustomers.toCustomers();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
		//-------------------------------------------------------------
		
		blank = new JLabel();
		pane.add(blank);
				
		//-------------------------------------------------------------
				
		JButton helpBtn = new JButton("Help Menu");
		
		Font helpFont = new Font("",1,25);
		helpBtn.setFont(helpFont);
		helpBtn.setBackground(Color.cyan);
		helpBtn.setForeground(Color.black);
		
		pane.add(helpBtn);
		
		helpBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	frame.dispose();
            	
            	try {
					helpMain.toMainHelpGUI();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
            }
		});
		
		//-------------------------------------------------------------
				
		blank = new JLabel();
		pane.add(blank);
				
		//-------------------------------------------------------------
		
		JButton exitBtn = new JButton("Exit FEC Database");
		
		Font exitFont = new Font("",1,25);
		exitBtn.setFont(exitFont);
		exitBtn.setBackground(Color.blue);
		exitBtn.setForeground(Color.white);
		
		pane.add(exitBtn);
		
		exitBtn.addActionListener(new ActionListener(){
			
            @Override
            public void actionPerformed(ActionEvent e) {
            	
            	int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit the FEC database?", "Verification Screen", JOptionPane.YES_NO_OPTION);
				
				//confirms selection and disables if yes
				if (confirm == JOptionPane.YES_OPTION)
					{
            	
            	System.exit(0);
					}
            }
		});
		
		
		//-------------------------------------------------------------
		pane.setBackground(Color.black);
		add(pane, BorderLayout.LINE_START);
		//setBorder(BorderFactory.createEmptyBorder(20, 50, 40, 20));
	}
	
	private static JFrame frame;
	
	private static void createAndShowMainGUI() {

		frame = new JFrame("Family Entertainment Center");
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
				
		JComponent main = new FECMainScreen();
	    main.setOpaque(true);
	       
	    frame.setContentPane(main);
		frame.setSize(1010, 650);
		
		// Display the window.
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	 }
	
	public static void toMainGUI() throws IOException
	{
		createAndShowMainGUI();
	}
	
	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() 
		{
			public void run()
				{
					createAndShowMainGUI();
				}
		}
	);
	}

}
