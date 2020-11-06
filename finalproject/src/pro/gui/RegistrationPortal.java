package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Rectangle;
import java.awt.Dimension;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Toolkit;

public class RegistrationPortal extends JFrame implements ActionListener
{

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationPortal frame = new RegistrationPortal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public RegistrationPortal() 
	{
		setIconImage(Toolkit.getDefaultToolkit().getImage(RegistrationPortal.class.getResource("/pro/images/homenew.jpg")));
	
		setTitle("Home");
		createGui();
	}
	public void createGui()
	{
		
		setBackground(new Color(95, 158, 160));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 760);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnStudentRegistration = new JButton("Student Registration");
		btnStudentRegistration.setFont(new Font("Gabriola", Font.BOLD, 18));
		btnStudentRegistration.addActionListener(this);
		btnStudentRegistration.setBounds(643,355 , 222, 48);
		contentPane.add(btnStudentRegistration);
		
		JButton btnBusEntry = new JButton("Bus Entry");
		btnBusEntry.setFont(new Font("Gabriola", Font.BOLD, 18));
		btnBusEntry.addActionListener(this);
		btnBusEntry.setBounds(643, 477, 236, 48);
		contentPane.add(btnBusEntry);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		menuBar.setBounds(0, 0, 1366, 45);
		contentPane.add(menuBar);
		
		JMenu mnStudentdetails = new JMenu("                    StudentDetails                    ");
		mnStudentdetails.setFont(new Font("Gabriola", Font.BOLD, 17));
		mnStudentdetails.setSize(new Dimension(456, 0));
		mnStudentdetails.setBounds(new Rectangle(0, 0, 456, 21));
		menuBar.add(mnStudentdetails);
		mnStudentdetails.setBounds(0, 0, 455, 21);
		
		JMenuItem mnview = new JMenuItem("View Student List");
		mnview.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnview.addActionListener(this);
		mnview.setBorder(new LineBorder(new Color(0, 0, 0), 3));
		mnStudentdetails.add(mnview);
		
		JMenuItem mnedit = new JMenuItem("EditDetails");
		mnedit.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnStudentdetails.add(mnedit);
		mnedit.addActionListener(this);
		
		JMenu mnBusdetails = new JMenu("                    BusDetails                    ");
		mnBusdetails.setFont(new Font("Gabriola", Font.BOLD, 18));
		menuBar.add(mnBusdetails);
		
		JMenuItem mnnview = new JMenuItem("View Bus List");
		mnnview.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnnview.addActionListener(this);
		mnBusdetails.add(mnnview);
		
		JMenuItem mnnedit = new JMenuItem("Edit Bus Details");
		mnnedit.addActionListener(this);
		mnnedit.setFont(new Font("Gabriola", Font.BOLD, 18));
		
		mnBusdetails.add(mnnedit);
		
		JMenu mnDriverdetails = new JMenu("                    DriverDetails                    ");
		mnDriverdetails.addActionListener(this);
		mnDriverdetails.setFont(new Font("Gabriola", Font.BOLD, 18));
		menuBar.add(mnDriverdetails);
		
		JMenuItem mndedit = new JMenuItem("View Driver List");
		mndedit.setFont(new Font("Gabriola", Font.BOLD, 18));
		mndedit.addActionListener(this);
		mnDriverdetails.add(mndedit);
		
		JMenuItem mndview = new JMenuItem("Edit Driver Details");
		mndview.setFont(new Font("Gabriola", Font.BOLD, 18));
		mndview.addActionListener(this);
		mnDriverdetails.add(mndview);
		
		JMenuItem mntmAddNewDriver = new JMenuItem("Add New  Driver");
		mntmAddNewDriver.addActionListener(this);
		mntmAddNewDriver.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnDriverdetails.add(mntmAddNewDriver);
		
		JMenu mnSearch = new JMenu("                    Search                    ");
		mnSearch.addActionListener(this);
		mnSearch.setFont(new Font("Gabriola", Font.BOLD, 18));
		menuBar.add(mnSearch);
		
		JMenuItem mntmSearchStudent = new JMenuItem("Search Student");
		mntmSearchStudent.addActionListener(this);
		mntmSearchStudent.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnSearch.add(mntmSearchStudent);
		
		JMenuItem mntmSearchBus = new JMenuItem("Search Bus");
		mntmSearchBus.addActionListener(this);
		mntmSearchBus.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnSearch.add(mntmSearchBus);
		
		JMenuItem mntmSearchDriver = new JMenuItem("Search Driver");
		mntmSearchDriver.addActionListener(this);
		mntmSearchDriver.setFont(new Font("Gabriola", Font.BOLD, 18));
		mnSearch.add(mntmSearchDriver);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("                    LogOut                    ");
		mntmNewMenuItem.addActionListener(this);
		mntmNewMenuItem.setFont(new Font("Gabriola", Font.BOLD, 18));
		menuBar.add(mntmNewMenuItem);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(RegistrationPortal.class.getResource("/pro/images/regback.jpg")));
		lblNewLabel.setBounds(0, 43, 1366, 720);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String caption=e.getActionCommand();
		if(caption.equalsIgnoreCase("Student Registration"))
		{
			CheckAvailability ck= new CheckAvailability();
			ck.setVisible(true);
			this.dispose();
		}
		if(caption.equalsIgnoreCase("Bus Entry"))
		{
			Bus bse = new Bus();
			bse.setVisible(true);
			this.dispose();
		}
		if(caption.equalsIgnoreCase("View Student List"))
		{
			MyTable mt = new MyTable();
			mt.setVisible(true);
			
		}
		if(caption.equalsIgnoreCase("EditDetails"))
		{
			StudentEdit se=new StudentEdit();
			se.setVisible(true);
		}
		if(caption.equals("                    LogOut                    "))
		{
			AdminLogin adl=  new AdminLogin();
			adl.setVisible(true);
			this.dispose();
			
		}
		if(caption.equals("View Driver List"))
		{
			DriverTable dt= new DriverTable();
			dt.setVisible(true);
			
					
		}
		if(caption.equals("View Bus List"))
		{
			BusTable bt= new BusTable();
			bt.setVisible(true);
		}
		if(caption.equals("Edit Bus Details"))
		{
			BusEdit bt= new BusEdit();
			bt.setVisible(true);
		}
		if(caption.equals("Edit Driver Details"))
		{
			 DriverEdit dr= new DriverEdit();
			dr.setVisible(true);
			
					
		}
		if(caption.equals("Add New  Driver"))
		{
			 AddDriver dr= new AddDriver();
			dr.setVisible(true);
		}
		if(caption.equals("Search Student"))
		{
			
			SearchStudent se = new SearchStudent();
			se.setVisible(true);
		}
		if(caption.equals("Search Bus"))
		{
			
			ViewBus be = new ViewBus();
			be.setVisible(true);
		}
		if(caption.equals("Search Driver"))
		{
			
			SearchDriver de = new SearchDriver();
			de.setVisible(true);
		}
		
		
	}
}
