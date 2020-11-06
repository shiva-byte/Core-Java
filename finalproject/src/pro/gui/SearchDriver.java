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
import java.awt.Rectangle;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class SearchDriver extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private PreparedStatement psdelete,psdelete2;
	private Connection cn;
	public static String did;
	private int rw;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SearchDriver frame = new SearchDriver();
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
	public SearchDriver()
	{
		cn= CrudOperation.createConnection();
         createGui();
  
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(new Rectangle(0, 0, 1366, 768));
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 32));
		lblDriverId.setBounds(627, 271, 129, 41);
		contentPane.add(lblDriverId);
		
		txtid = new JTextField();
		txtid.setBounds(578, 358, 211, 35);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnUpdateDetails = new JButton("Search");
		btnUpdateDetails.addActionListener(this);
		btnUpdateDetails.setFont(new Font("Gabriola", Font.BOLD, 25));
		btnUpdateDetails.setBounds(614, 459, 142, 41);
		contentPane.add(btnUpdateDetails);
		
		JButton button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(SearchDriver.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 29);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(SearchDriver.class.getResource("/pro/images/college-of-gwu-residence-halls.png")));
		label.setBounds(0, 0, 1350, 729);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String Caption= e.getActionCommand();
		int confirm=0;
		did=txtid.getText();
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}else {
		if(did.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter the driverid", "Error", NORMAL);
		}
		else
		{
		
		if(Caption.equals("Search"))
		{
			if(checkdriver(did)==true) {
		
			ViewDriver du= new ViewDriver();
			du.setVisible(true);
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such DriverId found", "Wrong Credential", NORMAL);
			}
		}
		
			
			}
		
			
		}
	}
	
	public boolean checkdriver(String did)
	{
		
		try
		{
			String strsql="select DriverId from driverdetail where DriverId=?";
			psdelete2=cn.prepareStatement(strsql);
			psdelete2.setString(1, did);
			ResultSet rs = psdelete2.executeQuery();
			if(rs.next()) //next method to move in dataset
			return true;

}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return false;

		
		
	}

}
