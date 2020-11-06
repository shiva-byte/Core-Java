package pro.gui;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.dbtable.CrudOperation;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.ImageIcon;

public class BusEntry extends JFrame  implements ActionListener
{

	private JPanel contentPane;
	private JTextField txtbusno;
	private JTextField txtid;
	private JTextField txtavs;
	private JTextField txtrto;
	private JTextField txtrfrom;
	private JTextField txtstatus;
	private PreparedStatement psentry;
	private Connection cn;
	private JTextField txtts;
	private JButton button;
	private JLabel lblNewLabel;


	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BusEntry frame = new BusEntry();
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
	public BusEntry() 
	{
		
		setTitle("BusEntry");
		cn=CrudOperation.createConnection();
		createGui();
		
		
	}
	public void createGui()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	
		setBounds(00, 00, 1366, 768);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBusno = new JLabel("Bus No");
		lblBusno.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblBusno.setBounds(477, 163, 67, 37);
		contentPane.add(lblBusno);
		
		txtbusno = new JTextField();
		txtbusno.setFont(new Font("Gabriola", Font.BOLD, 15));
		txtbusno.setBounds(789, 188, 106, 20);
		contentPane.add(txtbusno);
		txtbusno.setColumns(10);
		
		JLabel lblDriverId = new JLabel("Driver Id");
		lblDriverId.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblDriverId.setBounds(477, 246, 86, 30);
		contentPane.add(lblDriverId);
		
		txtid = new JTextField();
		txtid.setBounds(793, 251, 102, 20);
		contentPane.add(txtid);
		txtid.setColumns(10);
		
		JLabel lblTotalSeats = new JLabel("Total Seats");
		lblTotalSeats.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblTotalSeats.setBounds(477, 310, 86, 30);
		contentPane.add(lblTotalSeats);
		
		JLabel lblAvailableBus = new JLabel("Available Seats");
		lblAvailableBus.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblAvailableBus.setBounds(477, 368, 120, 30);
		contentPane.add(lblAvailableBus);
		
		txtavs = new JTextField();
		txtavs.setBounds(793, 373, 102, 20);
		contentPane.add(txtavs);
		txtavs.setColumns(10);
		
		JLabel lblRouteTo = new JLabel("Route To");
		lblRouteTo.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblRouteTo.setBounds(477, 422, 86, 30);
		contentPane.add(lblRouteTo);
		
		txtrto = new JTextField();
		txtrto.setBounds(793, 427, 102, 20);
		contentPane.add(txtrto);
		txtrto.setColumns(10);
		
		JLabel lblRouteFrom = new JLabel("Route From");
		lblRouteFrom.setFont(new Font("Gabriola", Font.BOLD, 22));
		lblRouteFrom.setBounds(477, 479, 108, 30);
		contentPane.add(lblRouteFrom);
		
		txtrfrom = new JTextField();
		txtrfrom.setBounds(793, 489, 102, 20);
		contentPane.add(txtrfrom);
		txtrfrom.setColumns(10);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setFont(new Font("Gabriola", Font.BOLD, 23));
		lblStatus.setBounds(477, 539, 86, 41);
		contentPane.add(lblStatus);
		
		txtstatus = new JTextField();
		txtstatus.setBounds(793, 549, 102, 20);
		contentPane.add(txtstatus);
		txtstatus.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(this);
		btnSubmit.setFont(new Font("Gabriola", Font.BOLD, 22));
		btnSubmit.setBounds(653, 658, 137, 41);
		contentPane.add(btnSubmit);
		
		txtts = new JTextField();
		txtts.setBounds(793, 315, 102, 20);
		contentPane.add(txtts);
		txtts.setColumns(10);
		
		button = new JButton("");
		button.addActionListener(this);
		button.setIcon(new ImageIcon(BusEntry.class.getResource("/pro/images/adjusthome.jpg")));
		button.setBounds(1317, 0, 33, 30);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(BusEntry.class.getResource("/pro/images/Busdetail3.png")));
		lblNewLabel.setBounds(0, 0, 1350, 729);
		contentPane.add(lblNewLabel);
	}

	@Override
	public void actionPerformed(ActionEvent e) 
	{
	 String Busno= txtbusno.getText();
	 String Driverid= txtid.getText();
	 String Total= txtts.getText();
	 String Available= txtavs.getText();
	 String to= txtrto.getText();
	 String from= txtrfrom.getText();
	 String status = txtstatus.getText();
		try {
		
		String caption=e.getActionCommand();
		if(caption.equals("Submit"))
		{
			String sql="insert into busentry(busNo, DriverId, TotalSeats, AvailableSeats, RouteTo, RouteFrom, status)values(?,?,?,?,?,?,?)";
			psentry=cn.prepareStatement(sql);
		//	rsentry=psentry.executeQuery();
			psentry.setString(1, Busno);
			psentry.setString(2, Driverid);
			psentry.setString(3,Total);
			psentry.setString(4, Available);
			psentry.setString(5, to);
			psentry.setString(6, from);
			psentry.setString(7, status);
			int row=psentry.executeUpdate();
			if(row>0)
			{
				JOptionPane.showMessageDialog(this,"Bus details added successfully");
				
				
			txtbusno.setText("");
			txtid.setText("");
			txtts.setText("");
			txtavs.setText("");
			txtrto.setText("");
			txtrfrom.setText("");
			txtstatus.setText("");
			
			}
		}
		if(caption.equals(""))
		{
			RegistrationPortal rg= new RegistrationPortal();
			rg.setVisible(true);
			this.dispose();
		}
		}
		catch(SQLException se)
		{
			System.out.println(se);
		}
		
	}
}