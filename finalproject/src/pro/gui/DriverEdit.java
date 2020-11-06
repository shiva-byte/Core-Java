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

public class DriverEdit extends JFrame implements ActionListener
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
					DriverEdit frame = new DriverEdit();
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
	public DriverEdit()
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
		lblDriverId.setBounds(612, 262, 129, 41);
		contentPane.add(lblDriverId);
		
		txtid = new JTextField();
		txtid.setBounds(578, 358, 211, 35);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JButton btnUpdateDetails = new JButton("Update Details");
		btnUpdateDetails.addActionListener(this);
		btnUpdateDetails.setFont(new Font("Gabriola", Font.BOLD, 25));
		btnUpdateDetails.setBounds(432, 472, 188, 41);
		contentPane.add(btnUpdateDetails);
		
		JButton btnDeleteRecord = new JButton("Delete Record");
		btnDeleteRecord.addActionListener(this);
		btnDeleteRecord.setFont(new Font("Gabriola", Font.BOLD, 25));
		btnDeleteRecord.setBounds(801, 472, 175, 41);
		contentPane.add(btnDeleteRecord);
		
		JButton button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(DriverEdit.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 29);
		contentPane.add(button);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DriverEdit.class.getResource("/pro/images/college-of-gwu-residence-halls.png")));
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
		
		if(Caption.equals("Update Details"))
		{
			if(checkdriver(did)==true) {
		
			DriverUpdate du= new DriverUpdate();
			du.setVisible(true);
		}
			else
			{
				JOptionPane.showMessageDialog(this, "No such DriverId found", "Wrong Credential", NORMAL);
			}
		}
		if(Caption.equals("Delete Record"))
		{
			if(checkdriver(did)==true) 
			{
		
			  confirm = JOptionPane.showConfirmDialog(this, "are u sure to delete");
			if(confirm==0)
			{
			try
			{
			String sql="delete from driverdetail where DriverId=? ";
			psdelete= cn.prepareStatement(sql);
			psdelete.setString(1, did);
			rw=psdelete.executeUpdate();
			if(rw>0)
			{
				{
					JOptionPane.showMessageDialog(this, "Record Deleted Successfully");
				
				}
			}
			txtid.setText("");
			
		}catch(SQLException sq)
			{
			System.out.println(sq);
			}
			
			}
			}
			else {
				JOptionPane.showMessageDialog(this,"No such DriverId found");
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
