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
public class StudentDetails extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private PreparedStatement psselect,psupdate;
	private Connection cn;
	private java.sql.ResultSet rs;
	private JLabel lblenrol,lblname,lbladd,lblcont;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentDetails frame = new StudentDetails();
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
	public StudentDetails()
	{
		cn= CrudOperation.createConnection();
		createGui();
		
	
		
	 	try
    	{
	 		
    	String strsql="select * from studentreg where EnrollmentId=?";
		psselect=cn.prepareStatement(strsql);
		psselect.setString(1, SearchStudent.id);
		

		rs=psselect.executeQuery();
		while(rs.next())
		{
			String enrol=rs.getString("EnrollmentId");
			String name=rs.getString("Name");
			String adrs=rs.getString("Address");
			String cntct=rs.getString("ContactNo");
			
			lblenrol.setText(enrol);
			lblname.setText(name);
			lbladd.setText(adrs);
			lblcont.setText(cntct);
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
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name");
		lblName.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblName.setBounds(470, 276, 46, 14);
		contentPane.add(lblName);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAddress.setBounds(470, 331, 86, 25);
		contentPane.add(lblAddress);
		
		JLabel  lblContactNo = new JLabel("Contact No");
		lblContactNo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblContactNo.setBounds(470, 391, 108, 25);
		contentPane.add(lblContactNo);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment Id");
		lblEnrollmentId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblEnrollmentId.setBounds(470, 185, 108, 33);
		contentPane.add(lblEnrollmentId);
		
		 lblenrol = new JLabel("");
		lblenrol.setBounds(765, 185, 108, 25);
		contentPane.add(lblenrol);
		
		lblname = new JLabel("");
		lblname.setBounds(765, 265, 108, 25);
		contentPane.add(lblname);
		
		lbladd = new JLabel("");
		lbladd.setBounds(765, 342, 108, 14);
		contentPane.add(lbladd);
		
		lblcont = new JLabel("");
		lblcont.setBounds(765, 402, 108, 14);
		contentPane.add(lblcont);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Gabriola", Font.BOLD, 28));
		btnBack.addActionListener(this);
		btnBack.setBounds(610, 509, 108, 33);
		contentPane.add(btnBack);
		
		JLabel label_3 = new JLabel("");
		label_3.setIcon(new ImageIcon(StudentDetails.class.getResource("/pro/images/b6.jpg")));
		label_3.setBounds(0, 0, 1360, 730);
		contentPane.add(label_3);

	}
  
	@Override
	public void actionPerformed(ActionEvent e) 
	{

   
		
    	String Caption=e.getActionCommand();
		if (Caption.equals("Back"))
				{
				    RegistrationPortal rp=new RegistrationPortal();
				    rp.setVisible(true);
				    this.dispose();
				}
	}
}


