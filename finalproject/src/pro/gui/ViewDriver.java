package pro.gui;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class ViewDriver extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet ps;
	private JLabel lbldid ;
	private JButton button;
	private JLabel lblbackground;
	private JLabel lblname;
	private JLabel lbladd;
	private JLabel lblcno;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewDriver frame = new ViewDriver();
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
	public ViewDriver() 
	{
		cn=CrudOperation.createConnection();
		createGui();
		
		
		try
    	{
	 		
    	String stpsql="select * from driverdetail where DriverId=?";
		psselect=cn.prepareStatement(stpsql);
		psselect.setString(1, SearchDriver.did);
		

		ps=psselect.executeQuery();
		while(ps.next())
		{
			String driver=ps.getString("DriverId");
			String name=ps.getString("Name");
			String address=ps.getString("Address");
			String contact=ps.getString("ContactNo");
			lbldid.setText(driver);
			lblname.setText(name);
			lbladd.setText(address);
			lblcno.setText(contact);
	
			
		}
		
    	}catch(SQLException sq)
    	{
    		System.out.println(sq);
    	}
		
		
		
		
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblDriverId.setBounds(414, 184, 99, 14);
		contentPane.add(lblDriverId);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblName.setBounds(420, 242, 81, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblAddress.setBounds(420, 309, 81, 14);
		contentPane.add(lblAddress);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblContactNo.setBounds(414, 379, 81, 14);
		contentPane.add(lblContactNo);
		
	    lbldid = new JLabel("");
		lbldid.setBounds(729, 175, 79, 23);
		contentPane.add(lbldid);

		lblname = new JLabel("");
		lblname.setBounds(722, 236, 86, 20);
		contentPane.add(lblname);
		
		lbladd = new JLabel("");
		lbladd.setBounds(722, 309, 86, 23);
		contentPane.add(lbladd);
		
		lblcno = new JLabel("");
		lblcno.setBounds(729, 379, 79, 23);
		contentPane.add(lblcno);
		JButton btnUpdate = new JButton("Back");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnUpdate.setBounds(551, 537, 139, 41);
		contentPane.add(btnUpdate);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(ViewDriver.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 33);
		contentPane.add(button);
		lblbackground = new JLabel("");
		lblbackground.setIcon(new ImageIcon(ViewDriver.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		lblbackground.setBounds(0, 0, 1350, 729);
		contentPane.add(lblbackground);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String Caption=e.getActionCommand();
		if (Caption.equals("Back"))
				{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
				}
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}

		

		
	}

}
