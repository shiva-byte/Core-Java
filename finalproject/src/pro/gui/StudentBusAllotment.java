package pro.gui;
import java.sql.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ImageIcon;

public class StudentBusAllotment extends JFrame implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtalotid;
	private JTextField txtenrolid;
	private JTextField txtdrvrid;
	private JTextField txtbus;
	private JTextField txtrcptno;
	private JTextField txtyr;
	private Connection cn;
	private PreparedStatement psalot,psalot2;
	private ResultSet rsalot;
	private String Bus;
	private int rcv=0;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StudentBusAllotment frame = new StudentBusAllotment();
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


	public StudentBusAllotment() 
	{
		cn=CrudOperation.createConnection();
		setBounds(new Rectangle(240, 240, 240, 240));
		createGui();
		
		String sql="select * from busentry where busNo=?";
		try {
			psalot=cn.prepareStatement(sql);
			psalot.setString(1, CheckAvailability.b);
			rsalot =psalot.executeQuery();
			while(rsalot.next())
			{
				rcv=rsalot.getInt("AvailableSeats");
				String DriverId= rsalot.getString("DriverId");
				txtdrvrid.setText(DriverId);
				String busNo=rsalot.getString("busNo");
				txtbus.setText(busNo);
				txtenrolid.setText(StudentRegistration.enrol);
			
			
			}
		
	}catch(SQLException se)
		
		{
		System.out.println(se);
		}}

	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(500, 500, 500, 500));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Final Allotment");
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblAllotmentId = new JLabel("Allotment ID");
		lblAllotmentId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAllotmentId.setBackground(Color.BLACK);
		lblAllotmentId.setBounds(499, 50, 115, 34);
		getContentPane().add(lblAllotmentId);
		
		txtalotid = new JTextField();
		txtalotid.setBounds(762, 67, 86, 20);
		getContentPane().add(txtalotid);
		txtalotid.setColumns(10);
		
		JLabel lblEnrollmentId = new JLabel("Enrollment ID");
		lblEnrollmentId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblEnrollmentId.setBounds(497, 142, 117, 20);
	
		getContentPane().add(lblEnrollmentId);
		
		
		txtenrolid = new JTextField();
		txtenrolid.setBounds(762, 142, 86, 20);
		getContentPane().add(txtenrolid);
		txtenrolid.setColumns(10);
		
		JLabel lblDriverId = new JLabel("Driver ID");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblDriverId.setBounds(497, 210, 78, 17);
		getContentPane().add(lblDriverId);
		
		txtdrvrid = new JTextField();
		txtdrvrid.setBounds(762, 210, 86, 20);
		getContentPane().add(txtdrvrid);
		txtdrvrid.setColumns(10);
		
		JLabel lblBusNo = new JLabel("Bus No.");
		lblBusNo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblBusNo.setBounds(497, 276, 63, 28);
		getContentPane().add(lblBusNo);
		
		txtbus = new JTextField();
		txtbus.setBounds(762, 273, 86, 20);
		getContentPane().add(txtbus);
		txtbus.setColumns(10);
		
		JLabel lblRecieptNo = new JLabel("Reciept No.");
		lblRecieptNo.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblRecieptNo.setBounds(499, 334, 96, 28);
		getContentPane().add(lblRecieptNo);
		
		txtrcptno = new JTextField();
		txtrcptno.setBounds(762, 345, 86, 20);
		getContentPane().add(txtrcptno);
		txtrcptno.setColumns(10);
		
		JLabel lblYeafr = new JLabel("Year");
		lblYeafr.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblYeafr.setBounds(534, 418, 61, 28);
		getContentPane().add(lblYeafr);
		
		txtyr = new JTextField();
		txtyr.setBounds(762, 422, 86, 20);
		getContentPane().add(txtyr);
		txtyr.setColumns(10);
		
		JButton btnAllotBus = new JButton("Allot Bus");
		btnAllotBus.setFont(new Font("Gabriola", Font.BOLD, 24));
		btnAllotBus.addActionListener(this);
		btnAllotBus.setBounds(625, 562, 130, 49);
		contentPane.add(btnAllotBus);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(StudentBusAllotment.class.getResource("/pro/images/college-of-gwu-residence-halls.png")));
		label.setBounds(0, 0, 1350, 730);
		contentPane.add(label);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
		
		String caption=e.getActionCommand();
		if(caption.equals("Allot Bus"))
		{
			
	try {
			
			String sql2="update busentry set AvailableSeats = AvailableSeats - 1 where busNo=?";
			psalot2=cn.prepareStatement(sql2);
			psalot2.setString(1, CheckAvailability.b);
			int up= psalot2.executeUpdate();
			if(up>0)
			{
				System.out.println("updated");
			}
			
			
		} catch (SQLException e1) {
		
			e1.printStackTrace();
		}finally {
			try {
				psalot.close();
				psalot2.close();
				rsalot.close();
			} catch (SQLException e1) {
				
				e1.printStackTrace();
			}
			
		}
		try {
		String	id=txtenrolid.getText();
		String strinsert="insert into StudentBusAllotment(alotmentid,Enrollmentid,Driverid,BusNo,RecieptNo,Year) values(?,?,?,?,?,?)";
		psalot= cn.prepareStatement(strinsert);//compile there
		psalot.setString(1, txtalotid.getText());
		psalot.setString(2, txtenrolid.getText());
		psalot.setString(3, txtdrvrid.getText());
		psalot.setString(4, txtbus.getText());
		psalot.setString(5, txtrcptno.getText());
		psalot.setString(6, txtyr.getText());
		int row= psalot.executeUpdate();//insert query execute
		if(row>0)
		{
			JOptionPane.showMessageDialog(this,"Bus Alloted Successfully");
			txtalotid.setText("");
			txtenrolid.setText("");
			txtdrvrid.setText("");
			txtbus.setText("");
			txtrcptno.setText("");
			txtyr.setText("");
		}
		
		}catch(SQLException se) 
		{
			System.out.println(se);
		} 
	}
}
}