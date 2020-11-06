package pro.gui;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.*;
import javax.swing.ImageIcon;
import java.awt.Font;
public class AddDriver extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtadrs;
	private JTextField txtno;
	private Connection cn;
	private PreparedStatement psdentry;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddDriver frame = new AddDriver();
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
	
	public AddDriver()
	{
		setTitle("Driver Details");
	    cn=CrudOperation.createConnection();
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
		
		JLabel lblDriverId = new JLabel("Driver ID");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblDriverId.setBounds(442, 185, 80, 17);
		contentPane.add(lblDriverId);
		
		txtid = new JTextField();
		txtid.setBounds(781, 183, 86, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblName.setBounds(442, 243, 56, 17);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(781, 240, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblAddress.setBounds(442, 297, 80, 20);
		contentPane.add(lblAddress);
		
		txtadrs = new JTextField();
		txtadrs.setBounds(781, 297, 86, 20);
		contentPane.add(txtadrs);
		txtadrs.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblContactNo.setBounds(443, 364, 98, 20);
		contentPane.add(lblContactNo);
		
		txtno = new JTextField();
		txtno.setBounds(781, 364, 86, 20);
		contentPane.add(txtno);
		txtno.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Gabriola", Font.BOLD, 25));
		btnSubmit.addActionListener(this);
		btnSubmit.setBounds(641, 475, 109, 37);
		contentPane.add(btnSubmit);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(AddDriver.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1320, 0, 33, 30);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(AddDriver.class.getResource("/pro/images/b6.jpg")));
		label.setBounds(0, 0, 1365, 730);
		contentPane.add(label);

	}
	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Id= txtid.getText();
		String name= txtname.getText();
		String address= txtadrs.getText();
		String contactno= txtno.getText();
	
		try {
			String caption= e.getActionCommand();
		if(caption.equals("Submit"))
		{
			String sql="insert into driverdetail(DriverId, Name, Address, ContactNo)values(?,?,?,?)"; 
					
						psdentry=cn.prepareStatement(sql);
						psdentry.setString(1, Id);
						psdentry.setString(2, name); 
						psdentry.setString(3,address); 
						psdentry.setString(4, contactno);
						int row=psdentry.executeUpdate();
						
						if(row>0)
						{
				       JOptionPane.showMessageDialog(this,"Driver details added successfully"); 
					
			} 
		 			 txtid.setText(""); 
					txtname.setText(""); 
					txtadrs.setText("");
					txtno.setText("");
					}	if(caption.equals(""))
					{
						RegistrationPortal rg= new RegistrationPortal();
						rg.setVisible(true);
						this.dispose();
					}
		}catch (SQLException e2) {
						e2.printStackTrace();
					}
					
				
		
	}
}
