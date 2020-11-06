package pro.gui;
import java.awt.event.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;
import com.mysql.jdbc.ResultSet;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.sql.*;

import pro.gui.StudentEdit;
import javax.swing.ImageIcon;
import java.awt.Font;
public class StudentUpdate extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtname;
	private JTextField txtadrs;
	private JTextField txtcntct;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet rs;
	private JLabel lblenrol;
	private JButton button;
	private JLabel label;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentUpdate frame = new StudentUpdate();
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
	public StudentUpdate()
	{
		cn= CrudOperation.createConnection();
		createGui();
		
	
		
	 	try
    	{
	 		
    	String strsql="select * from studentreg where EnrollmentId=?";
		psselect=cn.prepareStatement(strsql);
		psselect.setString(1, StudentEdit.id);
		

		rs=psselect.executeQuery();
		while(rs.next())
		{
			String enrol=rs.getString("EnrollmentId");
			String name=rs.getString("Name");
			String adrs=rs.getString("Address");
			String cntct=rs.getString("ContactNo");
			
			lblenrol.setText(enrol);
			txtname.setText(name);
			txtadrs.setText(adrs);
			txtcntct.setText(cntct);
		}
		
    	}catch(SQLException sq)
    	{
    		System.out.println(sq);
    	}
		
			}
	
	
	
	
	
	public void createGui()
	{
		setTitle("Update Detail");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1365, 760);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblName.setBounds(476, 220, 53, 23);
		contentPane.add(lblName);
		
		txtname = new JTextField();
		txtname.setBounds(764, 221, 86, 20);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAddress.setBounds(476, 294, 79, 20);
		contentPane.add(lblAddress);
		
		txtadrs = new JTextField();
		txtadrs.setBounds(764, 294, 86, 20);
		contentPane.add(txtadrs);
		txtadrs.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblContactNo.setBounds(476, 365, 103, 20);
		contentPane.add(lblContactNo);
		
		txtcntct = new JTextField();
		txtcntct.setBounds(764, 365, 86, 20);
		contentPane.add(txtcntct);
		txtcntct.setColumns(10);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setFont(new Font("Gabriola", Font.BOLD, 29));
		btnUpdate.addActionListener(this);
		btnUpdate.setBounds(637, 468, 125, 49);
		contentPane.add(btnUpdate);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment Id");
		lblEnrollmentId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblEnrollmentId.setBounds(462, 142, 125, 23);
		contentPane.add(lblEnrollmentId);
		
		 lblenrol = new JLabel("");
		lblenrol.setBounds(764, 154, 86, 14);
		contentPane.add(lblenrol);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(StudentUpdate.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1316, 0, 33, 30);
		contentPane.add(button);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(StudentUpdate.class.getResource("/pro/images/upgrade-software-gestionale-illimitati.png")));
		label.setBounds(0, 0, 1349, 730);
		contentPane.add(label);

	}
  
	@Override
	public void actionPerformed(ActionEvent e) 
	{

   
		
    	String Caption=e.getActionCommand();
		if (Caption.equals("Update"))
				{
			
				try {
					 String strupdate="update studentreg set Name=?, Address=?, ContactNo=? where EnrollmentId=?";
			     
				    psupdate=cn.prepareStatement(strupdate);
					String name=txtname.getText();
					String adrs=txtadrs.getText();
					String cntct= txtcntct.getText();
					
					psupdate.setString(1, name);
					psupdate.setString(2, adrs);
					psupdate.setString(3, cntct);
					psupdate.setString(4, StudentEdit.id);
					int row1=psupdate.executeUpdate();
					if(row1>0)
					{
						
				JOptionPane.showMessageDialog(this, "dataupdated", "updation", JOptionPane.INFORMATION_MESSAGE);
				this.dispose();
				
					}
					

									
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


