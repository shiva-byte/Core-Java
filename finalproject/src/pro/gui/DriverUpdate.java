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

public class DriverUpdate extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtadd;
	private JTextField txtcno;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet rs;
	private JLabel lbldid ;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DriverUpdate frame = new DriverUpdate();
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
	public DriverUpdate() 
	{
		cn=CrudOperation.createConnection();
		createGui();
		
		
		try
    	{
	 		
    	String strsql="select * from driverdetail where DriverId=?";
		psselect=cn.prepareStatement(strsql);
		psselect.setString(1, DriverEdit.did);
		

		rs=psselect.executeQuery();
		while(rs.next())
		{
			String driver=rs.getString("DriverId");
			String name=rs.getString("Name");
			String address=rs.getString("Address");
			String contact=rs.getString("ContactNo");
			
			
			
			lbldid.setText(driver);
			txtname.setText(name);
			txtadd.setText(address);
			txtcno.setText(contact);
	
			
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
		
		txtname = new JTextField();
		txtname.setBounds(722, 239, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblAddress.setBounds(420, 309, 81, 14);
		contentPane.add(lblAddress);
		
		txtadd = new JTextField();
		txtadd.setBounds(722, 306, 86, 20);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 19));
		lblContactNo.setBounds(414, 379, 81, 14);
		contentPane.add(lblContactNo);
		
		txtcno = new JTextField();
		txtcno.setBounds(722, 376, 86, 20);
		contentPane.add(txtcno);
		txtcno.setColumns(10);
		
	    lbldid = new JLabel("");
		lbldid.setBounds(729, 175, 79, 23);
		contentPane.add(lbldid);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(this);
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnUpdate.setBounds(551, 537, 139, 41);
		contentPane.add(btnUpdate);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(DriverUpdate.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 33);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(DriverUpdate.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		label.setBounds(0, 0, 1350, 729);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		String Caption=e.getActionCommand();
		if (Caption.equals("Update"))
				{
			
				try {
					 String driverupdate="update driverdetail set Name=?, Address=?, ContactNo=? where DriverId=?";
			     
				    psupdate=cn.prepareStatement(driverupdate);
					String name=txtname.getText();
					String address=txtadd.getText();
					String contact= txtcno.getText();
					
					
					psupdate.setString(1, name);
					psupdate.setString(2, address);
					psupdate.setString(3, contact);
					psupdate.setString(4, DriverEdit.did);
					int row1=psupdate.executeUpdate();
					if(row1>0)
					{
						
				JOptionPane.showMessageDialog(this, "dataupdated", "updation", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				
					}
					this.dispose();
					

									
								}
								catch(SQLException  se)
								{
									
									System.out.println(se);
								}
								
							}
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}

		

		
	}

}
