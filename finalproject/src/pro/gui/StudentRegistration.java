package pro.gui;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.sql.*;
import javax.swing.ImageIcon;
public class StudentRegistration extends JFrame implements ActionListener 
{
    private Connection cn;
    private PreparedStatement psregister,psregister2;
	private JPanel contentPane;
	private JTextField txtid;
	private JTextField txtname;
	private JTextField txtadd;
	private JTextField txtno;
	private JButton btnRegister;
	private ResultSet rs;
	public static String enrol;

	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentRegistration frame = new StudentRegistration();
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
	public StudentRegistration() 
	{
		setResizable(false);
		setTitle("Student Registration");
		cn=CrudOperation.createConnection();
	
		createGui();
	}
	public void createGui()
	{

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1365, 768);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 128, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblEnrollmentid = new JLabel("EnrollmentID");
		lblEnrollmentid.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblEnrollmentid.setBounds(430, 127, 102, 24);
		contentPane.add(lblEnrollmentid);
		
		txtid = new JTextField();
		txtid.setBounds(784, 130, 102, 31);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblStudentName = new JLabel("Student Name");
		lblStudentName.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblStudentName.setBounds(441, 224, 102, 24);
		contentPane.add(lblStudentName);
		
		txtname = new JTextField();
		txtname.setBounds(788, 215, 98, 31);
		contentPane.add(txtname);
		txtname.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblAddress.setBounds(441, 313, 91, 24);
		contentPane.add(lblAddress);
		
		txtadd = new JTextField();
		txtadd.setBounds(788, 313, 98, 31);
		contentPane.add(txtadd);
		txtadd.setColumns(10);
		
		JLabel lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 20));
		lblContactNo.setBounds(441, 396, 102, 24);
		contentPane.add(lblContactNo);
		
		txtno = new JTextField();
		txtno.setBounds(788, 396, 98, 31);
		contentPane.add(txtno);
		txtno.setColumns(10);
		
		btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnRegister.addActionListener(this);
		btnRegister.setBounds(460, 514, 102, 37);
		contentPane.add(btnRegister);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Gabriola", Font.BOLD, 23));
		btnBack.addActionListener(this);
		btnBack.setBounds(758, 514, 89, 37);
		contentPane.add(btnBack);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(this);
		btnNewButton.setIcon(new ImageIcon(StudentRegistration.class.getResource("/pro/images/adjusthome.jpg")));
		btnNewButton.setBounds(1330, 0, 28, 31);
		contentPane.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentRegistration.class.getResource("/pro/images/buscliff.jpg")));
		label.setBounds(0, 0, 1358, 739);
		contentPane.add(label);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		String Caption= e.getActionCommand();
		
		
		enrol= txtid.getText();
		String name= txtname.getText();
		String Address= txtadd.getText();
		String Contact= txtno.getText();
		if(Caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}else {
		 if(Caption.equals("Back"))
				
		 {
		 	RegistrationPortal rp= new RegistrationPortal();
		 	rp.setVisible(true);
		 	this.dispose();
		 }
		 else
		 {

		if(name.isEmpty()||Address.isEmpty()||Contact.isEmpty())
		{
			JOptionPane.showMessageDialog(this, "Enter all the Student details");
		}
			
		else
		{
			if(Caption.equals("Register"))
			{
				if(checkalloted(enrol)==true)
				{
			try {
			String strreg="insert into studentreg(EnrollmentId,Name, Address, ContactNo)values(?,?,?,?)";
			psregister=cn.prepareStatement(strreg);
			psregister.setString(1, enrol);
			psregister.setString(2,name);
			psregister.setString(3,Address);
			psregister.setString(4,Contact);
			int row= psregister.executeUpdate();
			if (row>0)
			{
				JOptionPane.showMessageDialog(this, "registered successfully");
				txtname.setText("");
				txtadd.setText("");
				txtno.setText("");
				txtid.setText("");
			}
			
				
				
			}
			catch(SQLException se)
			{
				System.out.println(se);
			}
			StudentBusAllotment sba=new StudentBusAllotment();
			sba.setVisible(true);
			this.dispose();
		}
				else
					JOptionPane.showMessageDialog(this, "Bus already alloted to the student", "Information", NORMAL);
			
}
		
				}}}
}
	public boolean checkalloted(String enroll)
	{
		
		try
		{
			String strsql="select DriverId from studentbusallotment where Enrollmentid=?";
			psregister2=cn.prepareStatement(strsql);
			psregister2.setString(1, enroll);
			ResultSet rs = psregister2.executeQuery();
			if(rs.next()) //next method to move in dataset
			return false;

}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		return true;
	}
}
