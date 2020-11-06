package pro.gui;
import java.awt.event.*;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import java.awt.Color;
import java.awt.Event;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.sql.*;
public class ViewBus extends JFrame implements ActionListener,KeyListener 
{

	private JComboBox comboBox;
	private JPanel contentPane;
	private PreparedStatement psdetail;
	private ResultSet rs;
	private Connection cn;
    
	static String bno,drid,tseats,aseats,rto,rfrom,st;
	
	

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewBus frame = new ViewBus();
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
	public ViewBus() 
	{
		cn=CrudOperation.createConnection();
		setTitle("View BusDetails");
		createGui();
	}
	public  void fillcombo()
	{

		try {
			String strsql="select busNo from busentry";
			psdetail=cn.prepareStatement(strsql);
			rs=psdetail.executeQuery();
			while(rs.next())
			{
				String busno=rs.getString("busNo");
				comboBox.addItem(busno);
						
			}
		
		}
		catch(SQLException se)
		{
			
			System.out.println(se);
		}
		
	
	}

	public void createGui()
	{

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusno = new JLabel("BusNo");
		lblBusno.setForeground(new Color(153, 0, 0));
		lblBusno.setFont(new Font("Gabriola", Font.BOLD, 45));
		lblBusno.setBounds(464, 188, 154, 39);
		contentPane.add(lblBusno);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.addKeyListener(this); 
		btnSubmit.setForeground(new Color(0, 0, 0));
		btnSubmit.setFont(new Font("Gabriola", Font.BOLD, 30));
		btnSubmit.setBounds(615, 391, 122, 39);
		contentPane.add(btnSubmit);
		
	 comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Select Bus Number"}));
		fillcombo();
		
		comboBox.setBounds(682, 188, 166, 39);
		contentPane.add(comboBox);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(ViewBus.class.getResource("/pro/images/15.gif")));
		label.setBounds(155, 58, 1000, 619);
		contentPane.add(label);
		
		JButton button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(ViewBus.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1309, 0, 41, 39);
		contentPane.add(button);

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) 
	{
		System.out.println(e.getKeyCode());
		if(e.getKeyCode()==10)
		{
			//insertData();
			showDetails();
		}
	}

	@Override
	public void keyReleased(KeyEvent e)
	{
	
		
	}
	
	public void showDetails()
	{
		
		String busNo=(String)comboBox.getSelectedItem();
		if(busNo.equals("Select busNo"))
		{
			JOptionPane.showMessageDialog(this, "select bus Number");
			
		}
		else {
			
			try {
				
				String strsql="select * from busentry where busNo=?";
				psdetail=cn.prepareStatement(strsql);
				psdetail.setString(1, busNo);
				System.out.println(psdetail);
				rs=psdetail .executeQuery();
				if(rs.next())
				{
					
					bno=rs.getString("busNo");
					drid=rs.getString("DriverId");
					tseats=rs.getString("TotalSeats");
					aseats=rs.getString("AvailableSeats");
					rto=rs.getString("RouteTo");
					rfrom=rs.getString("RouteFrom");
					st=rs.getString("status");
					
				}
					
					
					
					
				}
				catch(SQLException se)
				{
					
					System.out.println(se);
				}
				
			
			
			BusDetail bd= new BusDetail();
			bd.setVisible(true);
		}
		
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
	 String Caption= e.getActionCommand();
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}else {
	  
	
				showDetails();
	
	}}
		
	}
